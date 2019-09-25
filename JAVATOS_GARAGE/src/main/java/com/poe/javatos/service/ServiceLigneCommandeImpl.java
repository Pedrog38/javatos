package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.repository.ILigneCommandeRepository;

@Service
public class ServiceLigneCommandeImpl implements IServiceLigneCommande {

	@Autowired
	ILigneCommandeRepository dao;
	
	@Autowired
	IServiceCommande serviceCommande;
	
	@Override
	public List<LigneCommande> findByIdCommandeLigneCommande(Integer idCommande) 
	{
		return dao.findByCommandeLigneCommande(idCommande);
	}

	@Override
	public List<LigneCommande> findByStatutEnCommandeFournisseurLignesCommande() 
	{
		return dao.findByStatutLignesCommande(StatutLigneCommande.EnCommandeFournisseur);
	}

	@Override
	public LigneCommande miseAJourAssignation(LigneCommande lc, Integer qteAReserver) 
	{
		lc.setNbResvervees(lc.getNbResvervees()+qteAReserver);
		if(lc.getNbResvervees()==lc.getQuantite())
		{
			lc.setStatut(StatutLigneCommande.Reservee);
			serviceCommande.mettreAJourStatut(lc.getCommande());
		}
		
		return dao.save(lc);
	}

	@Override
	public LigneCommande miseAJourStatut(LigneCommande lc) 
	{
		if(lc.getQuantite()==lc.getNbResvervees())
		{
			lc.setStatut(StatutLigneCommande.Reservee);
		}
		else
		{
			lc.setStatut(StatutLigneCommande.EnCommandeFournisseur);
		}
		return dao.save(lc);
	}

}
