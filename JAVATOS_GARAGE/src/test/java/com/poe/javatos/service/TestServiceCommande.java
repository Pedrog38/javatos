package com.poe.javatos.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testServiceCommande {

	@Autowired	
	IServiceCommande isc;
	
	@Autowired
	IServiceCommandeCrud dao;
	
	@Test
	public void testfindByStatutNouvelleCommande() {
		
		List <Commande> lc1 = new ArrayList<>(); 
		lc1.add(dao.findByIdCommande(1));
		lc1.add(dao.findByIdCommande(2));
		
		List<Commande> lc2 = isc.findByStatutNouvelleCommande();
		
		assertNotNull(lc1);
		assertArrayEquals(lc1.toArray(),lc2.toArray());
	}
	
	@Test
	public void testcalculerDelaisCommande() {
		
		Commande c1 = dao.findByIdCommande(1);
		
		
		Integer delaiCo = 0;
		for (LigneCommande lc : c1.getLignesCommandes()) {
			
			Integer delaiCommande = lc.getModel().getDelaisProd();
			delaiCo = Math.max(delaiCo, delaiCo);
		}
		assertEquals(delaiCo, isc.calculerDelaisCommande(c1));
		
	}
}
