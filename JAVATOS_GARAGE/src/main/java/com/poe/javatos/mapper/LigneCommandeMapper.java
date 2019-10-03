package com.poe.javatos.mapper;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.form.LigneCommandeForm;

public class LigneCommandeMapper 
{
	public static LigneCommandeForm remplirLigneCommandeForm(LigneCommande lc, Integer delai, float prixHT)
	{
		LigneCommandeForm ligneCommandeForm = new LigneCommandeForm();
		ligneCommandeForm.setNomModel(lc.getModel().getNom());
		ligneCommandeForm.setQuantite(lc.getQuantite());
		ligneCommandeForm.setDelai(delai);
		ligneCommandeForm.setStatut(lc.getStatut());
		ligneCommandeForm.setPrixHT(prixHT);
		return ligneCommandeForm;
	}
	
}

