package com.poe.javatos.controller;

import java.util.ArrayList;
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

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.mapper.GestionStockMapper;
import com.poe.javatos.mapper.ListeGestionStockMapper;
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
	public String afficherListeGestionStock(final ModelMap model) 
	{
		if(model.get("gestionStocks")==null)
		{
			List<Stock> stockCmd = serviceStock.findStocksEnCommandeFournisseur();
			
			ListeGestionStockMapper gestionstocks = new ListeGestionStockMapper();
			
			System.err.println(gestionstocks.getListForm());
			
			for (Stock stock : stockCmd) {
				
				GestionStockMapper gestionStockForm = new GestionStockMapper();
				
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
		}
		
		return "receptionerStocks";
	}
	
	@PostMapping(value = "/receptionnercommande")
	public String validerLigneGestionStock(@Valid @ModelAttribute(value = "gestionStocks")
			final ListeGestionStockMapper gestionstocks, final BindingResult bindingResult, final ModelMap model) {
		
		if (!bindingResult.hasErrors()) {
			int index = gestionstocks.getIndex();
			System.err.println("INDEX = " +index);
			List<GestionStockMapper> list = gestionstocks.getListForm();
			GestionStockMapper gestionStockForm = list.get(index);
			Stock s = serviceStock.findByIdModelStock(gestionStockForm.getIdModel());
			Integer qteRecue = gestionStockForm.getQteRecue();
			Integer qtedispo = s.getQteDispo();
			Integer qteCommandee = s.getQteCommandee();
			qtedispo += qteRecue;
			qteCommandee -= qteRecue;
			s.setQteDispo(qtedispo);
			s.setQteCommandee(qteCommandee);
			
			s=serviceStockCrud.updateStock(s);
			list.remove(gestionStockForm);
			if(s.getQteCommandee()!=0)
			{
				gestionStockForm.setIdModel(s.getModel().getId());
				gestionStockForm.setQteCommandee(s.getQteCommandee());
				gestionStockForm.setQteDispo(s.getQteDispo());
				gestionStockForm.setNomModele(s.getModel().getNom());
				gestionStockForm.setQteRecue(0);
				list.add(index,gestionStockForm);
			}
			gestionstocks.setListForm(list);
			model.addAttribute("gestionStocks", gestionstocks);
			
		}
		System.err.println(bindingResult);
		return afficherListeGestionStock(model);
	}

}
