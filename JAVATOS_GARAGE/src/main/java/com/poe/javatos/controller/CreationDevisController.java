package com.poe.javatos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;
import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@Controller
public class CreationDevisController {
	
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
	@Autowired
	private IServiceLigneDevisCrud serviceLigneDevisCrud;
	
	@Autowired
	private IServiceDevisCrud serviceDevisCrud;
	
	private IServiceUtilisateurCrud serviceUtilisateurCrud;
	
	
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
				List<Model> models = serviceModelCrud.findAllModel();
				List<Client> clients = serviceClientCrud.findAllClient();
				//List<Utilisateur> utilisateurs = serviceUtilisateurCrud.findAllUtilisateur();
				
				Devis d = new Devis();
				System.err.println(d);
				d.setClient(clients.get(pForm.getIdClient()));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date dateCreation = format.parse(pForm.getDateDevis());
					d.setDateCreation(dateCreation);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				d.setStatut("Nouveau");
				
				int delaisProd = 0;
				
				for (CreationLigneDevisForm ligne : lignes) {
					
					if (ligne.getQuantite()!=0) {
						
						LigneDevis ligneDevis = new LigneDevis();
						ligneDevis.setDevis(d);
						ligneDevis.setModel(models.get(ligne.getIdModel()));
						ligneDevis.setQuantite(ligne.getQuantite());
						delaisProd += models.get(ligne.getIdModel()).getDelaisProd();
						serviceLigneDevisCrud.createLigneDevis(ligneDevis);
					}
					
					
				}
				
				d.setDelaisProd(delaisProd);
				//d.setCommercialResponsable(utilisateurs.get(1));
				
				serviceDevisCrud.createDevis(d);
				
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
