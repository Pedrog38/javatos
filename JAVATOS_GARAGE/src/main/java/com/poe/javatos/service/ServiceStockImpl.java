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
	public Stock findByIdModelStock (Integer idModel) throws POEException
	{
		List<Stock> stocks = dao.findByIdModelStocks(idModel);
		
		if (stocks.size() !=0) {
			
			return dao.findByIdModelStocks(idModel).get(0);
		} else {
			throw new POEException();
		}
	}

	public Stock miseAjourAssignation(Stock s, Integer qteAReserver) throws POEException
	{
		if ((s.getQteDispo() >= qteAReserver) && (qteAReserver > 0)) {
			s.setQteDispo(s.getQteDispo()-qteAReserver);
			s.setQteReservee(s.getQteReservee()+qteAReserver);
			return dao.save(s);
			
		} else {
			throw new POEException("Impossible d'assigner la quantité à réserver : " + qteAReserver +  " pour le modèle : " + s.getModel().getNom());
		}
		
	}
	
	public Stock miseAjourReceptionCommandeFournisseur(Stock s, Integer qteRecue) throws POEException
	{
		if ((qteRecue <= s.getQteCommandee()) && (qteRecue > 0)) {
			s.setQteDispo(s.getQteDispo()+qteRecue);
			s.setQteCommandee(s.getQteCommandee()-qteRecue);
			return dao.save(s);
			
		} else {
			throw new POEException("raté");
		}
	}
	
	public Stock commander(Stock s, Integer qteACommander) throws POEException
	{
		if (qteACommander > 0) {
			s.setQteCommandee(s.getQteCommandee()+qteACommander);
			return dao.save(s);
			
		} else {
			throw new POEException("la quantité à commander doit être positive (qui l'eut cru ?) quantité renseignée : " + qteACommander);
		}
		
	}
	
	
}
