package com.poe.javatos.mapper;


import com.poe.javatos.bean.Model;
import com.poe.javatos.form.CreationModelForm;

public class CreationModelMapper 
{
	
	public static Model remplirModel(CreationModelForm creationModelForm)
	{
		Model m = new Model();
		m.setNom(creationModelForm.getNom());
		m.setPuissance(creationModelForm.getPuissance());
		m.setCouleur(creationModelForm.getCouleur());
		m.setDelaisProd(creationModelForm.getDelaisProd());
		m.setPrixVente(creationModelForm.getPrixVente());
		return m;
	}
	
	
}
