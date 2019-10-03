package com.poe.javatos.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.controller.AfficherListeCommandeEnCours;
import com.poe.javatos.controller.AfficherListeLignesCommandeController;
import com.poe.javatos.form.ListeCommandeForm;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.repository.ICommandeRepository;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@Service
public class ServiceCommandeImpl implements IServiceCommande 
{

	@Autowired
	ICommandeRepository dao;
	
	@Autowired
	IServiceCommandeCrud serviceCommande;  
	
	@Autowired
	IServiceLigneCommande serviceLigne;
	
	@Autowired
	AfficherListeLignesCommandeController ctrlAfficherListeLignesCommandeController ;
	
	@Autowired
	AfficherListeCommandeEnCours ctrlAfficherListeCommandeEnCours;
	
	@Override
	@Transactional
	public List<Commande> findByStatutNouvelleCommande() 
	{
		return dao.findByStatutCommande(StatutCommande.Nouvelle);
	}

	@Override
	@Transactional
	public List<Commande> findByStatutNouvelleEnTraitementCommande() 
	{
		List<Commande> commandes = dao.findByStatutsCommande(StatutCommande.Nouvelle,StatutCommande.EnTraitement);
		for (Commande commande : commandes) 
		{
			mettreAJourStatut(commande);
		}
		return dao.findByStatutsCommande(StatutCommande.Nouvelle,StatutCommande.EnTraitement);
	}
	
	@Override
	public List<Commande> findCommandeByLignesCommandeNonRenseigne() 
	{
		List<Commande> commmandes = dao.findByStatutCommande(StatutCommande.EnTraitement);
		List<Commande> commmandesReponses = new ArrayList<Commande>();
		for (Commande c : commmandes) 
		{
			boolean garder = true;
			for (LigneCommande lc : serviceLigne.findByIdCommandeLigneCommande(c.getId())) 
			{
				garder = garder && (lc.getStatut().equals(StatutLigneCommande.NonRenseignee));
			}
			if(garder)
			{
				commmandesReponses.add(c);
			}
		}
		
		return commmandesReponses;
	}
	@Override
	@Transactional
	public List<Commande> findByStatutsEnTraitementPreteCommande() 
	{
		return dao.findByStatutsCommande(StatutCommande.EnTraitement, StatutCommande.Prete);
	}

	@Override
	public Commande mettreAJourStatut(Commande c) 
	{
		//c=serviceCommande.findByIdCommande(c.getId());
		if(c.getStatut().equals(StatutCommande.EnTraitement))
		{			
			boolean resTot = true;
			for (LigneCommande lc : c.getLignesCommandes()) 
			{
				resTot = resTot && lc.getStatut().equals(StatutLigneCommande.Reservee);
				System.err.println("Statut en cours  = "+lc.getId()+" , "+lc.getStatut());
				System.err.println("RESTOT = "+resTot);
			}
			System.err.println("RESTOTFINAL = "+resTot);
			if(resTot)
			{
				c.setStatut(StatutCommande.Prete);
			}
		}
		else if (c.getStatut().equals(StatutCommande.Nouvelle))
		{
			c.setStatut(StatutCommande.EnTraitement);
		}
		return serviceCommande.updateCommande(c);
	}

	@Override
	public Integer calculerDelaisCommande(Commande c) {
		Integer delaiCommande = 0;
		for (LigneCommande lc : serviceLigne.findByIdCommandeLigneCommande(c.getId())) {
		Integer delaiLigneCommandeEnCours = serviceLigne.calculerDelaiLigneCommande(lc); 
		delaiCommande = Math.max(delaiCommande, delaiLigneCommandeEnCours);
			
		}
		
		return delaiCommande;
	}

	@Override
	public Float calculerPrixHTCommande(Commande c) {
		Float prixtotal = (float) 0;
		for (LigneCommande lc : serviceLigne.findByIdCommandeLigneCommande(c.getId())) {
			Float prixligne = serviceLigne.calculerPrixLigneCommande(lc);
			prixtotal = prixligne + prixtotal;
		}
		
		return prixtotal;
	}
	
	@Override
	public Float calculerPrixTTCCommande(Commande c) {
		Float prixHT = calculerPrixHTCommande(c);
		Float TVA = prixHT*(c.getClient().getStatut().getTauxTva()/100);
		return prixHT+TVA; 
	}

	@Override
	@Transactional
	public List<Commande> findCommandeATraiter() 
	{
		return dao.findCommandeByStatutLigneCommande(StatutLigneCommande.NonRenseignee);
	}

	@Override
	@Transactional
	public List<Commande> findByStatutEnTraitementCommande() 
	{
		return dao.findByStatutCommande(StatutCommande.EnTraitement);
	}

	@Override
	@Transactional
	public List<Commande> findByStatutPreteCommande() 
	{
		return dao.findByStatutCommande(StatutCommande.Prete);
	}

	@Override
	public String traiterVisualiserLivrerCommande(ListeCommandeForm listeCommandeForm, ModelMap model) 
	{
		if(listeCommandeForm.getIndexVisualisePrete()!=null)
		{
			Integer idCommande = listeCommandeForm.getListCommandeFormPretes().get(listeCommandeForm.getIndexVisualisePrete()).getIdCommande();
			model.addAttribute("IdCommandeAVisualiser",idCommande) ;
			return this.ctrlAfficherListeLignesCommandeController.afficherLigneCommande(model);
		}
		else if(listeCommandeForm.getIndexVisualiseEnTraitement()!=null)
		{
			Integer idCommande = listeCommandeForm.getListCommandeFormEnTraitement().get(listeCommandeForm.getIndexVisualiseEnTraitement()).getIdCommande();
			model.addAttribute("IdCommandeAVisualiser",idCommande) ;
			return this.ctrlAfficherListeLignesCommandeController.afficherLigneCommande(model);
		}
		else if(listeCommandeForm.getIndexLivrerPrete()!=null)
		{
			Integer idCommande = listeCommandeForm.getListCommandeFormPretes().get(listeCommandeForm.getIndexLivrerPrete()).getIdCommande();
			livrerCommande(serviceCommande.findByIdCommande(idCommande));
		}
		return ctrlAfficherListeCommandeEnCours.afficherListeCommandeEnCours(model);
	}

	@Transactional
	@Override
	public Commande livrerCommande(Commande c) 
	{
		c.setStatut(StatutCommande.Livree);
		return dao.save(c);
	}

	

}
