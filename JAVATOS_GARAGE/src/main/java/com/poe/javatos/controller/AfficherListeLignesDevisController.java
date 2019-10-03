package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.LigneDevisForm;
import com.poe.javatos.mapper.DevisMapper;
import com.poe.javatos.mapper.LigneDevisMapper;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherListeLignesDevisController 
{

	@Autowired
	private IServiceDevisCrud service;

	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	private IServiceLigneDevis serviceLigneDevis;
	
	@GetMapping(value="/afficherLignesDevis")
	public String afficherLigneDevis(ModelMap model) throws POEException {
		
		final Devis devis = service.findByIdDevis((Integer)model.get("IdDevisAVisualiser"));
		
		float prixHT = serviceDevis.calculerPrixHTDevis(devis);
		float prixTTC = serviceDevis.calculerPrixTTCDevis(devis);
		Integer delai =serviceDevis.calculerDelaisDevis(devis);
		
		List<LigneDevisForm> lignesDevisForm = new ArrayList<>();
		for (LigneDevis ld: serviceLigneDevis.findByIdDevisLigneDevis(devis.getId())) 
		{
			Integer delaiLd = serviceLigneDevis.calculerDelaiLigneDevis(ld);
			float prixHTLd = serviceLigneDevis.calculerPrixLigneDevis(ld);
			LigneDevisForm ligneDevisForm = LigneDevisMapper.remplirListeDevisForm(ld, delaiLd, prixHTLd);
			lignesDevisForm.add(ligneDevisForm);
		}
		DevisForm devisForm = DevisMapper.remplirDevisForm(devis, prixHT, prixTTC, delai, lignesDevisForm);
		model.addAttribute("AfficherDevisForm", devisForm);
				
		return "afficherListeLignesDevis";
	}
}
