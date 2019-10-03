package com.poe.javatos.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.repository.ILigneDevisRepository;

@Ignore
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceLigneDevis {
	
	@Autowired
	IServiceLigneDevis devisService;
		
	@Autowired
	ILigneDevisRepository dao;
	
	@Test
	public void testTrouverUneLigneDevis() {
		Integer id = 1;
		List<LigneDevis> ld = null;
		try {
			ld = devisService.findByIdDevisLigneDevis(id);
		}
		catch (Exception e) {
			fail("Pas de ligne trouvée " +id);
		}
		
		assertNotNull(ld);
		/*
		List<LigneDevis> ldTest = new ArrayList<LigneDevis>();
		ldTest.add(ld.get(0));
		ldTest.add(ld.get(1));
		ldTest.add(ld.get(25));
		*/
		assertArrayEquals(ld.toArray(), fakeDevis().toArray());
		
	}	

	@Test(expected = POEException.class)
	public void testUnIdImpossible() throws POEException{
		
		devisService.findByIdDevisLigneDevis(-1);
		fail("Id -1 est acceptée");
	}
		
	@Test
	public void testTrouvePasUneLigneDevisEq() {
		Integer id = 6;
		List<LigneDevis> ld = null;
		try {
			ld = devisService.findByIdDevisLigneDevis(id);
		}
		catch (Exception e) {
			fail("Pas de ligne trouvée " +id);
		}
		
		assertNotNull(ld);
		assertNotEquals(ld.size(),fakeDevis().size());
		
	}	
		private List<LigneDevis> fakeDevis(){
		List<LigneDevis> fkld = new ArrayList<>();
		
		Devis dv1 = new Devis();dv1.setId(1);
		
		Model m = new Model();
		m.setId(1);
		Model m2 = new Model();
		m2.setId(2);
		
		LigneDevis d1 = new LigneDevis();		
		d1.setId(1);
		d1.setDevis(dv1);
		d1.setQuantite(11);
		d1.setModel(m);
		fkld.add(d1);
		
		d1 = new LigneDevis();
		d1.setDevis(dv1);
		d1.setId(2);
		d1.setQuantite(22);
		d1.setModel(m2);
		fkld.add(d1);
		
		d1 = new LigneDevis();
		d1.setDevis(dv1);
		d1.setId(5);
		d1.setQuantite(10);
		d1.setModel(m);
		fkld.add(d1);
		
		
		d1 = new LigneDevis();
		d1.setDevis(dv1);
		d1.setId(6);
		d1.setQuantite(20);
		d1.setModel(m2);
		fkld.add(d1);
		
		return fkld;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
}
