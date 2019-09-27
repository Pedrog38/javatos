package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Stock;

public interface IServiceStock 
{
	List<Stock> findStocksEnCommandeFournisseur();
	
	Stock findByIdModelStock(Integer idModel);
	
	Stock miseAjourAssignation(Stock s, Integer qteAReserver);
	
	Stock miseAjourReceptionCommandeFournisseur(Stock s, Integer qteRecue);
}
