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

import com.poe.javatos.bean.Commande;
import com.poe.javatos.form.CommandeForm;
import com.poe.javatos.form.ListeCommandeForm;
import com.poe.javatos.mapper.CommandeMapper;
import com.poe.javatos.mapper.ListeCommandeMapper;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherListeCommandeEnCours 
{
	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	AfficherListeLignesCommandeController ctrlAfficheLigneCommande;
	
	@GetMapping(value="/afficherCommandeEnCours")
	public String afficherListeCommandeEnCours(ModelMap model) 
	{
		final List<Commande> listCommandesPretes = serviceCommande.findByStatutPreteCommande();
		final List<Commande> listCommandesEnTraitement = serviceCommande.findByStatutEnTraitementCommande();
		List<CommandeForm> listeCommandeFormPrete = new ArrayList<>();
		List<CommandeForm> listeCommandeFormEnTraitement = new ArrayList<>();
		for (Commande commande : listCommandesPretes) 
		{
			float prixHT = serviceCommande.calculerPrixHTCommande(commande);
			float prixTTC = serviceCommande.calculerPrixTTCCommande(commande);
			Integer delai = serviceCommande.calculerDelaisCommande(commande);
			CommandeForm commandeForm = CommandeMapper.remplirCommandeForm(commande, prixHT, prixTTC, delai);
			listeCommandeFormPrete.add(commandeForm);
		}
		for (Commande commande : listCommandesEnTraitement) 
		{
			float prixHT = serviceCommande.calculerPrixHTCommande(commande);
			float prixTTC = serviceCommande.calculerPrixTTCCommande(commande);
			Integer delai = serviceCommande.calculerDelaisCommande(commande);
			CommandeForm commandeForm = CommandeMapper.remplirCommandeForm(commande, prixHT, prixTTC, delai);
			listeCommandeFormEnTraitement.add(commandeForm);
		}
		final ListeCommandeForm listeCommandeForm = ListeCommandeMapper.remplirListeCommandeForm(listeCommandeFormPrete,listeCommandeFormEnTraitement);
		model.addAttribute("ListeAfficherCommandeForm", listeCommandeForm);
				
		return "afficherListeCommandesEnCours";
	}
	
	@PostMapping(value="/VisualiserCommande")
	public String visualiserAfficherListeCommande(@Valid @ModelAttribute(value="ListeAfficherCommandeForm") 
	 final ListeCommandeForm listeCommandeForm,final BindingResult bindingResult, final ModelMap model)
	{
	
		return serviceCommande.traiterVisualiserLivrerCommande(listeCommandeForm, model);
	}
}
