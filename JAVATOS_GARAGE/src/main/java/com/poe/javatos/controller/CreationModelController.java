package com.poe.javatos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Model;
import com.poe.javatos.mapper.CreationModelMapper;
import com.poe.javatos.service.crud.IServiceModelCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"})
public class CreationModelController 
{
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
	@Autowired
	private CreationDevisController crtlCreationDevis;
	
	@Autowired
	private AfficherListeModelController ctrlAfficherListModel;
	
	@GetMapping(value="/creerModeleAfficher")
	public String afficherCreationModele(final ModelMap model)
	{
	
		if (model.get("creationModele")==null) 
		{
			model.addAttribute("creationModele",new CreationModelMapper());
		}
		return "creationModele";
	}
	
	@PostMapping(value="/creerModele")
	public String creationModele(@Valid @ModelAttribute(value="creationModele")
	final CreationModelMapper creationModelForm, final BindingResult bindingResult, final ModelMap model)
	{
		if (!bindingResult.hasErrors()) {
			
			Model m = new Model();
			m.setNom(creationModelForm.getNom());
			m.setPuissance(creationModelForm.getPuissance());
			m.setCouleur(creationModelForm.getCouleur());
			m.setDelaisProd(creationModelForm.getDelaisProd());
			m.setPrixVente(creationModelForm.getPrixVente());
			serviceModelCrud.createModel(m);
			
		}
		if(model.get("creationDevis")!=null)
		{
			return(crtlCreationDevis.afficherCreationDevis(model));
		}
		return ctrlAfficherListModel.afficherListeModel(model);  
		
	}
}
