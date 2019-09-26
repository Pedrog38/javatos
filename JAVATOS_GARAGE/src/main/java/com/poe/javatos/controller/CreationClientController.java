package com.poe.javatos.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.form.CreationClientForm;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceStatutClientCrud;

@Controller
@RequestMapping(value="/admin/")
public class CreationClientController 
{
	@Autowired
	private IServiceClientCrud serviceClientCurd;
	@Autowired
	private IServiceStatutClientCrud serviceStatutClientCurd;
	
	@GetMapping(value="/creerClientAfficher")
	public String afficherCreationClient(final ModelMap model)
	{
		final List<StatutClient> listeStatutClient = serviceStatutClientCurd.findAllStatutClient();
		model.addAttribute("statutList",listeStatutClient);
		if(model.get("creationClient")==null)
		{
			model.addAttribute("creationClient",new CreationClientForm());
		}
		return "creationClient";
	
	}
	
	@PostMapping(value="/creerClient")
	public String CreationClient(@Valid @ModelAttribute(value="creationClient") 
	 final CreationClientForm creationForm,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			Client c = new Client();
			c.setNom(creationForm.getNom());
			c.setPrenom(creationForm.getPrenom());
			c.setDateCreation(new Date());
			c.setAdresse(creationForm.getAdresse());
			c.setMail(creationForm.getMail());
			c.setSexe(creationForm.getSexe());
			c.setTelephone(creationForm.getTelephone());
			c.setStatut(creationForm.getStatutClient());
			serviceClientCurd.createClient(c);
			return "menu";
		}
		return afficherCreationClient(model);  //TODO changer le chemin en "retour à la page appelante"
	}
	
	
}
