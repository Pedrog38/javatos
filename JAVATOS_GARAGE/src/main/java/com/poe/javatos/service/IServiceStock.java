package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;

public interface IServiceStock 
{
	List<Stock> findStocksEnCommandeFournisseur();
	
	Stock findByIdModelStock(Integer idModel) throws POEException;
	
	Stock miseAjourAssignation(Stock s, Integer qteAReserver);
	
	Stock miseAjourReceptionCommandeFournisseur(Stock s, Integer qteRecue);
	
	Stock commander(Stock s, Integer qteACommander);
}
