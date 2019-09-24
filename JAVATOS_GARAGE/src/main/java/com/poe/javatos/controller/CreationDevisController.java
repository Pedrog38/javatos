package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;

@Controller
public class CreationDevisController {
	
	@Autowired
	private IServiceDevisCrud serviceDevisCrud;
	
	@Autowired
	private IServiceLigneDevisCrud serviceLigneDevisCrud;
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@GetMapping(value = "/afficherCreerDevis")
	public String afficherCreationDevis(final ModelMap model) {
		
		final List<Client> listeClients = serviceClientCrud.findAllClient();
		
		model.addAttribute("clients", listeClients);
		
		return "creationdevis";
	}

}
