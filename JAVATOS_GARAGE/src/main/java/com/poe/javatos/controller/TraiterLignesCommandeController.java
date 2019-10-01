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
import com.poe.javatos.form.CommandeForm;
import com.poe.javatos.form.CommandeATraiterForm;
import com.poe.javatos.form.LigneCommandeForm;
import com.poe.javatos.form.LigneCommandeATraiterForm;
import com.poe.javatos.form.AssignationStockForm;
import com.poe.javatos.form.ListeCommandeForm;
import com.poe.javatos.global.StatutLigneCommande;
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
		CommandeATraiterForm affCd = new CommandeATraiterForm();
		List<LigneCommandeATraiterForm> lignesCommandeForm = new ArrayList<>();
		List<LigneCommandeATraiterForm> lignesCommandeNonModifiableForm = new ArrayList<>();
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommandeNonRenseigne(commande.getId())) 
		{
			LigneCommandeATraiterForm aff = new LigneCommandeATraiterForm();
			aff.setNomModel(lc.getModel().getNom());
			aff.setIdLigneCommande(lc.getId());
			aff.setIdModel(lc.getModel().getId());
			Stock s = serviceStock.findByIdModelStock(lc.getModel().getId());
			aff.setQteDispo(s.getQteDispo());
			aff.setStatut(lc.getStatut());
			aff.setQteDemande(lc.getQuantite());
			aff.setQteAReserver(Math.min(lc.getQuantite(), s.getQteDispo()));
			aff.setQteACommander(aff.getQteDemande()-aff.getQteAReserver());
			lignesCommandeForm.add(aff);
			
		}
		for (LigneCommande lc: serviceLigneCommande.findByIdCommandeLigneCommandeRenseigne(commande.getId())) 
		{
			System.err.println("LC = "+lc);
			LigneCommandeATraiterForm affNM = new LigneCommandeATraiterForm();
			affNM.setNomModel(lc.getModel().getNom());
			affNM.setIdLigneCommande(lc.getId());
			affNM.setIdModel(lc.getModel().getId());
			affNM.setStatut(lc.getStatut());
			affNM.setQteDemande(lc.getQuantite());
			affNM.setQteDejaReserve(lc.getNbResvervees());
			affNM.setQteDejaCommandee(lc.getQuantite()-lc.getNbResvervees());
			lignesCommandeNonModifiableForm.add(affNM);
			System.err.println("Ligne non modifiable : "+affNM);
		}
		affCd.setListLigneCdForm(lignesCommandeForm);
		affCd.setListLigneCdFormNonModifiable(lignesCommandeNonModifiableForm);
		affCd.setCommandeDate(commande.getDateCreation().toString());
		affCd.setIdDevis(commande.getId());
		affCd.setIdCommande(commande.getId());
		affCd.setDelaiCommande(serviceCommande.calculerDelaisCommande(commande));
		affCd.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
		affCd.setPrixTotal(serviceCommande.calculerPrixCommande(commande));
		affCd.setStatutCommande(commande.getStatut());
		model.addAttribute("AfficherCommandeForm", affCd);
				
		return "traiterListeLignesCommande";
	}
	
	@PostMapping(value="/VisualiserLigneCommandeNouvelle")
	public String visualiserAfficherLigneCommandeNouvelle(@Valid @ModelAttribute(value="AfficherCommandeForm") 
	 final CommandeATraiterForm affCd,final BindingResult bindingResult, final ModelMap model)
	{
		Commande commande = service.findByIdCommande(affCd.getIdCommande());
		model.addAttribute("CommandeAVisualiser",commande);
		model.addAttribute("error","true");
		if(!bindingResult.hasErrors())
		{
			int index = affCd.getIndex();
			System.err.println("INDEX = " +index);
			List<LigneCommandeATraiterForm> lignesCommandeForm =affCd.getListLigneCdForm();
			LigneCommandeATraiterForm formLigne= lignesCommandeForm.get(index);
			LigneCommande lc = serviceLigneCommandeCrud.findByIdLigneCommande(formLigne.getIdLigneCommande());
			Integer qteAReserver = formLigne.getQteAReserver();
			Integer qteACommander= formLigne.getQteACommander();
			Stock s = serviceStock.findByIdModelStock(formLigne.getIdModel());
			serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
			serviceStock.miseAjourAssignation(s, qteAReserver);
			System.err.println("Stock : "+s);
			System.err.println("qteACommander : "+qteACommander);
			System.err.println("qteAReserver : "+qteAReserver);
			serviceStock.commander(s, qteACommander);
			serviceLigneCommande.miseAJourStatut(lc);
			model.addAttribute("error","false");
		}
		System.err.println("ERR = "+bindingResult);
		return afficherLigneCommande(model);
	}
}
