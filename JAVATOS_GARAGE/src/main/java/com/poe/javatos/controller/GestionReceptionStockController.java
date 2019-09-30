package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.GestionStockForm;
import com.poe.javatos.form.ListeGestionStockForm;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

@RequestMapping(value = {"/magasinier","/admin"})
@Controller
public class GestionReceptionStockController {
	
	@Autowired
	IServiceStockCrud serviceStockCrud;
	
	@Autowired
	IServiceStock serviceStock;
	
	@Autowired
	IServiceModelCrud serviceModelCrud;
	
	@GetMapping(value = "/afficherGestionStock")
	public String afficherListeGestionStock(final ModelMap model) {
		
		List<Stock> stockCmd = serviceStock.findStocksEnCommandeFournisseur();

		ListeGestionStockForm gestionstocks = new ListeGestionStockForm();
		
		System.err.println(gestionstocks.getListForm());
		
		for (Stock stock : stockCmd) {
			
			GestionStockForm gestionStockForm = new GestionStockForm();
			
			gestionStockForm.setIdModel(stock.getModel().getId());
			gestionStockForm.setQteCommandee(stock.getQteCommandee());
			gestionStockForm.setQteDispo(stock.getQteDispo());
			gestionStockForm.setNomModele(stock.getModel().getNom());
			gestionStockForm.setQteRecue(0);
			
			gestionstocks.setIndex(0);
			gestionstocks.getListForm().add(gestionStockForm);
		}
		
		System.err.println(gestionstocks);
		System.err.println(gestionstocks.getListForm());
		model.addAttribute("gestionStocks", gestionstocks);
		
		return "gestionreception";
	}
	
	@PostMapping(value = "/receptionnercommande")
	public String validerLigneGestionStock(@ModelAttribute(value = "gestionStocks")
			final ListeGestionStockForm gestionstocks, final BindingResult bindingResult, final ModelMap model) {
		
		if (!bindingResult.hasErrors()) {
			int index = gestionstocks.getIndex();
			System.err.println("INDEX = " +index);
			GestionStockForm gestionStockForm = gestionstocks.getListForm().get(index);
			Stock s = serviceStock.findByIdModelStock(gestionStockForm.getIdModel());
			Integer qteRecue = gestionStockForm.getQteRecue();
			Integer qtedispo = s.getQteDispo();
			Integer qteCommandee = s.getQteCommandee();
			qtedispo += qteRecue;
			qteCommandee -= qteRecue;
			s.setQteDispo(qtedispo);
			s.setQteCommandee(qteCommandee);
			
			serviceStockCrud.updateStock(s);
			
		}
		
		return afficherListeGestionStock(model);
	}

}
