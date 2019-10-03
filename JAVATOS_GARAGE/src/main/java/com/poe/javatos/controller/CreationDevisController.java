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
import com.poe.javatos.exception.POEException;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.mapper.CreationDevisMapper;
import com.poe.javatos.mapper.CreationLigneDevisMapper;
import com.poe.javatos.service.IServiceUtilisateur;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;
import com.poe.javatos.service.security.controller.SpringController;

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
	private IServiceDevisCrud serviceDevisCrud;
	
	@Autowired
	private IServiceUtilisateurCrud serviceUtilisateurCrud;
	
	@Autowired
	private IServiceUtilisateur serviceUtilisateur;
	
	@Autowired
	private AfficherListeLignesDevisController ctrl;
	
	@Autowired
	private SpringController SpringCtrl;
	
	
	@GetMapping(value = "/afficherCreerDevis")
	public String afficherCreationDevis(final ModelMap model) {
		
		final List<Client> listeClients = serviceClientCrud.findAllClient();
		
		final List<Model> listeModels = serviceModelCrud.findAllModel();
		
		model.addAttribute("clients", listeClients);
		model.addAttribute("models", listeModels);
		
		if(model.get("creationDevis")==null) {
			
			CreationDevisForm creationDevisForm = CreationDevisMapper.remplirCreationDevisForm();
			model.addAttribute("creationDevis", creationDevisForm);
			model.addAttribute("cheminFonction", serviceUtilisateur.getChemin(SpringCtrl.getUser().getBody().getId()));
		}
		
		
		return "creationDevis";
	}
	
	@PostMapping(value = "/creerDevis")
	public String validerLigneDevis(@ModelAttribute(value="creationDevis") 

	final CreationDevisForm creationDevisForm, final BindingResult bindingResult, final ModelMap model) throws POEException 
	{
//		System.err.println(pForm.getSubmit());
		if(creationDevisForm.getSubmit().equals("valid")) 
		{
//			System.err.println("valid");
//			System.err.println(pForm);
			
			if (!bindingResult.hasErrors()) 
			{
				
				List<CreationLigneDevisForm> lignes = creationDevisForm.getLignedevis();
				
				
				Client client = serviceClientCrud.findByIdClient(creationDevisForm.getIdClient());
				Utilisateur commercial = serviceUtilisateurCrud.findByIdUtilisateur(1);
				Devis devis = CreationDevisMapper.remplirCreationDevisForm(creationDevisForm, client, commercial);
				
				devis=serviceDevisCrud.createDevis(devis);
				
				List<LigneDevis> listLDs = new ArrayList<>();
				for (CreationLigneDevisForm ligneForm : lignes) 
				{
					
					if (ligneForm.getQuantite()!=0) 
					{
						Model modelVoiture = serviceModelCrud.findByIdModel(ligneForm.getIdModel());
						LigneDevis ligneDevis =CreationLigneDevisMapper.remplirCreationDevisForm(ligneForm, devis, modelVoiture);
						listLDs.add(ligneDevis);
						
						serviceLigneDevisCrud.createLigneDevis(ligneDevis);
						
					}
					
					
				}
				model.addAttribute("IdDevisAVisualiser", devis.getId());
				return ctrl.afficherLigneDevis(model);
			}
			
		}
		
		if(creationDevisForm.getSubmit().equals("add")) 
		{
			CreationLigneDevisForm cldf = new CreationLigneDevisForm();
			cldf.setQuantite(0);
			creationDevisForm.getLignedevis().add(cldf);
			
			model.addAttribute("creationDevis", creationDevisForm);
			model.addAttribute("cheminFonction", serviceUtilisateur.getChemin(SpringCtrl.getUser().getBody().getId()));
			
		}
		
		return afficherCreationDevis(model);
	}

}
