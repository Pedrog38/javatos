package com.poe.javatos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.GestionStockForm;
import com.poe.javatos.form.ListeGestionStockForm;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

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
			
			gestionstocks.getListForm().add(gestionStockForm);
		}
		
		System.err.println(gestionstocks);
		System.err.println(gestionstocks.getListForm());
		model.addAttribute("gestionStocks", gestionstocks);
		
		return "gestionreception";
	}

}
