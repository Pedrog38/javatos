package com.poe.javatos.mapper;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.GestionStockForm;

public class GestionStockMapper 
{
	public static GestionStockForm remplirGestionStockForm(Stock stock)
	{
		GestionStockForm gestionStockForm = new GestionStockForm();
		gestionStockForm.setIdModel(stock.getModel().getId());
		gestionStockForm.setQteCommandee(stock.getQteCommandee());
		gestionStockForm.setQteDispo(stock.getQteDispo());
		gestionStockForm.setNomModele(stock.getModel().getNom());
		gestionStockForm.setQteRecue(0);
		return gestionStockForm;
	}
	
}
