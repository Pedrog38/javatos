package com.poe.javatos.mapper;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.LigneCommandeATraiterForm;

public class LigneCommandeATraiterMapper 
{
	public static LigneCommandeATraiterForm remplirLigneCommandeATraiterForm(LigneCommande lc, Stock s)
	{		
		LigneCommandeATraiterForm lignecommandeATraiterForm = new LigneCommandeATraiterForm();
		lignecommandeATraiterForm.setNomModel(lc.getModel().getNom());
		lignecommandeATraiterForm.setIdLigneCommande(lc.getId());
		lignecommandeATraiterForm.setIdModel(lc.getModel().getId());
		lignecommandeATraiterForm.setQteDispo(s.getQteDispo());
		lignecommandeATraiterForm.setStatut(lc.getStatut());
		lignecommandeATraiterForm.setQteDemande(lc.getQuantite());
		lignecommandeATraiterForm.setQteAReserver(Math.min(lc.getQuantite(), s.getQteDispo()));
		lignecommandeATraiterForm.setQteACommander(lignecommandeATraiterForm.getQteDemande()-lignecommandeATraiterForm.getQteAReserver());
		return lignecommandeATraiterForm;
	}
	
	public static LigneCommandeATraiterForm remplirLigneCommandeATraiterNonModifiableForm(LigneCommande lc)
	{		
		LigneCommandeATraiterForm lignecommandeATraiterForm = new LigneCommandeATraiterForm();
		lignecommandeATraiterForm.setNomModel(lc.getModel().getNom());
		lignecommandeATraiterForm.setIdLigneCommande(lc.getId());
		lignecommandeATraiterForm.setIdModel(lc.getModel().getId());
		lignecommandeATraiterForm.setStatut(lc.getStatut());
		lignecommandeATraiterForm.setQteDemande(lc.getQuantite());
		lignecommandeATraiterForm.setQteDejaReserve(lc.getNbResvervees());
		lignecommandeATraiterForm.setQteDejaCommandee(lc.getQuantite()-lc.getNbResvervees());
		return lignecommandeATraiterForm;
	}
}
