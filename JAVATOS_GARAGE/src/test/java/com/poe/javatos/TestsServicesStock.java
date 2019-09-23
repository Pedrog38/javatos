package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceStockCrud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsServicesStock {

	@Autowired
	IServiceStockCrud daoStockCrud;
	@Autowired
	IServiceModelCrud daoModelCrud;
	@Autowired
	IServiceStock daoStock;
	
	@Test
	public void testStocksEnCommandeFournisseur() 
	{
		Stock s1 = new Stock();
		s1.setId(3); // 2 Stocks initiaux des cruds
		s1.setQteDispo(10);
		s1.setQteReservee(10);
		s1.setQteCommandee(10);
		s1.setModel(daoModelCrud.findByIdModel(1));
		
		Stock s2 = new Stock();
		s2.setId(4);
		s2.setQteDispo(10);
		s2.setQteReservee(10);
		s2.setQteCommandee(0);
		s2.setModel(daoModelCrud.findByIdModel(2));
		
		daoStockCrud.createStock(s1);
		daoStockCrud.createStock(s2);
		
		List<Stock> stocksEnCommandeFournisseur = daoStock.findStocksEnCommandeFournisseur();
		assertNotNull(stocksEnCommandeFournisseur);
		assertEquals(2, stocksEnCommandeFournisseur.size());
		
		assertEquals(Integer.valueOf(1),stocksEnCommandeFournisseur.get(0).getId());
		assertEquals(Integer.valueOf(3),stocksEnCommandeFournisseur.get(1).getId());
		
		//System.err.println(stocksEnCommandeFournisseur);
		
	}

}
