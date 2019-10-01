package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
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

	@Override
	public Stock findByIdModelStock(Integer idModel) throws POEException
	{
		List<Stock> stocks = dao.findByIdModelStocks(idModel);
		if (stocks.size() !=0 ) {
		return dao.findByIdModelStocks(idModel).get(0);
	} else {
		throw new POEException();
	}
	}

	public Stock miseAjourAssignation(Stock s, Integer qteAReserver)
	{
		s.setQteDispo(s.getQteDispo()-qteAReserver);
		s.setQteReservee(s.getQteReservee()+qteAReserver);
		return dao.save(s);
	}
	
	public Stock miseAjourReceptionCommandeFournisseur(Stock s, Integer qteRecue)
	{
		s.setQteDispo(s.getQteDispo()+qteRecue);
		s.setQteCommandee(s.getQteCommandee()-qteRecue);
		return dao.save(s);
	}
	
}
