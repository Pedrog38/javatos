package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;
import com.poe.javatos.service.crud.ServiceLigneDevisCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanLigneDevis 
{
	@Test
	public void testCrudLigneDevis()
	{
		IServiceLigneDevisCrud dao = new ServiceLigneDevisCrudImpl();
		IServiceDevisCrud daoDevis = new ServiceDevisCrudImpl();
		IServiceModelCrud daoModel = new ServiceModelCrudImpl();
		
		LigneDevis ld1 = new LigneDevis();
		ld1.setId(1);
		ld1.setQuantite(10);
		ld1.setStatut("StatutLD1");
		ld1.setNbResvervees(10);
		ld1.setModel(daoModel.findByIdModel(1));
		ld1.setDevis(daoDevis.findByIdDevis(1));
		
		LigneDevis ld2 = new LigneDevis();
		ld2.setId(2);
		ld2.setQuantite(20);
		ld2.setStatut("StatutLD2");
		ld2.setNbResvervees(20);
		ld2.setModel(daoModel.findByIdModel(2));
		ld2.setDevis(daoDevis.findByIdDevis(1));
		
		LigneDevis ld3 = new LigneDevis();
		ld3.setId(3);
		ld3.setQuantite(30);
		ld3.setStatut("StatutLD3");
		ld3.setNbResvervees(30);
		ld3.setModel(daoModel.findByIdModel(1));
		ld3.setDevis(daoDevis.findByIdDevis(2));
		
		LigneDevis ld4 = new LigneDevis();
		ld4.setId(4);
		ld4.setQuantite(10);
		ld4.setStatut("StatutLD4");
		ld4.setNbResvervees(40);
		ld4.setModel(daoModel.findByIdModel(2));
		ld4.setDevis(daoDevis.findByIdDevis(2));
		
		dao.createLigneDevis(ld1);
		dao.createLigneDevis(ld2);
		dao.createLigneDevis(ld3);
		dao.createLigneDevis(ld4);
		
		LigneDevis ldRecup1 = dao.findByIdLigneDevis(1);
		
		assertNotNull(ldRecup1);
		
		assertEquals(ld1, ldRecup1);
		assertEquals(Integer.valueOf(1), ldRecup1.getQuantite());
		assertEquals("StatutLD1", ldRecup1.getStatut());
		assertEquals(Integer.valueOf(1), ldRecup1.getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), ldRecup1.getModel());
		assertEquals(daoDevis.findByIdDevis(1), ldRecup1.getDevis());
		
		LigneDevis ldRecup2 = dao.findByIdLigneDevis(2);
		
		assertNotNull(ldRecup2);
		
		assertEquals(ld2, ldRecup2);
		assertEquals(Integer.valueOf(2), ldRecup2.getQuantite());
		assertEquals("StatutLD2", ldRecup2.getStatut());
		assertEquals(Integer.valueOf(2), ldRecup2.getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), ldRecup2.getModel());
		assertEquals(daoDevis.findByIdDevis(1), ldRecup2.getDevis());
		
		LigneDevis ldRecup3 = dao.findByIdLigneDevis(3);
		
		assertNotNull(ldRecup3);
		
		assertEquals(ld3, ldRecup3);
		assertEquals(Integer.valueOf(3), ldRecup3.getQuantite());
		assertEquals("StatutLD3", ldRecup3.getStatut());
		assertEquals(Integer.valueOf(3), ldRecup3.getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), ldRecup3.getModel());
		assertEquals(daoDevis.findByIdDevis(2), ldRecup3.getDevis());
		
		LigneDevis ldRecup4 = dao.findByIdLigneDevis(4);
		
		assertNotNull(ldRecup4);
		
		assertEquals(ld4, ldRecup4);
		assertEquals(Integer.valueOf(4), ldRecup4.getQuantite());
		assertEquals("StatutLD4", ldRecup4.getStatut());
		assertEquals(Integer.valueOf(4), ldRecup4.getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), ldRecup4.getModel());
		assertEquals(daoDevis.findByIdDevis(2), ldRecup4.getDevis());
		
		LigneDevis ldModifier1 = ld1;
		ldModifier1.setStatut("StatutModifie1");
		LigneDevis ldModifier2 = ld2;
		ldModifier2.setStatut("StatutModifie2");
		LigneDevis ldModifier3 = ld3;
		ldModifier3.setStatut("StatutModifie3");
		LigneDevis ldModifier4 = ld4;
		ldModifier4.setStatut("StatutModifie4");
		 
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
		
		assertEquals(ldModifier1,ldRecupModifie1);
		assertEquals(Integer.valueOf(1), ldRecupModifie1.getQuantite());
		assertEquals("StatutModifie1", ldRecupModifie1.getStatut());
		assertEquals(Integer.valueOf(1), ldRecupModifie1.getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), ldRecupModifie1.getModel());
		assertEquals(daoDevis.findByIdDevis(1), ldRecupModifie1.getDevis());
		
		assertEquals(ldModifier2,ldRecupModifie2);
		assertEquals(Integer.valueOf(2), ldRecupModifie2.getQuantite());
		assertEquals("StatutModifie2", ldRecupModifie2.getStatut());
		assertEquals(Integer.valueOf(2), ldRecupModifie2.getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), ldRecupModifie2.getModel());
		assertEquals(daoDevis.findByIdDevis(1), ldRecupModifie2.getDevis());
		
		assertEquals(ldModifier3,ldRecupModifie3);
		assertEquals(Integer.valueOf(3), ldRecupModifie3.getQuantite());
		assertEquals("StatutModifie3", ldRecupModifie3.getStatut());
		assertEquals(Integer.valueOf(2), ldRecupModifie3.getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), ldRecupModifie3.getModel());
		assertEquals(daoDevis.findByIdDevis(2), ldRecupModifie3.getDevis());
		
		assertEquals(ldModifier4,ldRecupModifie4);
		assertEquals(Integer.valueOf(4), ldRecupModifie4.getQuantite());
		assertEquals("StatutModifie4", ldRecupModifie4.getStatut());
		assertEquals(Integer.valueOf(4), ldRecupModifie4.getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), ldRecupModifie4.getModel());
		assertEquals(daoDevis.findByIdDevis(2), ldRecupModifie4.getDevis());
		
		List<LigneDevis> allLignedevis = dao.findAllLigneDevis();
		assertEquals(4, allLignedevis.size());
		 
		assertEquals(ldModifier1,allLignedevis.get(1));
		assertEquals(Integer.valueOf(1), allLignedevis.get(1).getQuantite());
		assertEquals("StatutModifie1", allLignedevis.get(1).getStatut());
		assertEquals(Integer.valueOf(1), allLignedevis.get(1).getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), allLignedevis.get(1).getModel());
		assertEquals(daoDevis.findByIdDevis(1), allLignedevis.get(1).getDevis());
		
		assertEquals(ldModifier2,allLignedevis.get(2));
		assertEquals(Integer.valueOf(2), allLignedevis.get(2).getQuantite());
		assertEquals("StatutModifie2", allLignedevis.get(2).getStatut());
		assertEquals(Integer.valueOf(2), allLignedevis.get(2).getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), allLignedevis.get(2).getModel());
		assertEquals(daoDevis.findByIdDevis(1), allLignedevis.get(2).getDevis());
		
		assertEquals(ldModifier3,allLignedevis.get(3));
		assertEquals(Integer.valueOf(3), allLignedevis.get(3).getQuantite());
		assertEquals("StatutModifie3", allLignedevis.get(3).getStatut());
		assertEquals(Integer.valueOf(2), allLignedevis.get(3).getNbResvervees());
		assertEquals(daoModel.findByIdModel(1), allLignedevis.get(3).getModel());
		assertEquals(daoDevis.findByIdDevis(2), allLignedevis.get(3).getDevis());
		
		assertEquals(ldModifier4,allLignedevis.get(4));
		assertEquals(Integer.valueOf(4), allLignedevis.get(4).getQuantite());
		assertEquals("StatutModifie4", allLignedevis.get(4).getStatut());
		assertEquals(Integer.valueOf(4), allLignedevis.get(4).getNbResvervees());
		assertEquals(daoModel.findByIdModel(2), allLignedevis.get(4).getModel());
		assertEquals(daoDevis.findByIdDevis(2), allLignedevis.get(4).getDevis());
		
		 
	}
}
