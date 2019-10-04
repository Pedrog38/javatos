package com.poe.javatos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.controller.AfficherListeLignesDevisController;
import com.poe.javatos.controller.ValiderDevisController;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.form.ListeDevisAValiderForm;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.repository.IDevisRepository;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;

@Service
public class ServiceDevisImpl implements IServiceDevis 
{
	
	@Autowired
	IDevisRepository dao;
	
	@Autowired
	IServiceLigneDevis service;
	
	@Autowired
	IServiceDevisCrud serviceDevis;
	
	@Autowired
	IServiceCommandeCrud serviceCommande;
	
	@Autowired
	IServiceLigneCommandeCrud serviceLigneCommande;
	
	@Autowired
	AfficherListeLignesDevisController ctrlAfficheLigneDevis;
	
	@Autowired
	ValiderDevisController ctrlValiderDevis;
	
	@Override
	public List<Devis> findByStatutNouveauDevis() 
	{
		return dao.findByStatutDevis(StatutDevis.Nouveau);
	}

	@Override
	@Transactional
	public Float calculerPrixHTDevis(Devis d) throws POEException {	
		Float prixtotal = (float) 0;
		for (LigneDevis ld : service.findByIdDevisLigneDevis(d.getId())) {
			Float prixligne = service.calculerPrixLigneDevis(ld);
			
			prixtotal = prixligne + prixtotal;
		}
		
		return prixtotal;
	}

	@Override
	@Transactional
	public Integer calculerDelaisDevis(Devis d) throws POEException 
	{
		Integer delaiDevis = 0;
		for (LigneDevis ld : service.findByIdDevisLigneDevis(d.getId())) {
		Integer delaiLigneDevisEnCours = service.calculerDelaiLigneDevis(ld); 
		delaiDevis = Math.max(delaiDevis, delaiLigneDevisEnCours);
			
		}
		
		return delaiDevis;
	}

	@Override
	public Float calculerPrixTTCDevis(Devis d) throws POEException 
	{
		Float prixHT = calculerPrixHTDevis(d);
		Float TVA = prixHT*(d.getClient().getStatut().getTauxTva()/100);
		return prixHT+TVA;
	}

	@Override
	public String traiterDevis(ListeDevisAValiderForm listeDevisForm, ModelMap model) throws POEException 
	{
		if(listeDevisForm.getIndexVisualiser()!=null)
		{
			Integer idDevis = listeDevisForm.getListeDevisForm().get(listeDevisForm.getIndexVisualiser()).getIdDevis();
			model.addAttribute("IdDevisAVisualiser",idDevis) ;
			return this.ctrlAfficheLigneDevis.afficherLigneDevis(model);
		}
		else if(listeDevisForm.getIndexValider()!=null)
		{
			Devis d = serviceDevis.findByIdDevis(listeDevisForm.getListeDevisForm().get(listeDevisForm.getIndexValider()).getIdDevis());
			validerDevis(d);
		}
		else if(listeDevisForm.getIndexAnnuler()!=null)
		{
			Devis d = serviceDevis.findByIdDevis(listeDevisForm.getListeDevisForm().get(listeDevisForm.getIndexAnnuler()).getIdDevis());
			annulerDevis(d);
		}
		return ctrlValiderDevis.afficherDevisAValider(model);
	}

	@Override
	public Devis validerDevis(Devis d) 
	{
		d.setStatut(StatutDevis.Valide);
		Commande commande = new Commande();
		commande.setClient(d.getClient());
		commande.setCommercialResponsable(d.getCommercialResponsable());
		commande.setDateCreation(new Date());
		commande.setStatut(StatutCommande.Nouvelle);
		commande = serviceCommande.createCommande(commande);
		for (LigneDevis ld : d.getLignesDevis()) 
		{
			LigneCommande lc = new LigneCommande();
			lc.setCommande(commande);
			lc.setModel(ld.getModel());
			lc.setNbResvervees(0);
			lc.setQuantite(ld.getQuantite());
			lc.setStatut(StatutLigneCommande.NonRenseignee);
			lc = serviceLigneCommande.createLigneCommande(lc);
		}
		return dao.save(d);
	}

	@Override
	public Devis annulerDevis(Devis d) 
	{
		d.setStatut(StatutDevis.Annule);
		return dao.save(d);
	}

}
