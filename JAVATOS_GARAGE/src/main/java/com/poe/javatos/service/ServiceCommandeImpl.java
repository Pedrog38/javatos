package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.LigneDevis;
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
	
	@Override
	public List<Commande> findByStatutNouvelleCommande() 
	{
		return dao.findByStatutCommande(StatutCommande.Nouvelle);
	}

	@Override
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
	public Float calculerPrixCommande(Commande c) {
		Float prixtotal = (float) 0;
		for (LigneCommande lc : serviceLigne.findByIdCommandeLigneCommande(c.getId())) {
			Float prixligne = serviceLigne.calculerPrixLigneCommande(lc);
			prixtotal = prixligne + prixtotal;
		}
		
		return prixtotal;
	}

	

}
