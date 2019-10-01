package com.poe.javatos.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.repository.ICommandeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceCommande {
	
	@Autowired
	IServiceCommande commandeService;

	@Autowired
	ICommandeRepository dao;
	
	@Test
	public void testTrouverCommande() {
		List<Commande> lc1 = new ArrayList<>();
		try { 
			
		lc1 = commandeService.findByStatutNouvelleCommande();
			
		}
		catch (Exception e) {
			fail("pas de nouvelle commande");
		}
		
		
	}
	
	
	
	
}
