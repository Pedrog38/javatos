package com.poe.javatos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Model;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;

@Controller
@RequestMapping(value="/commercial/")
public class CreationDevisController {
	
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
	@GetMapping(value = "/afficherCreerDevis")
	public String afficherCreationDevis(final ModelMap model) {
		
		final List<Client> listeClients = serviceClientCrud.findAllClient();
		
		final List<Model> listeModels = serviceModelCrud.findAllModel();
		
		model.addAttribute("clients", listeClients);
		model.addAttribute("models", listeModels);
		
		if(model.get("creationDevis")==null) {
			
			CreationDevisForm creationDevisForm = new CreationDevisForm();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			creationDevisForm.setDateCreation(format.format(date));
			
			model.addAttribute("creationDevis", creationDevisForm);
		}
		
		return "creationdevis";
	}
	
	@GetMapping(value = "/validerLigneDevis")
	public String validerLigneDevis(final ModelMap model) {
		
		return "creationdevis";
	}

}
