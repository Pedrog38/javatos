package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.LigneDevisForm;

public class LigneDevisMapper
{
	public static LigneDevisForm remplirListeDevisForm(LigneDevis ld,Integer delai,float prixHT)
	{
		LigneDevisForm listeDevis = new LigneDevisForm();
		listeDevis.setNomModel(ld.getModel().getNom());
		listeDevis.setQuantite(ld.getQuantite());
		listeDevis.setDelai(delai);
		listeDevis.setPrixHT(prixHT);
		return listeDevis;
	}

}
