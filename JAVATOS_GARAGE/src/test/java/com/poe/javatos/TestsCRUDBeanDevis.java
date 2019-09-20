package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanDevis 
{
	@Test
	public void testCrudDevis()
	{
		 IServiceDevisCrud dao = new ServiceDevisCrudImpl();
		 IServiceClientCrud daoClient = new ServiceClientCrudImpl();
		 IServiceLignesDevisCrud daoLignesDevis = new ServiceLignesDevisImpl();
		 IServiceUtilisateurCrud daoUtilisateur = new ServiceUtilisateurImpl();
		 
		 
		 
		 Devis d1 = new Devis();
		 d1.setId(1);
		 d1.setDelaisProd(10);
		 Date date1= new Date();
		 d1.setDateCreation(date1);
		 d1.setStatut("Statut1");
		 d1.setClient(daoClient.findByIdClient(1));
		 //d1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
		 d1.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(1));
		 
		 Devis d2 = new Devis();
		 d2.setId(2);
		 d2.setDelaisProd(20);
		 Date date2= new Date();
		 d2.setDateCreation(date2);
		 d2.setStatut("Statut2");
		 d2.setClient(daoClient.findByIdClient(2));
		 //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
		 d2.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(2));
		 
		 dao.createDevis(d1);
		 dao.createDevis(d2);
		 
		 Devis dRecup1 = dao.findByIdDevis(1);
		 
		 assertNotNull(dRecup1);
		 
		 assertEquals(Integer.valueOf(10),dRecup1.getDelaisProd());
		 assertEquals(date1,dRecup1.getDateCreation());
		 assertEquals("Statut1", dRecup1.getStatut());
		 assertEquals(daoClient.findByIdClient(1),dRecup1.getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(1), dRecup1.getCommercialResponsable());
		 
		 Devis dRecup2 = dao.findByIdDevis(2);
		 
		 assertNotNull(dRecup2);
		 
		 assertEquals(Integer.valueOf(20),dRecup2.getDelaisProd());
		 assertEquals(date2,dRecup2.getDateCreation());
		 assertEquals("Statut2", dRecup2.getStatut());
		 assertEquals(daoClient.findByIdClient(2),dRecup2.getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(2), dRecup2.getCommercialResponsable());
		 
		 Devis d1Modifie = d1;
		 d1Modifie.setStatut("StatutModifie1");
		 Devis d2Modifie = d2;
		 d2Modifie.setStatut("StatutModifie2");
		 
		 dao.updateDevis(d1Modifie);
		 dao.updateDevis(d2Modifie);
		 
		 Devis dRecupModifie1 = dao.findByIdDevis(1);
		 
		 assertEquals(Integer.valueOf(10),dRecupModifie1.getDelaisProd());
		 assertEquals(date1,dRecupModifie1.getDateCreation());
		 assertEquals("StatutModifie1", dRecupModifie1.getStatut());
		 assertEquals(daoClient.findByIdClient(1),dRecupModifie1.getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(1), dRecupModifie1.getCommercialResponsable());
		 
		 Devis dRecupModifie2 = dao.findByIdDevis(2);
		 assertEquals(Integer.valueOf(20),dRecupModifie2.getDelaisProd());
		 assertEquals(date2,dRecupModifie2.getDateCreation());
		 assertEquals("StatutModifie2", dRecupModifie2.getStatut());
		 assertEquals(daoClient.findByIdClient(2),dRecupModifie2.getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(2), dRecupModifie2.getCommercialResponsable());
		 
		 List<Devis> allDevis = dao.findAllDevis();
		 assertEquals(2, allDevis.size());
		 
		 assertEquals(Integer.valueOf(10),allDevis.get(1).getDelaisProd());
		 assertEquals(date1,allDevis.get(1).getDateCreation());
		 assertEquals("StatutModifie1", allDevis.get(1).getStatut());
		 assertEquals(daoClient.findByIdClient(1),allDevis.get(1).getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(1), allDevis.get(1).getCommercialResponsable());
		 
		 assertEquals(Integer.valueOf(20),allDevis.get(2).getDelaisProd());
		 assertEquals(date2,allDevis.get(2).getDateCreation());
		 assertEquals("StatutModifie2", allDevis.get(2).getStatut());
		 assertEquals(daoClient.findByIdClient(2),allDevis.get(2).getClient());
		 asertEquals(daoUtilisateur.findUtilisateurById(2), allDevis.get(2).getCommercialResponsable());
		 
	}
	
}
