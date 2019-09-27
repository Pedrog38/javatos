package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Model;
import com.poe.javatos.service.crud.IServiceModelCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin"})
public class AfficherListeModelController {
	
		 @Autowired    
		 private IServiceModelCrud service;
		 
		 @GetMapping(value="/afficherListeModel")    
		 public String afficher(ModelMap pModel) {        
			 final List<Model> lListeModel = service.findAllModel();        
			 pModel.addAttribute("listemodel", lListeModel);        
			 return "afficherListeModel";
		 } 
	}