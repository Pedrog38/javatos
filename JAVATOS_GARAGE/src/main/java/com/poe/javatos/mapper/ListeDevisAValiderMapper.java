package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.ListeDevisAValiderForm;
public class ListeDevisAValiderMapper 
{
	public static ListeDevisAValiderForm remplirListeDevisAVForm(List<DevisForm> listeDevisForm)
	{
		ListeDevisAValiderForm listeDevisAV = new ListeDevisAValiderForm();
		listeDevisAV.setListeDevisForm(listeDevisForm);
		listeDevisAV.setIndexAnnuler(0);
		listeDevisAV.setIndexValider(0);
		listeDevisAV.setIndexVisualiser(0);
		return listeDevisAV;
	}
	
}
