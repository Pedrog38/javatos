package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.AssignationStockForm;
import com.poe.javatos.form.CreationClientForm;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;

@Controller
public class AssignationCommandeStockController 
{
	@Autowired
	IServiceLigneCommande serviceLigneCommande;
	
	@Autowired
	IServiceLigneCommandeCrud serviceLigneCommandeCrud;
	
	@Autowired
	IServiceStock serviceStock;
	
	@GetMapping(value="/assignationAfficherListe")
	public String afficherListeAssignation(final ModelMap model)
	{
		List<AssignationStockForm> listAssignationForm = new ArrayList<>();
		List<LigneCommande> listLigneCommande = serviceLigneCommande.findByStatutEnCommandeFournisseurLignesCommande();
		for (LigneCommande ligneCommande : listLigneCommande) 
		{
			AssignationStockForm ass = new AssignationStockForm();
			ass.setLigneCommande(ligneCommande);
			Stock s = serviceStock.findByIdModelStock(ligneCommande.getModel().getId());
			ass.setStock(s);
			listAssignationForm.add(ass);
		}
		model.addAttribute("listAssignationForm",listAssignationForm);
		if(model.get("assignationForm")==null)
		{
			model.addAttribute("assignationForm", new AssignationStockForm());
		}
		
		return "assignation";
	}
	
	@PostMapping(value="/assignationModifierLigne")
	public String validerLigneAssignation(@Valid @ModelAttribute(value="assignationForm") 
	 final AssignationStockForm assignationForm,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			LigneCommande lc = assignationForm.getLigneCommande();
			Stock s = assignationForm.getStock();
			Integer qteAReserver = assignationForm.getQteAReserve();
			s= serviceStock.miseAjourAssignation(s, qteAReserver);
			lc=serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
			
			
			return "menu"; //TODO changer le chemin en "retour à la page appelante"
		}
		return afficherListeAssignation(model);  
	}
	
	

	
	
}
