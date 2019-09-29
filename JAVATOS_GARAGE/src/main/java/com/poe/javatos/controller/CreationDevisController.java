package com.poe.javatos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;
import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"})
public class CreationDevisController {
	
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
	@Autowired
	private IServiceLigneDevisCrud serviceLigneDevisCrud;
	
	@Autowired
	private IServiceLigneDevis serviceLigneDevis;
	
	@Autowired
	private IServiceDevis serviceDevis;
	
	@Autowired
	private IServiceDevisCrud serviceDevisCrud;
	
	@Autowired
	private IServiceUtilisateurCrud serviceUtilisateurCrud;
	
	@Autowired
	private AfficherLignesDevisController ctrl;
	
	
	@GetMapping(value = "/afficherCreerDevis")
	public String afficherCreationDevis(final ModelMap model) {
		
		final List<Client> listeClients = serviceClientCrud.findAllClient();
		
		final List<Model> listeModels = serviceModelCrud.findAllModel();
		
		model.addAttribute("clients", listeClients);
		model.addAttribute("models", listeModels);
		
		if(model.get("creationDevis")==null) {
			
			CreationDevisForm creationDevisForm = new CreationDevisForm();
			List<CreationLigneDevisForm> lp =  new ArrayList<CreationLigneDevisForm>();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			creationDevisForm.setSubmit("");
			
			creationDevisForm.setDateDevis(format.format(date));
			
			CreationLigneDevisForm cldf = new CreationLigneDevisForm();
			cldf.setQuantite(0);
			
			lp.add(cldf);
			
			creationDevisForm.setLignedevis(lp);
			model.addAttribute("creationDevis", creationDevisForm);
		}
		
		
		return "creationdevis";
	}
	
	@PostMapping(value = "/creerDevis")
	public String validerLigneDevis(@ModelAttribute(value="creationDevis") 
	final CreationDevisForm pForm, final BindingResult bindingResult, final ModelMap model) {
		System.err.println(pForm.getSubmit());
		if(pForm.getSubmit().equals("valid")) {
			System.err.println("valid");
			System.err.println(pForm);
			
			if (!bindingResult.hasErrors()) {
				
				List<CreationLigneDevisForm> lignes = pForm.getLignedevis();
				
				Devis d = new Devis();
				d.setClient(serviceClientCrud.findByIdClient(pForm.getIdClient()));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date dateCreation = format.parse(pForm.getDateDevis());
					d.setDateCreation(dateCreation);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				d.setStatut(StatutDevis.Nouveau);
				d.setCommercialResponsable(serviceUtilisateurCrud.findByIdUtilisateur(1));
				System.err.println(d);
				d=serviceDevisCrud.createDevis(d);
				
				List<LigneDevis> listLigneDevis = new ArrayList<>();
				for (CreationLigneDevisForm ligne : lignes) {
					
					if (ligne.getQuantite()!=0) {
						
						LigneDevis ligneDevis = new LigneDevis();
						ligneDevis.setDevis(d);
						ligneDevis.setModel(serviceModelCrud.findByIdModel(ligne.getIdModel()));
						ligneDevis.setQuantite(ligne.getQuantite());
						listLigneDevis.add(ligneDevis);
						serviceLigneDevisCrud.createLigneDevis(ligneDevis);
						
					}
					
					
				}
				//d=serviceDevisCrud.updateDevis(d);
				//d.setLignesDevis(listLigneDevis);
				
				model.addAttribute("IdDevisAVisualiser", d.getId());
				return ctrl.afficherLigneDevis(model);
			}
			
		}
		
		if(pForm.getSubmit().equals("add")) {
			CreationLigneDevisForm cldf = new CreationLigneDevisForm();
			cldf.setQuantite(0);
			pForm.getLignedevis().add(cldf);
			
			model.addAttribute("creationDevis", pForm);
			
		}
		
		return afficherCreationDevis(model);
	}

}
