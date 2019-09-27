package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.form.AfficherDevisForm;
import com.poe.javatos.form.AfficherLigneDevisForm;
import com.poe.javatos.form.ListeAfficherDevisForm;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;

@Controller
public class affichageListeDevisController {
	
	@Autowired
	private IServiceDevisCrud service;

	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	private IServiceLigneDevis serviceLigneDevis;
	
	@GetMapping(value="/afficherListeDevis")
	public String afficherListeDevis(ModelMap model) {
		
		final ListeAfficherDevisForm grosseBoite = new ListeAfficherDevisForm();
		final List<Devis> lListeDevis = service.findAllDevis();
		List<AfficherDevisForm> listeDevisForm = new ArrayList<>();
		for (Devis devis : lListeDevis) {
			AfficherDevisForm devisForm = new AfficherDevisForm();
			devisForm.setDateDeCreation(devis.getDateCreation().toString());
			devisForm.setIdDevis(devis.getId());
			devisForm.setNomClient(devis.getClient().getPrenom()+" "+devis.getClient().getNom());
			devisForm.setPrixTotal(serviceDevis.calculerPrixDevis(devis));
			devisForm.setStatut(devis.getStatut());
			devisForm.setDelai(serviceDevis.calculerDelaisDevis(devis));			
			listeDevisForm.add(devisForm);
			
		}
		grosseBoite.setListeDevisForm(listeDevisForm);
		model.addAttribute("ListeAfficherDevisForm", grosseBoite);
				
		return "afficherListeDevis";
	}
	
	@PostMapping(value="/VisualiserListeDevis")
	public String visualiserAfficherListeDevis(@Valid @ModelAttribute(value="ListeAfficherDevisForm") 
	 final ListeAfficherDevisForm grosseBoite,final BindingResult bindingResult, final ModelMap model)
	{
		System.err.println("Index = "+grosseBoite.getIndex());
		Integer idDevis = grosseBoite.getListeDevisForm().get(grosseBoite.getIndex()).getIdDevis();
		System.err.println("Id Devis Choisis = "+idDevis);
		AfficherDevisForm affDevis = new AfficherDevisForm();
		Devis devis = service.findByIdDevis(idDevis);
		List<AfficherLigneDevisForm> lignesDevisForm = new ArrayList<>();
		for (LigneDevis ld: devis.getLignesDevis()) {
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
		
		//TODO
		return "afficherListeDevis";
	}
}
