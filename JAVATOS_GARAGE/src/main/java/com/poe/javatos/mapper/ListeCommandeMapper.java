package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.form.CommandeForm;
import com.poe.javatos.form.ListeCommandeForm;

public class ListeCommandeMapper
{
	public static ListeCommandeForm remplirListeCommandeForm(List<CommandeForm> listCFs)
	{
		ListeCommandeForm form = new ListeCommandeForm();
		form.setListeCommandeForm(listCFs);
		return form;
	}
	
	public static ListeCommandeForm remplirListeCommandeForm(List<CommandeForm> listCFPretes, List<CommandeForm> listCFEnTraitements)
	{
		ListeCommandeForm form = new ListeCommandeForm();
		
		form.setListCommandeFormPretes(listCFPretes);
		form.setListCommandeFormEnTraitement(listCFEnTraitements);
		return form;
	}

}
