package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.ListeDevisForm;

public class ListeDevisMapper 
{
	public static ListeDevisForm remplirListeDevisForm(List<DevisForm> listeDevisForm)
	{
		ListeDevisForm listeDevis = new ListeDevisForm();
		listeDevis.setListeDevisForm(listeDevisForm);
		return listeDevis;
	}
	

}
