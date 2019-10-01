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
import com.poe.javatos.form.CommandeForm;
import com.poe.javatos.form.LigneCommandeForm;
import com.poe.javatos.mapper.CommandeMapper;
import com.poe.javatos.mapper.LigneCommandeMapper;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherListeLignesCommandeController 
{


	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	private IServiceLigneCommande serviceLigneCommande;
	
	@GetMapping(value="/afficherLigneCommande")
	public String afficherLigneCommande(ModelMap model) {
		
		final Commande commande = (Commande) model.get("CommandeAVisualiser");
		
		List<LigneCommandeForm> lignesCommandeForm = new ArrayList<>();
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommande(commande.getId())) 
		{
			Integer delai = serviceLigneCommande.calculerDelaiLigneCommande(lc);
			float prixHT =serviceLigneCommande.calculerPrixLigneCommande(lc);
			
			LigneCommandeForm ligneCommandeForm = LigneCommandeMapper.remplirLigneCommandeForm(lc,delai,prixHT);
			
			lignesCommandeForm.add(ligneCommandeForm);
		}
		float prixHT =serviceCommande.calculerPrixHTCommande(commande);
		float prixTTC=serviceCommande.calculerPrixTTCCommande(commande);
		Integer delai= serviceCommande.calculerDelaisCommande(commande);
	
		CommandeForm commandeForm = CommandeMapper.remplirCommandeForm(commande, prixHT, prixTTC, delai, lignesCommandeForm);
		model.addAttribute("AfficherCommandeForm", commandeForm);
				
		return "afficherListeLignesCommande";
	}
}
