package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceLigneDevisCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;
import com.poe.javatos.service.crud.ServiceClientCrudImpl;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;
import com.poe.javatos.service.crud.ServiceLigneDevisCrudImpl;
import com.poe.javatos.service.crud.ServiceUtilisateurCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanDevis 
{
	@Autowired
	IServiceDevisCrud dao;
	@Autowired
	IServiceClientCrud daoClient;
	@Autowired
	IServiceLigneDevisCrud daoLignesDevis;
	@Autowired
	IServiceUtilisateurCrud daoUtilisateur;
	
	
	@Test
	public void testCrudDevis()
	{
		 
//		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
//		 
//		 
//		 Devis d1 = new Devis();
//		 d1.setId(1);
//		// d1.setDelaisProd(10);
//		 Date date1= new Date();
//		 d1.setDateCreation(date1);
//		 d1.setStatut("Statut1");
//		 d1.setClient(daoClient.findByIdClient(1));
//		 //d1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
//		 d1.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(1));
//		 
//		 Devis d2 = new Devis();
//		 d2.setId(2);
//		 //d2.setDelaisProd(20);
//		 Date date2= new Date();
//		 d2.setDateCreation(date2);
//		 d2.setStatut("Statut2");
//		 d2.setClient(daoClient.findByIdClient(2));
//		 //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
//		 d2.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(2));
//		 
//		 d1=dao.createDevis(d1);
//		 d2=dao.createDevis(d2);
//		 
//		 Integer id1 = d1.getId();
//		 Integer id2 = d2.getId();
//		 
//		 Devis dRecup1 = dao.findByIdDevis(1);
//		 
//		 assertNotNull(dRecup1);
//		 
//		 //assertEquals(d1, dRecup1);
//		// assertEquals(Integer.valueOf(10),dRecup1.getDelaisProd());
//		 assertEquals(formatDate.format(date1),formatDate.format(dRecup1.getDateCreation()));
//		 assertEquals("Statut1", dRecup1.getStatut());
//		 assertEquals(daoClient.findByIdClient(1).getId(),dRecup1.getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), dRecup1.getCommercialResponsable().getId());
//		 
//		 Devis dRecup2 = dao.findByIdDevis(2);
//		 
//		 assertNotNull(dRecup2);
//		 
//		 //assertEquals(d2, dRecup2);
//		// assertEquals(Integer.valueOf(20),dRecup2.getDelaisProd());
//		 assertEquals(formatDate.format(date2),formatDate.format(dRecup2.getDateCreation()));
//		 assertEquals("Statut2", dRecup2.getStatut());
//		 assertEquals(daoClient.findByIdClient(2).getId(),dRecup2.getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), dRecup2.getCommercialResponsable().getId());
//		 
//		 Devis d1Modifie = d1;
//		 d1Modifie.setStatut("StatutModifie1");
//		 Devis d2Modifie = d2;
//		 d2Modifie.setStatut("StatutModifie2");
//		 
//		 dao.updateDevis(d1Modifie);
//		 dao.updateDevis(d2Modifie);
//		 
//		 Devis dRecupModifie1 = dao.findByIdDevis(1);
//		 
//		 assertNotNull(dRecupModifie1);
//		 
//		 //assertEquals(d1Modifie, dRecupModifie1);
//		 //assertEquals(Integer.valueOf(10),dRecupModifie1.getDelaisProd());
//		 assertEquals(formatDate.format(date1),formatDate.format(dRecupModifie1.getDateCreation()));
//		 assertEquals("StatutModifie1", dRecupModifie1.getStatut());
//		 assertEquals(daoClient.findByIdClient(1).getId(),dRecupModifie1.getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), dRecupModifie1.getCommercialResponsable().getId());
//		 
//		 Devis dRecupModifie2 = dao.findByIdDevis(2);
//		 
//		 assertNotNull(dRecupModifie2);
//		 
//		 //assertEquals(d2Modifie, dRecupModifie2);
//		// assertEquals(Integer.valueOf(20),dRecupModifie2.getDelaisProd());
//		 assertEquals(formatDate.format(date2),formatDate.format(dRecupModifie2.getDateCreation()));
//		 assertEquals("StatutModifie2", dRecupModifie2.getStatut());
//		 assertEquals(daoClient.findByIdClient(2).getId(),dRecupModifie2.getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), dRecupModifie2.getCommercialResponsable().getId());
//		 
//		 List<Devis> allDevis = dao.findAllDevis();
//		 assertEquals(2, allDevis.size());
//		 
//		 assertNotNull(allDevis.get(0));
//		 
//		 //assertEquals(d1Modifie, allDevis.get(0));
//		 //assertEquals(Integer.valueOf(10),allDevis.get(0).getDelaisProd());
//		 assertEquals(formatDate.format(date1),formatDate.format(allDevis.get(0).getDateCreation()));
//		 assertEquals("StatutModifie1", allDevis.get(0).getStatut());
//		 assertEquals(daoClient.findByIdClient(1).getId(),allDevis.get(0).getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), allDevis.get(0).getCommercialResponsable().getId());
//		 
//		 assertNotNull(allDevis.get(1));
//		 
//		 //assertEquals(d2Modifie, allDevis.get(1));
//		// assertEquals(Integer.valueOf(20),allDevis.get(1).getDelaisProd());
//		 assertEquals(formatDate.format(date2),formatDate.format(allDevis.get(1).getDateCreation()));
//		 assertEquals("StatutModifie2", allDevis.get(1).getStatut());
//		 assertEquals(daoClient.findByIdClient(2).getId(),allDevis.get(1).getClient().getId());
//		 assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), allDevis.get(1).getCommercialResponsable().getId());
//		 
	}
	
}
