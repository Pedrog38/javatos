package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

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
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsServiceCommande {

	@Autowired
	IServiceCommandeCrud daoCommandeCrud;
	@Autowired
    IServiceClientCrud daoClientCrud;
	@Autowired
    IServiceUtilisateurCrud daoUtilisateurCrud;
	@Autowired
	IServiceCommande daoCommande;


	
	@Test
	public void testCommandeFinds() 
	{
        
        // créer au moins 2 objet Commande et les setter 
        Commande c1 = new Commande();
        c1.setId(3);
       // c1.setDelaisProd(11);
        Date datec1= new Date();
        c1.setDateCreation(datec1);
        c1.setStatut(StatutCommande.Nouvelle);
        c1.setClient(daoClientCrud.findByIdClient(1));
        //c1.setLignesDevis(daoLignesDevis.findAllLignesDevis);
        c1.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(1));
        
        Commande c2 = new Commande();
        c2.setId(4);
       // c2.setDelaisProd(22);
        Date datec2= new Date();
        c2.setDateCreation(datec2);
        c2.setStatut(StatutCommande.EnTraitement);
        c2.setClient(daoClientCrud.findByIdClient(2));
        //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
        c2.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(2));
        
        Commande c3 = new Commande();
        c3.setId(5);
        //c3.setDelaisProd(22);
        Date datec3= new Date();
        c3.setDateCreation(datec3);
        c3.setStatut(StatutCommande.Prete);
        c3.setClient(daoClientCrud.findByIdClient(1));
        //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
        c3.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(1));
        
        Commande c4 = new Commande();
        c4.setId(6);
        //c4.setDelaisProd(22);
        Date datec4= new Date();
        c4.setDateCreation(datec4);
        c4.setStatut(StatutCommande.Livree);
        c4.setClient(daoClientCrud.findByIdClient(2));
        //d2.setLignesDevis(daoLignesDevis.findAllLignesDevis);
        c4.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(2));
        
        daoCommandeCrud.createCommande(c1);
        daoCommandeCrud.createCommande(c2);
        daoCommandeCrud.createCommande(c3);
        daoCommandeCrud.createCommande(c4);
        
        List<Commande> commandesNouvelle = daoCommande.findByStatutNouvelleCommande();
        
        assertNotNull(commandesNouvelle);
        assertEquals(1,commandesNouvelle.size());
        assertEquals(Integer.valueOf(3),commandesNouvelle.get(0).getId());
        
        List<Commande> commandesTraitementPrete = daoCommande.findByStatutsEnTraitementPreteCommande();
        
        assertNotNull(commandesTraitementPrete);
        assertEquals(2,commandesTraitementPrete.size());
        assertEquals(Integer.valueOf(4),commandesTraitementPrete.get(0).getId());
        assertEquals(Integer.valueOf(5),commandesTraitementPrete.get(1).getId());
        
	}
	
	
	

}
