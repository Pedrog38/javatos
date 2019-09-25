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
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;
import com.poe.javatos.service.crud.ServiceLigneDevisCrudImpl;
import com.poe.javatos.service.crud.ServiceModelCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanLigneDevis 
{
	@Autowired
	IServiceLigneDevisCrud dao ;
	@Autowired
	IServiceDevisCrud daoDevis;
	@Autowired
	IServiceModelCrud daoModel;
	
	@Test
	public void testCrudLigneDevis()
	{
		
		
		LigneDevis ld1 = new LigneDevis();
		ld1.setId(1);
		ld1.setQuantite(10);
		ld1.setModel(daoModel.findByIdModel(1));
		ld1.setDevis(daoDevis.findByIdDevis(1));
		
		LigneDevis ld2 = new LigneDevis();
		ld2.setId(2);
		ld2.setQuantite(20);
		ld2.setModel(daoModel.findByIdModel(2));
		ld2.setDevis(daoDevis.findByIdDevis(1));
		
		LigneDevis ld3 = new LigneDevis();
		ld3.setId(3);
		ld3.setQuantite(30);
		ld3.setModel(daoModel.findByIdModel(1));
		ld3.setDevis(daoDevis.findByIdDevis(2));
		
		LigneDevis ld4 = new LigneDevis();
		ld4.setId(4);
		ld4.setQuantite(40);
		ld4.setModel(daoModel.findByIdModel(2));
		ld4.setDevis(daoDevis.findByIdDevis(2));
		
		dao.createLigneDevis(ld1);
		dao.createLigneDevis(ld2);
		dao.createLigneDevis(ld3);
		dao.createLigneDevis(ld4);
		
		LigneDevis ldRecup1 = dao.findByIdLigneDevis(1);
		
		assertNotNull(ldRecup1);
		
		//assertEquals(ld1, ldRecup1);
		assertEquals(Integer.valueOf(10), ldRecup1.getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), ldRecup1.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), ldRecup1.getDevis().getId());
		
		LigneDevis ldRecup2 = dao.findByIdLigneDevis(2);
		
		assertNotNull(ldRecup2);
		
		//assertEquals(ld2, ldRecup2);
		assertEquals(Integer.valueOf(20), ldRecup2.getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), ldRecup2.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), ldRecup2.getDevis().getId());
		
		LigneDevis ldRecup3 = dao.findByIdLigneDevis(3);
		
		assertNotNull(ldRecup3);
		
		//assertEquals(ld3, ldRecup3);
		assertEquals(Integer.valueOf(30), ldRecup3.getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), ldRecup3.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), ldRecup3.getDevis().getId());
		
		LigneDevis ldRecup4 = dao.findByIdLigneDevis(4);
		
		assertNotNull(ldRecup4);
		
		//assertEquals(ld4, ldRecup4);
		assertEquals(Integer.valueOf(40), ldRecup4.getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), ldRecup4.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), ldRecup4.getDevis().getId());
		
		LigneDevis ldModifier1 = ld1;
		ldModifier1.setQuantite(11);
		LigneDevis ldModifier2 = ld2;
		ldModifier2.setQuantite(22);
		LigneDevis ldModifier3 = ld3;
		ldModifier3.setQuantite(33);
		LigneDevis ldModifier4 = ld4;
		ldModifier4.setQuantite(44);
		 
		dao.updateLigneDevis(ldModifier1);
		dao.updateLigneDevis(ldModifier2);
		dao.updateLigneDevis(ldModifier3);
		dao.updateLigneDevis(ldModifier4);
		 
		LigneDevis ldRecupModifie1 = dao.findByIdLigneDevis(1);
		LigneDevis ldRecupModifie2 = dao.findByIdLigneDevis(2);
		LigneDevis ldRecupModifie3 = dao.findByIdLigneDevis(3);
		LigneDevis ldRecupModifie4 = dao.findByIdLigneDevis(4);
		
		assertNotNull(ldRecupModifie1);
		assertNotNull(ldRecupModifie2);
		assertNotNull(ldRecupModifie3);
		assertNotNull(ldRecupModifie4);
		
		//assertEquals(ldModifier1,ldRecupModifie1);
		assertEquals(Integer.valueOf(11), ldRecupModifie1.getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), ldRecupModifie1.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), ldRecupModifie1.getDevis().getId());
		
		//assertEquals(ldModifier2,ldRecupModifie2);
		assertEquals(Integer.valueOf(22), ldRecupModifie2.getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), ldRecupModifie2.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), ldRecupModifie2.getDevis().getId());
		
		//assertEquals(ldModifier3,ldRecupModifie3);
		assertEquals(Integer.valueOf(33), ldRecupModifie3.getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), ldRecupModifie3.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), ldRecupModifie3.getDevis().getId());
		
		//assertEquals(ldModifier4,ldRecupModifie4);
		assertEquals(Integer.valueOf(44), ldRecupModifie4.getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), ldRecupModifie4.getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), ldRecupModifie4.getDevis().getId());
		
		List<LigneDevis> allLignedevis = dao.findAllLigneDevis();
		assertEquals(4, allLignedevis.size());
		 
		//assertEquals(ldModifier1,allLignedevis.get(0));
		assertEquals(Integer.valueOf(11), allLignedevis.get(0).getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), allLignedevis.get(0).getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), allLignedevis.get(0).getDevis().getId());
		
		//assertEquals(ldModifier2,allLignedevis.get(1));
		assertEquals(Integer.valueOf(22), allLignedevis.get(1).getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), allLignedevis.get(1).getModel().getId());
		assertEquals(daoDevis.findByIdDevis(1).getId(), allLignedevis.get(1).getDevis().getId());
		
		//assertEquals(ldModifier3,allLignedevis.get(2));
		assertEquals(Integer.valueOf(33), allLignedevis.get(2).getQuantite());
		assertEquals(daoModel.findByIdModel(1).getId(), allLignedevis.get(2).getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), allLignedevis.get(2).getDevis().getId());
		
		//assertEquals(ldModifier4,allLignedevis.get(3));
		assertEquals(Integer.valueOf(44), allLignedevis.get(3).getQuantite());
		assertEquals(daoModel.findByIdModel(2).getId(), allLignedevis.get(3).getModel().getId());
		assertEquals(daoDevis.findByIdDevis(2).getId(), allLignedevis.get(3).getDevis().getId());
		
		 
	}
}
