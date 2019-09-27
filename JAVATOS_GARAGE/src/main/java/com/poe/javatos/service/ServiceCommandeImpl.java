package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
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
	
	@Override
	public List<Commande> findByStatutNouvelleCommande() 
	{
		return dao.findByStatutCommande(StatutCommande.Nouvelle);
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
		return serviceCommande.updateCommande(c);
	}

	

}
