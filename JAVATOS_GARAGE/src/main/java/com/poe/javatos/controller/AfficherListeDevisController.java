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
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.form.DevisForm;
import com.poe.javatos.form.ListeDevisForm;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;

@Controller
@RequestMapping(value= "/admin")
public class AfficherListeDevisController 
{
	
	@Autowired
	private IServiceDevisCrud service;

	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	AfficherListeLignesDevisController ctrlAfficheLigneDevis;
	
	@GetMapping(value="/afficherListeDevis")
	public String afficherListeDevis(ModelMap model) {
		
		final ListeDevisForm grosseBoite = new ListeDevisForm();
		final List<Devis> lListeDevis = service.findAllDevis();
		System.err.println("DEVIS 1 = "+lListeDevis.get(0));
		List<DevisForm> listeDevisForm = new ArrayList<>();
		for (Devis devis : lListeDevis) {
			DevisForm devisForm = new DevisForm();
			devisForm.setDateDeCreation(devis.getDateCreation().toString());
			devisForm.setIdDevis(devis.getId());
			devisForm.setNomClient(devis.getClient().getPrenom()+" "+devis.getClient().getNom());
			devisForm.setPrixTotalHT(serviceDevis.calculerPrixHTDevis(devis));
			devisForm.setTaux(devis.getClient().getStatut().getTauxTva());
			devisForm.setPrixTotalTTC(serviceDevis.calculerPrixTTCDevis(devis));
			devisForm.setStatut(devis.getStatut());
			System.err.println("DEVIS "+devis.getId()+" : "+devis.getLignesDevis());
			devisForm.setDelai(serviceDevis.calculerDelaisDevis(devis));			
			listeDevisForm.add(devisForm);
			
		}
		grosseBoite.setListeDevisForm(listeDevisForm);
		model.addAttribute("ListeAfficherDevisForm", grosseBoite);
				
		return "afficherListeDevis";
	}
	
	@PostMapping(value="/VisualiserListeDevis")
	public String visualiserAfficherListeDevis(@Valid @ModelAttribute(value="ListeAfficherDevisForm") 
	 final ListeDevisForm grosseBoite,final BindingResult bindingResult, final ModelMap model)
	{
		System.err.println("Index = "+grosseBoite.getIndex());
		Integer idDevis = grosseBoite.getListeDevisForm().get(grosseBoite.getIndex()).getIdDevis();
		System.err.println("Id Devis Choisis = "+idDevis);
		
		model.addAttribute("IdDevisAVisualiser",idDevis) ;
	
		return this.ctrlAfficheLigneDevis.afficherLigneDevis(model);
	}
}
