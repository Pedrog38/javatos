package com.poe.javatos.service.crud;

import java.util.List;

import com.poe.javatos.bean.Stock;

public interface IServiceStockCrud {
	
	//Afficher toutes les lignes de t_stocks
	List<Stock> findAllStock();
	
	//Afficher une ligne t_stock par Id
	Stock findByIdStock(final Integer idStock);
	
	//Creer une ligne dans t_stock
	Stock createStock(final Stock pStock);
	
	//Modifier une ligne dans t_stock
	Stock updateStock(final Stock pStock);
	
	//Supprimer une ligne dans t_stock par Id
	void deleteByIdStock(final Integer idStock);
}
