package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Stock;

public interface IServiceStock 
{
	List<Stock> findStocksEnCommandeFournisseur();
}
