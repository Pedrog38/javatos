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
import com.poe.javatos.form.CreationModelForm;
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
			model.addAttribute("creationModele",new CreationModelForm());
		}
		return "creationModele";
	}
	
	@PostMapping(value="/creerModele")
	public String creationModele(@Valid @ModelAttribute(value="creationModele")
	final CreationModelForm creationModelForm, final BindingResult bindingResult, final ModelMap model)
	{
		if (!bindingResult.hasErrors()) 
		{
			
			Model m = CreationModelMapper.remplirModel(creationModelForm);
			serviceModelCrud.createModel(m);
			
		}
		if(model.get("creationDevis")!=null)
		{
			return(crtlCreationDevis.afficherCreationDevis(model));
		}
		return ctrlAfficherListModel.afficherListeModel(model);  
		
	}
}
