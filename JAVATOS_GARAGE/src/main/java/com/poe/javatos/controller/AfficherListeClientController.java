package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin","/magasinier"})
public class AfficherListeClientController {
	
		 @Autowired    
		 private IServiceClientCrud service;
		 
		 @GetMapping(value="/afficherListeClient")  
		 public String afficherListeClient(ModelMap pModel) {        

			 final List<Client> lListeClient = service.findAllClient();        
			 pModel.addAttribute("listeclient", lListeClient);        
			 return "afficherListeClient";
		 } 
	}


