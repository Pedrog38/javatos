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
	public String afficherListeCommande(ModelMap model) {
		
		final ListeCommandeForm grosseBoite = new ListeCommandeForm();
		final List<Commande> cListeCommande = serviceCommande.findByStatutNouvelleEnTraitementCommande();
		List<CommandeForm> listeCommandeForm = new ArrayList<>();
		for (Commande commande : cListeCommande) {
			CommandeForm commandeForm = new CommandeForm();
			commandeForm.setCommandeDate(commande.getDateCreation().toString());
			commandeForm.setIdCommande(commande.getId());
			commandeForm.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
			commandeForm.setPrixTotal(serviceCommande.calculerPrixCommande(commande));
			commandeForm.setStatutCommande(commande.getStatut());
			commandeForm.setDelaiCommande(serviceCommande.calculerDelaisCommande(commande));			
			listeCommandeForm.add(commandeForm);
			
		}
		grosseBoite.setListeCommandeForm(listeCommandeForm);
		model.addAttribute("ListeAfficherCommandeForm", grosseBoite);
				
		return "traiterListeCommandes";
	}
	
	@PostMapping(value="/VisualiserListeCommandeNouvelle")
	public String visualiserAfficherListeCommandeNouvelle(@Valid @ModelAttribute(value="ListeAfficherCommandeForm") 
	 final ListeCommandeForm grosseBoite,final BindingResult bindingResult, final ModelMap model)
	{
		System.err.println("Index = "+grosseBoite.getIndex());
		Integer idCommande = grosseBoite.getListeCommandeForm().get(grosseBoite.getIndex()).getIdCommande();
		System.err.println("Id Commande Choisis = "+idCommande);
		Commande commande = service.findByIdCommande(idCommande);
		
		model.addAttribute("CommandeAVisualiser",commande) ;
	
		return this.ctrlAfficheLigneCommandeNvlle.afficherLigneCommande(model);
	}
}
