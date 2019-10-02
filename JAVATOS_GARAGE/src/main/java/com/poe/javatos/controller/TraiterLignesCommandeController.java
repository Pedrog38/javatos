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
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.CommandeATraiterForm;
import com.poe.javatos.form.LigneCommandeATraiterForm;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.mapper.AssignationStockMapper;
import com.poe.javatos.mapper.CommandeATraiterMapper;
import com.poe.javatos.mapper.CommandeMapper;
import com.poe.javatos.mapper.LigneCommandeATraiterMapper;
import com.poe.javatos.mapper.LigneCommandeMapper;
import com.poe.javatos.mapper.ListeCommandeMapper;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

@Controller
@RequestMapping(value = {"/magasinier","/admin"}) // Mr Security
public class TraiterLignesCommandeController 
{
	@Autowired
	private IServiceCommandeCrud service;

	@Autowired
	private IServiceCommande serviceCommande;
	
	@Autowired
	private IServiceLigneCommande serviceLigneCommande;
	
	@Autowired
	private IServiceLigneCommandeCrud serviceLigneCommandeCrud;
	
	@Autowired
	private IServiceStock serviceStock;
	
	
	
	@GetMapping(value="/afficherLigneCommandeNouvelle")
	public String afficherLigneCommande(ModelMap model) {
		
		if(model.get("error")=="true")
		{
			return "traiterListeLignesCommande";
		}
		Commande commande = (Commande) model.get("CommandeAVisualiser");
		commande=serviceCommande.mettreAJourStatut(commande);
		
		
		List<LigneCommandeATraiterForm> listLCATFs = new ArrayList<>();
		List<LigneCommandeATraiterForm> listLCNonModifiableFs = new ArrayList<>();
		
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommandeNonRenseigne(commande.getId())) 
		{
			Stock s = serviceStock.findByIdModelStock(lc.getModel().getId());
			LigneCommandeATraiterForm ligneCommandeATF = LigneCommandeATraiterMapper.remplirLigneCommandeATraiterForm(lc,s);
			listLCATFs.add(ligneCommandeATF);
			
		}
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommandeRenseigne(commande.getId())) 
		{
			LigneCommandeATraiterForm ligneCommandeATNonModifiableF = LigneCommandeATraiterMapper.remplirLigneCommandeATraiterNonModifiableForm(lc);
			
			listLCNonModifiableFs.add(ligneCommandeATNonModifiableF);
		}
		Integer delai = serviceCommande.calculerDelaisCommande(commande);
		float prixHT = serviceCommande.calculerPrixHTCommande(commande);
		float prixTTC = serviceCommande.calculerPrixTTCCommande(commande);
		
		CommandeATraiterForm commandeATraiterForm = CommandeATraiterMapper.remplirCommandeATraiterForm(commande, delai, prixHT, prixTTC, listLCATFs, listLCNonModifiableFs);
		
		model.addAttribute("AfficherCommandeForm", commandeATraiterForm);
				
		return "traiterListeLignesCommande";
	}
	
	@PostMapping(value="/VisualiserLigneCommandeNouvelle")
	public String visualiserAfficherLigneCommandeNouvelle(@Valid @ModelAttribute(value="AfficherCommandeForm") 
	 final CommandeATraiterForm commandeATraiterForm,final BindingResult bindingResult, final ModelMap model)
	{
		Commande commande = service.findByIdCommande(commandeATraiterForm.getIdCommande());
		model.addAttribute("CommandeAVisualiser",commande);
		model.addAttribute("error","true");
		if(!bindingResult.hasErrors())
		{
			int index = commandeATraiterForm.getIndex();
			List<LigneCommandeATraiterForm> lignesCommandeForm =commandeATraiterForm.getListLigneCdForm();
			LigneCommandeATraiterForm formLigne= lignesCommandeForm.get(index);
			LigneCommande lc = serviceLigneCommandeCrud.findByIdLigneCommande(formLigne.getIdLigneCommande());
			Integer qteAReserver = formLigne.getQteAReserver();
			Integer qteACommander= formLigne.getQteACommander();
			Stock s = serviceStock.findByIdModelStock(formLigne.getIdModel());
			serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
			serviceStock.miseAjourAssignation(s, qteAReserver);
			serviceStock.commander(s, qteACommander);
			serviceLigneCommande.miseAJourStatut(lc);
			model.addAttribute("error","false");
		}
		return afficherLigneCommande(model);
	}
}
