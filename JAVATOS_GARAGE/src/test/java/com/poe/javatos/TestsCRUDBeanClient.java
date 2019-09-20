package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceStatutClientCrud;
import com.poe.javatos.service.crud.ServiceClientCrudImpl;
import com.poe.javatos.service.crud.ServiceStatutClientCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanClient {

	@Test
	public void TestBeanClient() {

		IServiceClientCrud dao = new ServiceClientCrudImpl();
		IServiceStatutClientCrud daoStatutClient = new ServiceStatutClientCrudImpl();

		Client c1 = new Client();

		c1.setId(1);
		c1.setAdresse("AdresseTest1");
		Date date1 = new Date();
		c1.setDateCreation(date1);
		c1.setMail("test1@test.com");
		c1.setNom("NomTest1");
		c1.setPrenom("PrenomTest1");
		c1.setSexe("SexeTest1");
		c1.setTelephone("TelTest1");
		c1.setStatut(daoStatutClient.findByIdStatutClient(1));

		Client c2 = new Client();

		c2.setId(2);
		c2.setAdresse("AdresseTest2");
		Date date2 = new Date();
		c2.setDateCreation(date2);
		c2.setMail("test2@test.com");
		c2.setNom("NomTest2");
		c2.setPrenom("PrenomTest2");
		c2.setSexe("SexeTest2");
		c2.setTelephone("TelTest2");
		c2.setStatut(daoStatutClient.findByIdStatutClient(2));

		dao.createClient(c1);
		dao.createClient(c2);

		Client cRecup1 = dao.findByIdClient(1);

		assertNotNull(cRecup1);

		assertEquals("AdresseTest1", cRecup1.getAdresse());
		assertEquals(date1, cRecup1.getDateCreation());
		assertEquals("test1@test.com", cRecup1.getMail());
		assertEquals("NomTest1", cRecup1.getNom());
		assertEquals("PrenomTest1", cRecup1.getPrenom());
		assertEquals("TelTest1", cRecup1.getTelephone());
		assertEquals("SexeTest1", cRecup1.getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(1), cRecup1.getStatut());

		Client cRecup2 = dao.findByIdClient(2);

		assertNotNull(cRecup2);

		assertEquals("AdresseTest2", cRecup2.getAdresse());
		assertEquals(date2, cRecup2.getDateCreation());
		assertEquals("test2@test.com", cRecup2.getMail());
		assertEquals("NomTest2", cRecup2.getNom());
		assertEquals("PrenomTest2", cRecup2.getPrenom());
		assertEquals("TelTest2", cRecup2.getTelephone());
		assertEquals("SexeTest2", cRecup2.getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(2), cRecup2.getStatut());

		Client c1Modifie = c1;
		c1Modifie.setNom("NomTest1Modifie");
		Client c2Modifie = c2;
		c2Modifie.setNom("NomTest2Modifie");

		dao.updateClient(c1Modifie);
		dao.updateClient(c2Modifie);

		Client cRecupModifie1 = dao.findByIdClient(1);

		assertNotNull(cRecupModifie1);

		assertEquals("AdresseTest1", cRecupModifie1.getAdresse());
		assertEquals(date1, cRecupModifie1.getDateCreation());
		assertEquals("test1@test.com", cRecupModifie1.getMail());
		assertEquals("NomTest1Modifie", cRecupModifie1.getNom());
		assertEquals("PrenomTest1", cRecupModifie1.getPrenom());
		assertEquals("TelTest1", cRecupModifie1.getTelephone());
		assertEquals("SexeTest1", cRecupModifie1.getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(1), cRecupModifie1.getStatut());

		Client cRecupModifie2 = dao.findByIdClient(2);

		assertNotNull(cRecupModifie2);

		assertEquals("AdresseTest2", cRecupModifie2.getAdresse());
		assertEquals(date2, cRecupModifie2.getDateCreation());
		assertEquals("test2@test.com", cRecupModifie2.getMail());
		assertEquals("NomTest2Modifie", cRecupModifie2.getNom());
		assertEquals("PrenomTest2", cRecupModifie2.getPrenom());
		assertEquals("TelTest2", cRecupModifie2.getTelephone());
		assertEquals("SexeTest2", cRecupModifie2.getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(2), cRecupModifie2.getStatut());
		
		List<Client> allClients = dao.findAllClient();
		assertEquals(2, allClients.size());
		
		assertEquals("AdresseTest1", allClients.get(1).getAdresse());
		assertEquals(date1, allClients.get(1).getDateCreation());
		assertEquals("test1@test.com", allClients.get(1).getMail());
		assertEquals("NomTest1Modifie", allClients.get(1).getNom());
		assertEquals("PrenomTest1", allClients.get(1).getPrenom());
		assertEquals("TelTest1", allClients.get(1).getTelephone());
		assertEquals("SexeTest1", allClients.get(1).getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(1), allClients.get(1).getStatut());
		
		assertEquals("AdresseTest2", allClients.get(2).getAdresse());
		assertEquals(date2, allClients.get(2).getDateCreation());
		assertEquals("test2@test.com", allClients.get(2).getMail());
		assertEquals("NomTest2Modifie", allClients.get(2).getNom());
		assertEquals("PrenomTest2", allClients.get(2).getPrenom());
		assertEquals("TelTest2", allClients.get(2).getTelephone());
		assertEquals("SexeTest2", allClients.get(2).getSexe());
		assertEquals(daoStatutClient.findByIdStatutClient(2), allClients.get(2).getStatut());


	}

}
