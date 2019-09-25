package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Commande;

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
    
	@Test
    public void testCrudCommande() {
		
		// implementer les "dao" des beans utilisés 
         IServiceCommandeCrud dao = new ServiceCommandeCrudImpl();
         IServiceClientCrud daoClient = new ServiceClientCrudImpl();
         IServiceLigneCommandeCrud daoLignesCommande = new ServiceLigneCommandeCrudImpl();
         IServiceUtilisateurCrud daoUtilisateur = new ServiceUtilisateurCrudImpl();
         
         
         // créer au moins 2 objet Commande et les setter 
         Commande c1 = new Commande();
         c1.setId(1);
         c1.setDelaisProd(11);
         Date datec1= new Date();
         c1.setDateCreation(datec1);
         c1.setStatut("Statut1");
         c1.setClient(daoClient.findByIdClient(1));
         //c1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
         c1.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(1));
         
         Commande c2 = new Commande();
         c2.setId(2);
         c2.setDelaisProd(22);
         Date datec2= new Date();
         c2.setDateCreation(datec2);
         c2.setStatut("Statut2");
         c2.setClient(daoClient.findByIdClient(2));
         //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
         c2.setCommercialResponsable(daoUtilisateur.findByIdUtilisateur(2));
         
         dao.createCommande(c1);
         dao.createCommande(c2);
         
         // test récupération de données
         Commande CRecup1 = dao.findByIdCommande(1);
         
         assertNotNull(CRecup1);
         
         assertEquals(Integer.valueOf(11),CRecup1.getDelaisProd());
         assertEquals(datec1,CRecup1.getDateCreation());
         assertEquals("Statut1", CRecup1.getStatut());
         assertEquals(daoClient.findByIdClient(1),CRecup1.getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(1), CRecup1.getCommercialResponsable());
         
         Commande CRecup2 = dao.findByIdCommande(2);
         
         assertNotNull(CRecup2);
         
         assertEquals(Integer.valueOf(22),CRecup2.getDelaisProd());
         assertEquals(datec2,CRecup2.getDateCreation());
         assertEquals("Statut2", CRecup2.getStatut());
         assertEquals(daoClient.findByIdClient(2),CRecup2.getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(2), CRecup2.getCommercialResponsable());
         
         Commande c1Modifie = c1;
         c1Modifie.setStatut("StatutModifiec1");
         Commande c2Modifie = c2;
         c2Modifie.setStatut("StatutModifiec2");
         
         dao.updateCommande(c1Modifie);
         dao.updateCommande(c2Modifie);
         //reprise ici
         Commande cRecupModifie1 = dao.findByIdCommande(1);
         
         assertEquals(Integer.valueOf(10),cRecupModifie1.getDelaisProd());
         assertEquals(datec1,cRecupModifie1.getDateCreation());
         assertEquals("StatutModifie1", cRecupModifie1.getStatut());
         assertEquals(daoClient.findByIdClient(1),cRecupModifie1.getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(1), cRecupModifie1.getCommercialResponsable());
         
         Commande dRecupModifie2 = dao.findByIdCommande(2);
         assertEquals(Integer.valueOf(20),dRecupModifie2.getDelaisProd());
         assertEquals(datec2,dRecupModifie2.getDateCreation());
         assertEquals("StatutModifie2", dRecupModifie2.getStatut());
         assertEquals(daoClient.findByIdClient(2),dRecupModifie2.getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(2), dRecupModifie2.getCommercialResponsable());
         
         List<Commande> allCommande = dao.findAllCommande();
         assertEquals(2, allCommande.size());
         
         assertEquals(Integer.valueOf(10),allCommande.get(1).getDelaisProd());
         assertEquals(datec1,allCommande.get(1).getDateCreation());
         assertEquals("StatutModifie1", allCommande.get(1).getStatut());
         assertEquals(daoClient.findByIdClient(1),allCommande.get(1).getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(1), allCommande.get(1).getCommercialResponsable());
         
         assertEquals(Integer.valueOf(20),allCommande.get(2).getDelaisProd());
         assertEquals(datec2,allCommande.get(2).getDateCreation());
         assertEquals("StatutModifie2", allCommande.get(2).getStatut());
         assertEquals(daoClient.findByIdClient(2),allCommande.get(2).getClient());
         assertEquals(daoUtilisateur.findByIdUtilisateur(2), allCommande.get(2).getCommercialResponsable());
         
    }
    
}