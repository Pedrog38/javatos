package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.repository.IStockRepository;

@Service
public class ServiceStockImpl implements IServiceStock 
{
	@Autowired
	IStockRepository dao;
	
	@Override
	public List<Stock> findStocksEnCommandeFournisseur() 
	{
		return dao.findStocksEnCommandeFournisseur();
	}

	
}
