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
public class AfficherListeCommandeController 
{
	
	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	AfficherListeLignesCommandeController ctrlAfficheLigneCommande;
	
	@GetMapping(value="/historiqueCommandes")
	public String afficherListeCommande(ModelMap model) 
	{
		final List<Commande> cListeCommande = service.findAllCommande();
		List<CommandeForm> listeCommandeForm = new ArrayList<>();
		for (Commande commande : cListeCommande) 
		{
			float prixHT = serviceCommande.calculerPrixHTCommande(commande);
			float prixTTC = serviceCommande.calculerPrixTTCCommande(commande);
			Integer delai = serviceCommande.calculerDelaisCommande(commande);
			CommandeForm commandeForm = CommandeMapper.remplirCommandeForm(commande, prixHT, prixTTC, delai);
			listeCommandeForm.add(commandeForm);
		}
		final ListeCommandeForm grosseBoite = ListeCommandeMapper.remplirListeCommandeForm(listeCommandeForm);
		model.addAttribute("ListeAfficherCommandeForm", grosseBoite);
				
		return "afficherListeCommandes";
	}
	
	@PostMapping(value="/VisualiserListeCommande")
	public String visualiserAfficherListeCommande(@Valid @ModelAttribute(value="ListeAfficherCommandeForm") 
	 final ListeCommandeForm grosseBoite,final BindingResult bindingResult, final ModelMap model)
	{
		//System.err.println("Index = "+grosseBoite.getIndex());
		Integer idCommande = grosseBoite.getListeCommandeForm().get(grosseBoite.getIndex()).getIdCommande();
		//System.err.println("Id Commande Choisis = "+idCommande);
		Commande commande = service.findByIdCommande(idCommande);
		
		model.addAttribute("CommandeAVisualiser",commande) ;
	
		return this.ctrlAfficheLigneCommande.afficherLigneCommande(model);
	}
}
