package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.form.AfficherCommandeForm;
import com.poe.javatos.form.AfficherLigneCommandeForm;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherLignesCommandeController 
{

	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	private IServiceLigneCommande serviceLigneCommande;
	
	@GetMapping(value="/afficherLigneCommande")
	public String afficherLigneCommande(ModelMap model) {
		
		final Commande commande = (Commande) model.get("CommandeAVisualiser");
		
		AfficherCommandeForm affCd = new AfficherCommandeForm();
		List<AfficherLigneCommandeForm> lignesCommandeForm = new ArrayList<>();
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommande(commande.getId())) 
		{
			AfficherLigneCommandeForm aff = new AfficherLigneCommandeForm();
			aff.setNomModel(lc.getModel().getNom());
			aff.setQuantite(lc.getQuantite());
			aff.setDelai(serviceLigneCommande.calculerDelaiLigneCommande(lc));
			aff.setPrixHT(serviceLigneCommande.calculerPrixLigneCommande(lc));
			lignesCommandeForm.add(aff);
		}
		affCd.setListLigneCdForm(lignesCommandeForm);
		affCd.setCommandeDate(commande.getDateCreation().toString());
		affCd.setIdDevis(commande.getId());
		affCd.setIdCommande(commande.getId());
		affCd.setDelaiCommande(serviceCommande.calculerDelaisCommande(commande));
		affCd.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
		affCd.setPrixTotal(serviceCommande.calculerPrixCommande(commande));
		affCd.setStatutCommande(commande.getStatut());
		model.addAttribute("AfficherCommandeForm", affCd);
				
		return "LigneCommande";
	}
}
