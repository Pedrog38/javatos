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
import com.poe.javatos.form.AfficherCommandeECForm;
import com.poe.javatos.form.ListeAfficherCommandeECForm;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) // Mr Security
public class AfficherListeCommandeECController 
{
	
	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	AfficherLignesCommandeECController ctrlAfficheLigneCommande;
	
	@GetMapping(value="/afficherCommandeEnCours")
	public String afficherListeCommandeEC(ModelMap model) {
		
		final ListeAfficherCommandeECForm grosseBoite = new ListeAfficherCommandeECForm();
		final List<Commande> cListeCommandeEC = service.findAllCommande();
		List<AfficherCommandeECForm> listeCommandeECForm = new ArrayList<>();
		for (Commande commande : cListeCommandeEC) {
			AfficherCommandeECForm commandeForm = new AfficherCommandeECForm();
			commandeForm.setCommandeDate(commande.getDateCreation().toString());
			commandeForm.setIdCommande(commande.getId());
			commandeForm.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
			commandeForm.setPrixTotal(serviceCommande.calculerPrixCommande(commande));
			commandeForm.setStatutCommande(commande.getStatut());
			commandeForm.setDelaiCommande(serviceCommande.calculerDelaisCommande(commande));			
			listeCommandeECForm.add(commandeForm);
			
		}
		grosseBoite.setListeCommandeECForm(listeCommandeECForm);
		model.addAttribute("ListeAfficherCommandeECForm", grosseBoite);
				
		return "afficherListeCommandeEnCours";
	}
	
	@PostMapping(value="/TraitementListeCommandeEC")
	public String TraitementListeCommandeEC(@Valid @ModelAttribute(value="ListeAfficherCommandeECForm") 
	 final ListeAfficherCommandeECForm grosseBoite,final BindingResult bindingResult, final ModelMap model)
	{
		if( grosseBoite.getIndexVisualiser() != null) {
		System.err.println("IndexVisualiser = "+grosseBoite.getIndexVisualiser());
		Integer idCommande = grosseBoite.getListeCommandeECForm().get(grosseBoite.getIndexVisualiser()).getIdCommande();
		System.err.println("Id Commande Choisis = "+idCommande);
		Commande commande = service.findByIdCommande(idCommande);
		model.addAttribute("CommandeAVisualiser",commande) ;
	
		return this.ctrlAfficheLigneCommande.afficherLigneCommande(model);
	
	} else if ( grosseBoite.getIndexLivrerClient() != null) {
		
		System.err.println("IndexLivrerClient = "+grosseBoite.getIndexLivrerClient());
		Integer idCommande = grosseBoite.getListeCommandeECForm().get(grosseBoite.getIndexLivrerClient()).getIdCommande();
		System.err.println("Id Commande Choisis = "+idCommande);
		Commande commande = service.findByIdCommande(idCommande);
		serviceCommande.livrerCommande(commande);
		
		return afficherListeCommandeEC(new ModelMap());
		
	}
		return afficherListeCommandeEC(model);
}
}







