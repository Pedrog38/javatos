package com.poe.javatos.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Model;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;

@Controller
public class CreationDevisController {
	
	@Autowired
	private IServiceDevisCrud serviceDevisCrud;
	
	@Autowired
	private IServiceLigneDevisCrud serviceLigneDevisCrud;
	
	@Autowired
	private IServiceLigneDevis serviceLigneDevis;
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
	@GetMapping(value = "/afficherCreerDevis")
	public String afficherCreationDevis(final ModelMap model) {
		
		final List<Client> listeClients = serviceClientCrud.findAllClient();
		
		final List<Model> listeModels = serviceModelCrud.findAllModel();
		
		final List<CreationLigneDevisForm> listeFormLignesDevis = new ArrayList<CreationLigneDevisForm>();
		
		CreationLigneDevisForm creationLigneDevisForm = new CreationLigneDevisForm();
		
		listeFormLignesDevis.add(creationLigneDevisForm);
		
		model.addAttribute("clients", listeClients);
		model.addAttribute("models", listeModels);
		model.addAttribute("creationLigneDevis", creationLigneDevisForm);
		
		if(model.get("creationDevis")==null) {
			
			CreationDevisForm creationDevisForm = new CreationDevisForm();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			creationDevisForm.setDateCreation(format.format(date));
			
			List<CreationLigneDevisForm> cdfs = creationDevisForm.getLignesDevis();
			
			cdfs.add(new CreationLigneDevisForm());
			
			creationDevisForm.setLignesDevis(cdfs);
			
			model.addAttribute("creationDevis", creationDevisForm);
		}
		
		return "creationdevis";
	}

}
