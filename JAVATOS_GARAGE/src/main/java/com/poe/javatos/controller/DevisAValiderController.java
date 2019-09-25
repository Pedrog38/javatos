package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.form.DevisAValiderForm;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;

@Controller
public class DevisAValiderController {
	
	
	@Autowired
	private IServiceDevis servicedevis;
	
	@GetMapping(value="/DevisValidation")
	public String afficherDevis(final ModelMap model) {			
		final List<Devis> lsDevis = servicedevis.findByStatutNouveauDevis();
		
		List<DevisAValiderForm> lsAValider = new ArrayList<>();
		for (Devis devis : lsDevis) {
			DevisAValiderForm devisAV = new DevisAValiderForm();
			devisAV.setDevis(devis);
			devisAV.setPrixDevis(servicedevis.calculerPrix(devis));
			lsAValider.add(devisAV);
		} 
		model.addAttribute("listeDevisValiderForm", lsAValider);
		
		
		return "DevisAvalider";
			
		}
	}
	
	
	

