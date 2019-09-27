package com.poe.javatos;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.service.IServiceCommande;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsStatutCommandeLigneCommande 
{
	@Autowired
	IServiceCommandeCrud daoCommandeCrud;
	@Autowired
    IServiceClientCrud daoClientCrud;
	@Autowired
    IServiceUtilisateurCrud daoUtilisateurCrud;
	@Autowired
	IServiceCommande daoCommande;
	@Autowired
	IServiceLigneCommandeCrud daoLigneCommandeCrud;
	@Autowired
	IServiceLigneCommande daoLigneCommande;
	@Autowired
    IServiceModelCrud daoModelCrud;
	
	@Test
	public void testCommandeMettreAjoursStatuts() 
	{
		Commande c1 = new Commande();
        c1.setId(7);
        //c1.setDelaisProd(10);
        Date datec1= new Date();
        c1.setDateCreation(datec1);
        c1.setStatut(StatutCommande.Nouvelle);
        c1.setClient(daoClientCrud.findByIdClient(1));
        //c1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
        c1.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(1));
        
        c1=daoCommandeCrud.createCommande(c1);
        
        LigneCommande lc1 = new LigneCommande();
        lc1.setId(0);
        lc1.setCommande(c1); 
        lc1.setStatut(StatutLigneCommande.NonRenseignee);
        lc1.setModel(daoModelCrud.findByIdModel(1));
        lc1.setQuantite(10);
        lc1.setNbResvervees(10);
        
        lc1=daoLigneCommandeCrud.createLigneCommande(lc1);
        assertEquals(StatutLigneCommande.NonRenseignee, lc1.getStatut());
        
        lc1 = daoLigneCommande.miseAJourStatut(lc1);
        assertEquals(StatutLigneCommande.Reservee, lc1.getStatut());
        
        assertEquals(StatutCommande.Nouvelle,c1.getStatut());
        
        c1=daoCommande.mettreAJourStatut(c1);
        assertEquals(StatutCommande.Nouvelle,c1.getStatut());
        
        c1.setStatut(StatutCommande.EnTraitement);
        c1=daoCommandeCrud.updateCommande(c1);
        assertEquals(StatutCommande.Nouvelle,c1.getStatut());
        c1=daoCommande.mettreAJourStatut(c1);
        assertEquals(StatutCommande.Nouvelle,c1.getStatut());
        
        
        
        
//        
//        LigneCommande lc2 = new LigneCommande();
//        lc2.setId(0);
//        lc2.setCommande(c1); 
//        lc2.setStatut(StatutLigneCommande.NonRenseignee);
//        lc2.setModel(daoModelCrud.findByIdModel(2));
//        lc2.setQuantite(10);
//        lc2.setNbResvervees(5);
//        
//        lc2=daoLigneCommandeCrud.createLigneCommande(lc2);
//        assertEquals(StatutLigneCommande.NonRenseignee, lc2.getStatut());
//        
//        assertEquals(StatutCommande.Nouvelle,c1.getStatut());
//        
//        lc2 = daoLigneCommande.miseAJourStatut(lc2);
//        assertEquals(StatutLigneCommande.EnCommandeFournisseur, lc2.getStatut());
//        
//        c1.setStatut(StatutCommande.EnTraitement);
//        c1 = daoCommandeCrud.updateCommande(c1);
//        c1 = daoCommandeCrud.findByIdCommande(c1.getId());
//        c1=daoCommande.mettreAJourStatut(c1);
//     
//        assertEquals(StatutCommande.EnTraitement,c1.getStatut());
//        
//        lc2.setNbResvervees(10);
//        lc2 = daoLigneCommande.miseAJourStatut(lc2);
//        assertEquals(StatutLigneCommande.Reservee, lc2.getStatut());
        
//        for (LigneCommande lc : c1.getLignesCommandes()) 
//        {
//        	assertEquals(StatutLigneCommande.Reservee, lc.getStatut());
//		}
//        c1=daoCommande.mettreAJourStatut(c1);
//        assertEquals(StatutCommande.Prete,c1.getStatut());
        
        		
        
	}
}
