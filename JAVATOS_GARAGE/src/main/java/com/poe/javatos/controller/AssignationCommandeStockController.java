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

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.mapper.AssignationStockMapper;
import com.poe.javatos.mapper.ListeAssignationStockMapper;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

@Controller
@RequestMapping(value = {"/magasinier","/admin"})
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
		if(model.get("listAssignationForm")==null)
		{			
			ListeAssignationStockMapper listFormAss = new ListeAssignationStockMapper();
			List<AssignationStockMapper> listAssignationForm = new ArrayList<AssignationStockMapper>();
			List<LigneCommande> listLigneCommande = serviceLigneCommande.findByStatutEnCommandeFournisseurLignesCommande();
			for (LigneCommande lc : listLigneCommande) 
			{
				AssignationStockMapper ass = new AssignationStockMapper();
				ass.setIdLigneCommande(lc.getId());
				ass.setNomClient(lc.getCommande().getClient().getPrenom()+" "+lc.getCommande().getClient().getNom());
				ass.setNomModel(lc.getModel().getNom());
				ass.setDelaisProd(serviceLigneCommande.calculerDelaiLigneCommande(lc));
				ass.setQuantiteLigneCommande(lc.getQuantite());
				ass.setNbReserveLigneCommande(lc.getNbResvervees());
				Stock s = serviceStock.findByIdModelStock(lc.getModel().getId());			
				ass.setIdStock(s.getId());
				ass.setQteDispoStock(s.getQteDispo());
				ass.setQteAReserve(0);
				listAssignationForm.add(ass);
			}
			listFormAss.setListAss(listAssignationForm);
			listFormAss.setIndex(0);
			model.addAttribute("listAssignationForm",listFormAss);
			
		}
	
		return "assignationStockCommande";
	}
	
	@PostMapping(value="/assignationModifierLigne")
	public String validerLigneAssignation(@Valid @ModelAttribute(value="listAssignationForm") 
	 final ListeAssignationStockMapper listFormAss,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			int index = listFormAss.getIndex();
			System.err.println("INDEX = " +index);
			AssignationStockMapper ass =listFormAss.getListAss().get(index);
			LigneCommande lc = serviceLigneCommandeCrud.findByIdLigneCommande(ass.getIdLigneCommande());
			Stock s = serviceStockCrud.findByIdStock(ass.getIdStock());
			Integer qteAReserver = ass.getQteAReserve();
			System.err.println("BOOL = "+ass.isQteReserveOk());
			s= serviceStock.miseAjourAssignation(s, qteAReserver);
			lc=serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
			List<AssignationStockMapper> listAss =listFormAss.getListAss();
			listAss.remove(ass);
			System.err.println("STATUT = "+lc.getStatut());
			if(!lc.getStatut().equals(StatutLigneCommande.Reservee))
			{				
				System.err.println("STATUT = "+lc.getStatut());
				ass.setNbReserveLigneCommande(lc.getNbResvervees());
				ass.setQteDispoStock(s.getQteDispo());
				ass.setQteAReserve(0);
				listAss.add(index, ass);
			}
			listFormAss.setListAss(listAss);
			model.addAttribute("listAssignationForm",listFormAss);
			
			
			//return "menu"; //TODO changer le chemin en "retour à la page appelante"
		}
		System.err.println(bindingResult);
		return afficherListeAssignation(model);  
	}
	
	

	
	
}
