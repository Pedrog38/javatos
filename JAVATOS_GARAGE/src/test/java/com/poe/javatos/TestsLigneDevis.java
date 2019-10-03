package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.service.IServiceLigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsLigneDevis {

	@Autowired
	IServiceLigneDevisCrud daoLigneDevisCrud ;
	@Autowired
	IServiceDevisCrud daoDevisCrud;
	@Autowired
	IServiceModelCrud daoModelCrud;
	@Autowired
	IServiceLigneDevis daoLigneDevis;
	
	@Test
	public void testLigneDevis() throws POEException 
	{
		LigneDevis ld1 = new LigneDevis();
		ld1.setId(5);
		ld1.setQuantite(10);
		ld1.setModel(daoModelCrud.findByIdModel(1));
		ld1.setDevis(daoDevisCrud.findByIdDevis(1));
		
		LigneDevis ld2 = new LigneDevis();
		ld2.setId(6);
		ld2.setQuantite(20);
		ld2.setModel(daoModelCrud.findByIdModel(2));
		ld2.setDevis(daoDevisCrud.findByIdDevis(1));
		
		LigneDevis ld3 = new LigneDevis();
		ld3.setId(7);
		ld3.setQuantite(30);
		ld3.setModel(daoModelCrud.findByIdModel(1));
		ld3.setDevis(daoDevisCrud.findByIdDevis(2));
		
		LigneDevis ld4 = new LigneDevis();
		ld4.setId(8);
		ld4.setQuantite(40);
		ld4.setModel(daoModelCrud.findByIdModel(2));
		ld4.setDevis(daoDevisCrud.findByIdDevis(2));
		
		daoLigneDevisCrud.createLigneDevis(ld1);
		daoLigneDevisCrud.createLigneDevis(ld2);
		daoLigneDevisCrud.createLigneDevis(ld3);
		daoLigneDevisCrud.createLigneDevis(ld4);
		
		List<LigneDevis> ldsDevis1 = daoLigneDevis.findByIdDevisLigneDevis(1);
		
		assertNotNull(ldsDevis1);
		assertEquals(4,ldsDevis1.size());
		
		assertEquals(Integer.valueOf(1),ldsDevis1.get(0).getId());
		assertEquals(Integer.valueOf(2),ldsDevis1.get(1).getId());
		assertEquals(Integer.valueOf(5),ldsDevis1.get(2).getId());
		assertEquals(Integer.valueOf(6),ldsDevis1.get(3).getId());
		
		List<LigneDevis> ldsDevis2 = daoLigneDevis.findByIdDevisLigneDevis(2);
		
		assertNotNull(ldsDevis2);
		assertEquals(4,ldsDevis2.size());
		
		assertEquals(Integer.valueOf(3),ldsDevis2.get(0).getId());
		assertEquals(Integer.valueOf(4),ldsDevis2.get(1).getId());
		assertEquals(Integer.valueOf(7),ldsDevis2.get(2).getId());
		assertEquals(Integer.valueOf(8),ldsDevis2.get(3).getId());
	}

}
