package com.poe.javatos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.repository.IStockRepository;

@SpringBootTest //permet d'utiliser les @Autowired et determiner l'environnement Spring
@RunWith(SpringRunner.class)
public class testServiceStock {
	
	//On met toujours l'interface
	@Autowired
	IServiceStock stockService;
	
	@Autowired
	IStockRepository dao;

	@Test
	public void testTrouveUnStrock() { 
		Integer id = 1; //Stock 1 existe
		Stock stk= null;
		try {
		stk = stockService.findByIdModelStock(id);
		}
		catch (Exception e) {
			fail("Probleme interrogation service avec id" +id);
			
		}
		assertNotNull(stk);
		assertEquals((int)stk.getId(),1);
		assertEquals((int)stk.getQteDispo(),-115);
		}
	
	
	@Test(expected = POEException.class)
	public void testTrouveAucunStock() throws POEException {
		Integer id = 99; // Stock 99 N'EXISTE PAS
		stockService.findByIdModelStock(id);
	}
	
	
	/**@Test (expected = POEException.class)
	public void testMAJAssignation() throws POEException {
		Integer qte = 50;
		Stock s = stockService.findByIdModelStock(1);
		
		Integer dispo = s.getQteDispo();
		Integer resa = s.getQteReservee();
		stockService.miseAjourAssignation(s, qte);
		
		assertEquals(dispo-qte,(int)s.getQteDispo());
		assertEquals(resa+qte,(int)s.getQteReservee());
	}
	 **/
		

}
