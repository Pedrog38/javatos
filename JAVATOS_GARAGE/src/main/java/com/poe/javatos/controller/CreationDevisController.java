package com.poe.javatos.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Model;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;

@Controller
public class CreationDevisController {
	
	
	@Autowired
	private IServiceClientCrud serviceClientCrud;
	
	@Autowired
	private IServiceModelCrud serviceModelCrud;
	
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
	final CreationDevisForm pForm, final ModelMap model) {
		System.err.println(pForm.getSubmit());
		if(pForm.getSubmit().equals("valid")) {
			System.err.println("valid");
			
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
