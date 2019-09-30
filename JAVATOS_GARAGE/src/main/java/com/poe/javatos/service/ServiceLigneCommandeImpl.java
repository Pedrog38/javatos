package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.repository.ILigneCommandeRepository;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;

@Service
public class ServiceLigneCommandeImpl implements IServiceLigneCommande {

	@Autowired
	ILigneCommandeRepository dao;
	
	@Autowired
	IServiceCommande serviceCommande;
	
	@Autowired
	IServiceLigneCommandeCrud serviceLigneCommandeCrud;
	
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
		
		return serviceLigneCommandeCrud.updateLigneCommande(lc);
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
		return serviceLigneCommandeCrud.updateLigneCommande(lc);
	}

	@Override
	public Integer calculerDelaiLigneCommande(LigneCommande lc) {
		Integer delaiTotal = 0;
		delaiTotal = lc.getQuantite()* lc.getModel().getDelaisProd();
		return delaiTotal;
	}

	@Override
	public Float calculerPrixLigneCommande(LigneCommande lc) {
		Float prix = (float) 0;
		Float prixModel =(float) 0;
		Integer quantite =0;
		
		prixModel = lc.getModel().getPrixVente();
		quantite = lc.getQuantite();
		
		prix = prixModel * quantite;
		return prix;
	}

	@Override
	public List<LigneCommande> findByIdCommandeLigneCommandeNonRenseigne(Integer idCommande) 
	{
		return dao.findByCommandeLigneCommandeStatut(idCommande, StatutLigneCommande.NonRenseignee);
	}


}
