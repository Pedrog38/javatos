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

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.AssignationStockForm;
import com.poe.javatos.form.ListeAssignationStockForm;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

@Controller
public class AssignationCommandeStockController 
{
	@Autowired
	IServiceLigneCommande serviceLigneCommande;
	
	@Autowired
	IServiceLigneCommandeCrud serviceLigneCommandeCrud;
	
	@Autowired
	IServiceStock serviceStock;
	
	@Autowired
	IServiceStockCrud serviceStockCrud;
	
	@GetMapping(value="/assignationAfficherListe")
	public String afficherListeAssignation(final ModelMap model)
	{
		ListeAssignationStockForm listFormAss = new ListeAssignationStockForm();
		List<AssignationStockForm> listAssignationForm = new ArrayList<AssignationStockForm>();
		List<LigneCommande> listLigneCommande = serviceLigneCommande.findByStatutEnCommandeFournisseurLignesCommande();
		for (LigneCommande ligneCommande : listLigneCommande) 
		{
			AssignationStockForm ass = new AssignationStockForm();
			ass.setLigneCommande(ligneCommande);
			Stock s = serviceStock.findByIdModelStock(ligneCommande.getModel().getId());
			ass.setStock(s);
			ass.setQteAReserve(0);
			listAssignationForm.add(ass);
		}
		listFormAss.setListAss(listAssignationForm);
		model.addAttribute("listAssignationForm",listFormAss);
	
		return "assignation";
	}
	
	@PostMapping(value="/assignationModifierLigne")
	public String validerLigneAssignation(@Valid @ModelAttribute(value="listAssignationForm") 
	 final ListeAssignationStockForm listFormAss,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			System.err.println("ASS = ");
			for (AssignationStockForm ass : listFormAss.getListAss()) 
			{
				System.err.println("ASS = "+ ass);
				if(ass.getQteAReserve()!=0)
				{
					LigneCommande lc = ass.getLigneCommande();
					Stock s = serviceStockCrud.findByIdStock(ass.getStock().getId());
					System.err.println("S = "+s);
					Integer qteAReserver = ass.getQteAReserve();
					System.err.println("BOOL = "+ass.isQteReserveOk());
					s= serviceStock.miseAjourAssignation(s, qteAReserver);
					lc=serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
				}
			}
			return "menu"; //TODO changer le chemin en "retour à la page appelante"
		}
		System.err.println(bindingResult);
		return afficherListeAssignation(model);  
	}
	
	

	
	
}
