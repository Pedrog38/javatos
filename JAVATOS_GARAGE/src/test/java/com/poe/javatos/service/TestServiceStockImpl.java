package com.poe.javatos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
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
	
	@Test(expected = POEException.class)
	public void testNonMajAssStock() throws POEException {
		Stock s = issCrud.findByIdStock(1);
		int qteAReserver = 115;
		
		iss.miseAjourAssignation(s, qteAReserver);
		
	}
	
	@Test
	public void testRecepCmd() {
		Stock s = issCrud.findByIdStock(1);
		int qteRecue = 10;
		int QteDispo = 119;
		int QteCmd = 35;
		
		try {
			iss.miseAjourReceptionCommandeFournisseur(s, qteRecue);
		} catch (POEException e) {
			fail("Impossible de mettre à jour le stock avec la quantité recue suivante : " + qteRecue);
		}
		
		int QteDispoApres = s.getQteDispo();
		int QteCmdApres = s.getQteCommandee();
		
		assertNotNull(s);
		assertEquals(QteDispo, QteDispoApres);
		assertEquals(QteCmd, QteCmdApres);
				
	}
	
	@Test(expected = POEException.class)
	public void testErrRecepCmd() throws POEException {
		Stock s = issCrud.findByIdStock(1);
		int qteRecue = 100;
		
		iss.miseAjourReceptionCommandeFournisseur(s, qteRecue);
	}
	
	@Test
	public void testCommander() {
		Stock s = issCrud.findByIdStock(1);
		int qteACommander = 10;
		int qteCmd = 55;
		
		try {
			iss.commander(s, qteACommander);
		} catch (POEException e) {
			fail("Impossible de commander cette quantité, veuillez vérifier votre quantité à commander");
		}
		
		int qteCmdApres = s.getQteCommandee();
		
		assertNotNull(s);
		assertEquals(qteCmd, qteCmdApres);	
	}
	
	@Test(expected = POEException.class)
	public void testErrCommander() throws POEException {
		Stock s = issCrud.findByIdStock(1);
		int qteACommander = -545859547;
		
		iss.commander(s, qteACommander);
	}
		
	@After
	public void cleanLeStockApresChaqueTest() {
		
		Stock s = issCrud.findByIdStock(1);
		s.setQteDispo(109);
		s.setQteReservee(5);
		s.setQteCommandee(45);
		issCrud.updateStock(s);		
	}
	
	
}
