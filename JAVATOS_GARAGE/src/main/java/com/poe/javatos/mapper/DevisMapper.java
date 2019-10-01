package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.LigneDevisForm;

public class DevisMapper 
{
	public static DevisForm remplirDevisForm(Devis devis,float prixHT,float prixTTC, Integer delai)
	{
		DevisForm devisForm = new DevisForm();
		devisForm.setDateDeCreation(devis.getDateCreation().toString());
		devisForm.setIdDevis(devis.getId());
		devisForm.setNomClient(devis.getClient().getPrenom()+" "+devis.getClient().getNom());
		devisForm.setPrixTotalHT(prixHT);
		devisForm.setTaux(devis.getClient().getStatut().getTauxTva());
		devisForm.setPrixTotalTTC(prixTTC);
		devisForm.setStatut(devis.getStatut());
		devisForm.setDelai(delai);	
		return devisForm;
	}
	public static DevisForm remplirDevisForm(Devis devis,float prixHT,float prixTTC, Integer delai,List<LigneDevisForm> listLigneDevisForm)
	{
		DevisForm devisForm = remplirDevisForm(devis, prixHT, prixTTC, delai);
		devisForm.setListLigneDevisForm(listLigneDevisForm);
		return devisForm;
	}
}
