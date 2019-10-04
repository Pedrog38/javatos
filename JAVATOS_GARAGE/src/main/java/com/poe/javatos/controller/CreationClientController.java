package com.poe.javatos.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.poe.javatos.mapper.CreationClientMapper;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceStatutClientCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"}) 
public class CreationClientController 
{
	@Autowired
	private IServiceClientCrud serviceClientCurd;
	@Autowired
	private IServiceStatutClientCrud serviceStatutClientCurd;
	@Autowired
	private AfficherListeClientController ctrlListeClient;
	
	@Autowired
	private CreationDevisController crtlCreationDevis;
	
	@GetMapping(value="/creerClientAfficher")
	public String afficherCreationClient(final ModelMap model)
	{
		final List<StatutClient> listeStatutClient = serviceStatutClientCurd.findAllStatutClient();
		model.addAttribute("statutList",listeStatutClient);
		if(model.get("CreationClient")==null)
		{
			model.addAttribute("CreationClient",new CreationClientForm());
		}
		return "creationClient";
	
	}
	
	@PostMapping(value="/creerClient")
	public String CreationClient(@Valid @ModelAttribute(value="CreationClient") 
	 final CreationClientForm creationForm,final BindingResult bindingResult, final ModelMap model)
	{
		if(!bindingResult.hasErrors())
		{
			Client client = CreationClientMapper.remplirClient(creationForm);
			serviceClientCurd.createClient(client);
		}
		if(model.get("creationDevis")!=null)
		{
			return(crtlCreationDevis.afficherCreationDevis(model));
		}
		return ctrlListeClient.afficherListeClient(model);  
	}
	
	
}
