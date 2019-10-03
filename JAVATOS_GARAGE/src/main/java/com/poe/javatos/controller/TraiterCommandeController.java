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
@RequestMapping(value = {"/magasinier","/admin"}) // Mr Security
public class TraiterCommandeController 
{
	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	TraiterLignesCommandeController ctrlAfficheLigneCommandeNvlle;
	
	@GetMapping(value="/traiterCommande")
	public String afficherListeCommande(ModelMap model) 
	{
		
		
		
		
		
		
			
		final List<Commande> ListCommande = serviceCommande.findCommandeATraiter();
		List<CommandeForm> listCFs = new ArrayList<>();
		for (Commande commande : ListCommande) 
		{
			Integer delai = serviceCommande.calculerDelaisCommande(commande);
			float prixHT = serviceCommande.calculerPrixHTCommande(commande);
			float prixTTC = serviceCommande.calculerPrixTTCCommande(commande);
			
			CommandeForm commandeForm = CommandeMapper.remplirCommandeForm(commande, prixHT, prixTTC, delai);		
			listCFs.add(commandeForm);
		}
		
		final ListeCommandeForm listeCommandeForm = ListeCommandeMapper.remplirListeCommandeForm(listCFs);
		model.addAttribute("ListeAfficherCommandeForm", listeCommandeForm);
				
		return "traiterListeCommandes";
	}
	
	@PostMapping(value="/VisualiserListeCommandeNouvelle")
	public String visualiserAfficherListeCommandeNouvelle(@Valid @ModelAttribute(value="ListeAfficherCommandeForm") 
	 final ListeCommandeForm listeCommandeForm,final BindingResult bindingResult, final ModelMap model)
	{
		Integer idCommande = listeCommandeForm.getListeCommandeForm().get(listeCommandeForm.getIndex()).getIdCommande();
		Commande commande = service.findByIdCommande(idCommande);	
		model.addAttribute("CommandeAVisualiser",commande) ;
	
		return this.ctrlAfficheLigneCommandeNvlle.afficherLigneCommande(model);
	}
}
