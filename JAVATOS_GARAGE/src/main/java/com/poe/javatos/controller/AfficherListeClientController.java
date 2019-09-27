package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;

@Controller
@RequestMapping(value="/afficherListeClient")
public class AfficherListeClientController {
	
		 @Autowired    
		 private IServiceClientCrud service;
		 
		 @RequestMapping(method = RequestMethod.GET)    
		 public String afficher(ModelMap pModel) {        
			 final List<Client> lListeClient = service.findAllClient();        
			 pModel.addAttribute("listeClient", lListeClient);        
			 return "listeClient";
		 } 
	}