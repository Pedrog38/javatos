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
import com.poe.javatos.form.AssignationStockForm;
import com.poe.javatos.form.ListeAssignationStockForm;
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
			
			
			List<AssignationStockForm> listAFs = new ArrayList<AssignationStockForm>();
			List<LigneCommande> listLCs = serviceLigneCommande.findByStatutEnCommandeFournisseurLignesCommande();
			for (LigneCommande lc : listLCs) 
			{
				Integer delai = serviceLigneCommande.calculerDelaiLigneCommande(lc);
				Stock s = serviceStock.findByIdModelStock(lc.getModel().getId());
				AssignationStockForm assignationStockForm = AssignationStockMapper.remplirAssignationStockForm(lc, delai, s);
				listAFs.add(assignationStockForm);
			}
			ListeAssignationStockForm listeAssignationForm = ListeAssignationStockMapper.remplirListeAssignationForm(listAFs);
			model.addAttribute("listAssignationForm",listeAssignationForm);
			
		}
	
		return "assignationStockCommande";
	}
	
	@PostMapping(value="/assignationModifierLigne")
	public String validerLigneAssignation(@Valid @ModelAttribute(value="listAssignationForm") 
	 final ListeAssignationStockForm listFormAss,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			int index = listFormAss.getIndex();
			AssignationStockForm ass =listFormAss.getListAss().get(index);
			LigneCommande lc = serviceLigneCommandeCrud.findByIdLigneCommande(ass.getIdLigneCommande());
			Stock s = serviceStockCrud.findByIdStock(ass.getIdStock());
			Integer qteAReserver = ass.getQteAReserve();
			s= serviceStock.miseAjourAssignation(s, qteAReserver);
			lc=serviceLigneCommande.miseAJourAssignation(lc, qteAReserver);
			List<AssignationStockForm> listAss =listFormAss.getListAss();
			listAss.remove(ass);
			if(!lc.getStatut().equals(StatutLigneCommande.Reservee))
			{				
				ass.setNbReserveLigneCommande(lc.getNbResvervees());
				ass.setQteDispoStock(s.getQteDispo());
				ass.setQteAReserve(Math.min(s.getQteDispo(), (lc.getQuantite()-lc.getNbResvervees())));
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
