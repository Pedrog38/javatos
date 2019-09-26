package com.poe.javatos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@Controller
public class affichageListeDevisController {
	
	@Autowired
	private IServiceDevisCrud service;

	@Autowired
	private IServiceDevis serviceDevis;

	
	@GetMapping(value="/afficherListeDevis")
	public String afficherListeDevis(ModelMap Model) {
		
		final List<Devis> lListeDevis = service.findAllDevis();
		final Map<Devis, Float> mapDevis = new HashMap<>();
		
		for (Devis devis : lListeDevis) {
			mapDevis.put(devis, serviceDevis.calculerPrixDevis(devis));
			System.err.println("idDevis "+ devis.getId() );
			
		}
		
		
		Model.addAttribute("mapDevis", mapDevis);
		

			
		 
		
		
		
		
		
		return "afficherListeDevis";
		
	}
}
