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
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.LigneDevisForm;
import com.poe.javatos.form.ListeDevisForm;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;

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
	public String afficherLigneDevis(ModelMap model) {
		
		final Devis devis = service.findByIdDevis((Integer)model.get("IdDevisAVisualiser"));
		
		DevisForm affDevis = new DevisForm();
		List<LigneDevisForm> lignesDevisForm = new ArrayList<>();
		for (LigneDevis ld: serviceLigneDevis.findByIdDevisLigneDevis(devis.getId())) 
		{
			LigneDevisForm aff = new LigneDevisForm();
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
		affDevis.setPrixTotalHT(serviceDevis.calculerPrixHTDevis(devis));
		affDevis.setTaux(devis.getClient().getStatut().getTauxTva());
		affDevis.setPrixTotalTTC(serviceDevis.calculerPrixTTCDevis(devis));
		affDevis.setStatut(devis.getStatut());
		affDevis.setDelai(serviceDevis.calculerDelaisDevis(devis));
		model.addAttribute("AfficherDevisForm", affDevis);
				
		return "afficherListeLignesDevis";
	}
}
