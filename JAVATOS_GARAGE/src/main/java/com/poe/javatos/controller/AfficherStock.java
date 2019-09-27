package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.service.crud.IServiceStockCrud;

@Controller
@RequestMapping(value = {"/commercial","/admin","/magasinier"})
public class AfficherStock {
	
		 @Autowired    
		 private IServiceStockCrud service;
		 
		 @GetMapping(value="/afficherStock")    
		 public String afficher(ModelMap pModel) {        
			 final List<Stock> lListeModel = service.findAllStock();        
			 pModel.addAttribute("listestock", lListeModel);        
			 return "afficherStock";
		 } 
	}