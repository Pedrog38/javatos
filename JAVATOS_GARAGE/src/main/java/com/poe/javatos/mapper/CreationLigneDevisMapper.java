package com.poe.javatos.mapper;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;
import com.poe.javatos.form.CreationLigneDevisForm;

public class CreationLigneDevisMapper 
{
		
	public static LigneDevis remplirCreationDevisForm(CreationLigneDevisForm creationLigneDevisForm, Devis devis, Model model)
	{
		LigneDevis ligneDevis = new LigneDevis();
		ligneDevis.setDevis(devis);
		ligneDevis.setModel(model);
		ligneDevis.setQuantite(creationLigneDevisForm.getQuantite());
		return ligneDevis;
	}
		
		
	
}
