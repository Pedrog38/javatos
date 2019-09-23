package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.service.crud.IServiceStatutClientCrud;
import com.poe.javatos.service.crud.ServiceStatutClientCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanStatutClient {

	@Autowired
	IServiceStatutClientCrud dao;
	
	@Test
	public void testsBeanStatutClient() {

		

		StatutClient sC1 = new StatutClient();
		sC1.setId(1);
		sC1.setNom("test statut client 1");
		sC1.setTauxTva(19.6F);

		StatutClient sC2 = new StatutClient();
		sC2.setId(2);
		sC2.setNom("test statut client 2");
		sC2.setTauxTva(5.5F);

		dao.createStatutclient(sC1);
		dao.createStatutclient(sC2);

		StatutClient sCRecup1 = dao.findByIdStatutClient(1);

		assertNotNull(sCRecup1);
		
		assertEquals("test statut client 1", sCRecup1.getNom());
		assertEquals(Float.valueOf(19.6F), sCRecup1.getTauxTva());

		StatutClient sCRecup2 = dao.findByIdStatutClient(2);
		
		assertNotNull(sCRecup2);
		
		assertEquals("test statut client 2", sCRecup2.getNom());
		assertEquals(Float.valueOf(5.5F), sCRecup2.getTauxTva());
		
		StatutClient sC1Modifie = sC1;
		sC1Modifie.setNom("test statut client 1 modifie");
		StatutClient sC2Modifie = sC2;
		sC2Modifie.setNom("test statut client 2 modifie");
		
		dao.updateStatutClient(sC1Modifie);
		dao.updateStatutClient(sC2Modifie);
		
		StatutClient sCRecupModifie1 = dao.findByIdStatutClient(1);
		
		assertNotNull(sCRecupModifie1);
		
		assertEquals("test statut client 1 modifie", sCRecupModifie1.getNom());
		assertEquals(Float.valueOf(19.6F), sCRecupModifie1.getTauxTva());
		
		StatutClient sCRecupModifie2 = dao.findByIdStatutClient(2);
		
		assertNotNull(sCRecupModifie2);
		
		assertEquals("test statut client 2 modifie", sCRecupModifie2.getNom());
		assertEquals(Float.valueOf(5.5F), sCRecupModifie2.getTauxTva());
		
		List<StatutClient> allStatutsClient = dao.findAllStatutClient();
		assertEquals(2, allStatutsClient.size());
		
		assertEquals("test statut client 1 modifie", allStatutsClient.get(0).getNom());
		assertEquals(Float.valueOf(19.6F), allStatutsClient.get(0).getTauxTva());
		
		assertEquals("test statut client 2 modifie", allStatutsClient.get(1).getNom());
		assertEquals(Float.valueOf(5.5F), allStatutsClient.get(1).getTauxTva());

	}

}
