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
			boolean resTot = true;
			for (LigneCommande lcBis : lc.getCommande().getLignesCommandes()) 
			{
				resTot = resTot && lcBis.getStatut().equals(StatutLigneCommande.Reservee);
			}
			if(resTot)
			{
				lc.getCommande().setStatut(StatutCommande.Prete);
			}
			dao.save(lc);
		}
		return null;
	}

}
