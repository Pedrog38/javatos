package com.poe.javatos.controller;

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

import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.form.GestionStockForm;
import com.poe.javatos.form.ListeGestionStockForm;
import com.poe.javatos.mapper.GestionStockMapper;
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

	public String afficherListeGestionStock(final ModelMap model) throws POEException 
	{
		if(model.get("gestionStocks")==null)
		{
			List<Stock> stockCmd = serviceStock.findStocksEnCommandeFournisseur();
			
			ListeGestionStockForm gestionstocks = new ListeGestionStockForm();
			
			for (Stock stock : stockCmd) 
			{
				
				GestionStockForm gestionStockForm = GestionStockMapper.remplirGestionStockForm(stock);
				gestionstocks.setIndex(0);
				gestionstocks.getListForm().add(gestionStockForm);
			}
			model.addAttribute("gestionStocks", gestionstocks);
		}
		
		return "receptionerStocks";
	}
	
	@PostMapping(value = "/receptionnercommande")
	public String validerLigneGestionStock(@Valid @ModelAttribute(value = "gestionStocks")
			final ListeGestionStockForm gestionstocks, final BindingResult bindingResult, final ModelMap model) throws POEException {
		
		if (!bindingResult.hasErrors()) 
		{
			int index = gestionstocks.getIndex();
			List<GestionStockForm> list = gestionstocks.getListForm();
			GestionStockForm gestionStockForm = list.get(index);
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
				gestionStockForm = GestionStockMapper.remplirGestionStockForm(s);
				list.add(index,gestionStockForm);
			}
			gestionstocks.setListForm(list);
			model.addAttribute("gestionStocks", gestionstocks);
			
		}
		return afficherListeGestionStock(model);
	}

}
