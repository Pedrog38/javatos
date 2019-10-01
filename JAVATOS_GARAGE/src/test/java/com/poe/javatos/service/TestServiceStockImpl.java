package com.poe.javatos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.service.crud.IServiceStockCrud;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceStockImpl {

	@Autowired
	IServiceStock iss;
	
	@Autowired
	IServiceStockCrud issCrud;
	
	@Test
	public void testFindByIdModelStock() {
		
		Stock s = null;
		Integer id = 1;
		Stock sCrud = issCrud.findByIdStock(1);
		
		try {
			s = iss.findByIdModelStock(id);
		} catch (POEException e) {
			fail("Probleme interrogation service avec id " + id);
		}
		
		assertNotNull(s);
		assertEquals(s, sCrud);
	}
	
	@Test(expected = POEException.class)
	public void testDontFindStockByIdModel() throws POEException {
		
		Integer id = 99;
		iss.findByIdModelStock(id);
		
	}
	
	@Test
	public void testFindListStockCmd() {
		
		List<Stock> stocks = null;
		int listeSize = 3;
		
		try {
			stocks = iss.findStocksEnCommandeFournisseur();
		} catch (POEException e) {
			fail("Impossible de récupérer la liste des stocks en cmd fournisseur");
		}
		
		assertNotNull(stocks);
		assertEquals(listeSize, stocks.size());
	}
	
	@Test
	public void testMajAssStock() {
		Stock s = issCrud.findByIdStock(1);
		int qteAReserver = 5;
		int qteDispo = 104;
		
		try {
			iss.miseAjourAssignation(s, qteAReserver);
		} catch (POEException e) {
			fail("Impossible d'assigner la quantité à réserver : " + qteAReserver +  " pour le modèle : " + s.getModel().getNom() );
		}
		
		int qteDispoApres = s.getQteDispo();
		
		assertNotNull(s);
		assertEquals(qteDispo, qteDispoApres);
	}
		
	@After
	public void cleanLeStockApresChaqueTest() {
		
		Stock s = issCrud.findByIdStock(1);
		s.setQteDispo(109);
		s.setQteReservee(5);
		issCrud.updateStock(s);		
	}
	
}
