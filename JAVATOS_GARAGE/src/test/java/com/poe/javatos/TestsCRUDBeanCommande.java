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

import com.poe.javatos.bean.Commande;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;

import com.poe.javatos.service.crud.ServiceCommandeCrudImpl;
import com.poe.javatos.service.crud.ServiceLigneCommandeCrudImpl;

import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.ServiceClientCrudImpl;

import com.poe.javatos.service.crud.IServiceUtilisateurCrud;
import com.poe.javatos.service.crud.ServiceUtilisateurCrudImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanCommande{
    
	@Autowired
	IServiceCommandeCrud dao;
	@Autowired
    IServiceClientCrud daoClient;
	@Autowired
    IServiceUtilisateurCrud daoUtilisateur;
	
	
	@Test
    public void testCrudCommande() 
	{   
//		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
//         
//         // créer au moins 2 objet Commande et les setter 
//         Commande c1 = new Commande();
//         c1.setId(1);
//         //c1.setDelaisProd(11);
//         Date datec1= new Date();
//         c1.setDateCreation(datec1);
//         c1.setStatutCommande("Statut1");
//         c1.setClient(daoClient.findByIdClient(1));
//         //c1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
//         c1.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(1));
//         
//         Commande c2 = new Commande();
//         c2.setId(2);
//        // c2.setDelaisProd(22);
//         Date datec2= new Date();
//         c2.setDateCreation(datec2);
//         c2.setStatut("Statut2");
//         c2.setClient(daoClient.findByIdClient(2));
//         //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
//         c2.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(2));
//         
//         dao.createCommande(c1);
//         dao.createCommande(c2);
//         
//         // test récupération de données
//         Commande CRecup1 = dao.findByIdCommande(1);
//         
//         assertNotNull(CRecup1);
//         
//        // assertEquals(Integer.valueOf(11),CRecup1.getDelaisProd());
//         assertEquals(formatDate.format(datec1),formatDate.format(CRecup1.getDateCreation()));
//         assertEquals("Statut1", CRecup1.getStatut());
//         assertEquals(daoClient.findByIdClient(1).getId(),CRecup1.getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), CRecup1.getCommercialResponsable().getId());
//         
//         Commande CRecup2 = dao.findByIdCommande(2);
//         
//         assertNotNull(CRecup2);
//         
//         //assertEquals(Integer.valueOf(22),CRecup2.getDelaisProd());
//         assertEquals(formatDate.format(datec2),formatDate.format(CRecup2.getDateCreation()));
//         assertEquals("Statut2", CRecup2.getStatut());
//         assertEquals(daoClient.findByIdClient(2).getId(),CRecup2.getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), CRecup2.getCommercialResponsable().getId());
//         
//         Commande c1Modifie = c1;
//         c1Modifie.setStatut("StatutModifiec1");
//         Commande c2Modifie = c2;
//         c2Modifie.setStatut("StatutModifiec2");
//         
//         dao.updateCommande(c1Modifie);
//         dao.updateCommande(c2Modifie);
//         //reprise ici
//         Commande cRecupModifie1 = dao.findByIdCommande(1);
//         
//         //assertEquals(Integer.valueOf(11),cRecupModifie1.getDelaisProd());
//         assertEquals(formatDate.format(datec1),formatDate.format(cRecupModifie1.getDateCreation()));
//         assertEquals("StatutModifiec1", cRecupModifie1.getStatut());
//         assertEquals(daoClient.findByIdClient(1).getId(),cRecupModifie1.getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), cRecupModifie1.getCommercialResponsable().getId());
//         
//         Commande dRecupModifie2 = dao.findByIdCommande(2);
//         //assertEquals(Integer.valueOf(22),dRecupModifie2.getDelaisProd());
//         assertEquals(formatDate.format(datec2),formatDate.format(dRecupModifie2.getDateCreation()));
//         assertEquals("StatutModifiec2", dRecupModifie2.getStatut());
//         assertEquals(daoClient.findByIdClient(2).getId(),dRecupModifie2.getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), dRecupModifie2.getCommercialResponsable().getId());
//         
//         List<Commande> allCommande = dao.findAllCommande();
//         assertEquals(2, allCommande.size());
//         
//        // assertEquals(Integer.valueOf(11),allCommande.get(0).getDelaisProd());
//         assertEquals(formatDate.format(datec1),formatDate.format(allCommande.get(0).getDateCreation()));
//         assertEquals("StatutModifiec1", allCommande.get(0).getStatut());
//         assertEquals(daoClient.findByIdClient(1).getId(),allCommande.get(0).getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(1).getId(), allCommande.get(0).getCommercialResponsable().getId());
//         
//         //assertEquals(Integer.valueOf(22),allCommande.get(1).getDelaisProd());
//         assertEquals(formatDate.format(datec2),formatDate.format(allCommande.get(1).getDateCreation()));
//         assertEquals("StatutModifiec2", allCommande.get(1).getStatut());
//         assertEquals(daoClient.findByIdClient(2).getId(),allCommande.get(1).getClient().getId());
//         assertEquals(daoUtilisateur.findByIdUtilisateur(2).getId(), allCommande.get(1).getCommercialResponsable().getId());
//         
    }
    
}