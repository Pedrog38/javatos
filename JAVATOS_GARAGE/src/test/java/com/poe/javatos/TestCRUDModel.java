package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Model;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.ServiceModelCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUDModel {

		
		@Test
		public void testCRUDModel() {
			IServiceModelCrud dao = new ServiceModelCrudImpl();
			
			Model m1 = new Model();
			m1.setId(1);
			m1.setNom("Delorean");
			m1.setCouleur("Fussia");
			m1.setPrixVente((float) 10000);
			m1.setPuissance(300);
			m1.setDelaisProd(5);
			
			Model m2 = new Model();
			m2.setId(2);
			m2.setNom("Porche Cayenne");
			m2.setCouleur("Verte");
			m2.setPrixVente((float) 20000);
			m2.setPuissance(500);
			m2.setDelaisProd(10);
			
			//TEST CREATE
			
			dao.createModel(m1);
			dao.createModel(m2);
			
			Model mRecup1 = dao.findByIdModel(1);
			assertNotNull(mRecup1); //nous voulons tester si un objet est null
			assertEquals(Integer.valueOf(5),mRecup1.getDelaisProd()); // vérifie que les valeurs attendues et réelles sont égales
			assertEquals("Delorean",mRecup1.getNom());
			assertEquals(Integer.valueOf(300),mRecup1.getPuissance());
			assertEquals("Fussia",mRecup1.getCouleur());
			assertEquals(Float.valueOf(10000),mRecup1.getPrixVente());
			
			Model mRecup2 = dao.findByIdModel(2);
			assertNotNull(mRecup2); //nous voulons tester si un objet est null
			assertEquals(Integer.valueOf(10),mRecup2.getDelaisProd()); // vérifie que les valeurs attendues et réelles sont égales
			assertEquals("Porche Cayenne",mRecup2.getNom());
			assertEquals(Integer.valueOf(500),mRecup2.getPuissance());
			assertEquals("Verte",mRecup2.getCouleur());
			assertEquals(Float.valueOf(20000),mRecup2.getPrixVente());
			
			
			//TEST UPDATE
			Model m1Modifie = m1;
			m1Modifie.setNom("Delorean V12");
			Model m2Modifie = m2;
			m2Modifie.setNom("Ferrari");
			
			dao.updateModel(m1Modifie);
			dao.updateModel(m2Modifie);
			
			Model mRecupModifie1 = dao.findByIdModel(1);
			
			assertEquals("Delorean V12",mRecupModifie1.getNom());
			assertEquals(Integer.valueOf(5),mRecupModifie1.getDelaisProd());
			assertEquals(Integer.valueOf(300),mRecupModifie1.getPuissance());
			assertEquals("Fussia",mRecupModifie1.getCouleur());
			assertEquals(Float.valueOf(10000),mRecupModifie1.getPrixVente());
			
			Model mRecupModifie2 = dao.findByIdModel(2);	
			
			assertEquals("Ferrari",mRecupModifie2.getNom());
			assertEquals(Integer.valueOf(10),mRecupModifie2.getDelaisProd());
			assertEquals(Integer.valueOf(500),mRecupModifie2.getPuissance());
			assertEquals("Verte",mRecupModifie2.getCouleur());
			assertEquals(Float.valueOf(20000),mRecupModifie2.getPrixVente());
			
			//TEST FIND ALL
			
			List<Model>allModel= dao.findAllModel();
			assertEquals(2,allModel.size());
			
			assertEquals(Integer.valueOf(5),allModel.get(1).getDelaisProd());
			assertEquals(Integer.valueOf(300),allModel.get(1).getPuissance());
			assertEquals(Float.valueOf(10000),allModel.get(1).getPrixVente());
			assertEquals("Delorean V12",allModel.get(1).getNom());
			assertEquals("Fussia",allModel.get(1).getCouleur());
			
			
			assertEquals(Integer.valueOf(10),allModel.get(2).getDelaisProd());
			assertEquals(Integer.valueOf(500),allModel.get(2).getPuissance());
			assertEquals(Float.valueOf(20000),allModel.get(2).getPrixVente());
			assertEquals("Ferrari",allModel.get(2).getNom());
			assertEquals("Verte",allModel.get(2).getCouleur());
			
			
		}
	
}























