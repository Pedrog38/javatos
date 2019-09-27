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
import com.poe.javatos.form.AfficherDevisForm;
import com.poe.javatos.form.AfficherLigneDevisForm;
import com.poe.javatos.form.ListeAfficherDevisForm;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherLignesDevisController 
{

	@Autowired
	private IServiceDevisCrud service;

	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	private IServiceLigneDevis serviceLigneDevis;
	
	@GetMapping(value="/afficherLignesDevis")
	public String afficherLigneDevis(ModelMap model) {
		
		final Devis devis = (Devis) model.get("DevisAVisualiser");
		
		AfficherDevisForm affDevis = new AfficherDevisForm();
		List<AfficherLigneDevisForm> lignesDevisForm = new ArrayList<>();
		for (LigneDevis ld: devis.getLignesDevis()) 
		{
			AfficherLigneDevisForm aff = new AfficherLigneDevisForm();
			aff.setNomModel(ld.getModel().getNom());
			aff.setQuantite(ld.getQuantite());
			aff.setDelai(serviceLigneDevis.calculerDelaiLigneDevis(ld));
			aff.setPrixHT(serviceLigneDevis.calculerPrixLigneDevis(ld));
			lignesDevisForm.add(aff);
		}
		affDevis.setListLigneDevisForm(lignesDevisForm);
		affDevis.setDateDeCreation(devis.getDateCreation().toString());
		affDevis.setIdDevis(devis.getId());
		affDevis.setNomClient(devis.getClient().getPrenom()+" "+devis.getClient().getNom());
		affDevis.setPrixTotal(serviceDevis.calculerPrixDevis(devis));
		affDevis.setStatut(devis.getStatut());
		affDevis.setDelai(serviceDevis.calculerDelaisDevis(devis));
		model.addAttribute("AfficherDevisForm", affDevis);
				
		return "LigneDevis";
	}
}
