package com.poe.javatos.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.repository.ILigneDevisRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceLigneDevis {
	
	@Autowired
	IServiceDevis devisService;
	
	@Autowired
	ILigneDevisRepository dao;
	
	@Test
	public void testTrouverUneLigneDevis() {
		Integer id = 1;
		Devis ld = null;
		try {
			ld = devisService.
		}
		catch (Exception e) {
			fail("Pas de ligne trouvée " +id);
		}
		assertNotNull(ld);

		
	}	

}
