package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.global.StatutLigneCommande;
import com.poe.javatos.service.IServiceLigneCommande;
import com.poe.javatos.service.crud.IServiceCommandeCrud;
import com.poe.javatos.service.crud.IServiceLigneCommandeCrud;
import com.poe.javatos.service.crud.IServiceModelCrud;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsAssignation 
{

	@Autowired
	IServiceLigneCommandeCrud daoLCCrud;
	@Autowired
    IServiceCommandeCrud daoCCrud;
	@Autowired
    IServiceModelCrud daoModelCrud;
	@Autowired
	IServiceLigneCommande daoLC;
	
	
	@Test
	public void testLigneCommandeParCommande() 
	{
		LigneCommande lc10 = new LigneCommande();
        lc10.setId(1);
        lc10.setCommande(daoCCrud.findByIdCommande(1)); 
        lc10.setStatut(StatutLigneCommande.NonRenseignee);
        lc10.setModel(daoModelCrud.findByIdModel(1));
        lc10.setQuantite(10);
        lc10.setNbResvervees(0);
        
        LigneCommande lc11 = new LigneCommande();
        lc11.setId(2);
        lc11.setCommande(daoCCrud.findByIdCommande(1)); //si on la
        lc11.setStatut(StatutLigneCommande.EnCommandeFournisseur);
        lc11.setModel(daoModelCrud.findByIdModel(2));//model2 a créer ?
        lc11.setQuantite(10);
        lc11.setNbResvervees(1);
        
        
        
        
        daoLCCrud.createLigneCommande(lc10);
        daoLCCrud.createLigneCommande(lc11);
        
        List<LigneCommande> lcsCommande1 = daoLC.findByIdCommandeLigneCommande(1);
        
        assertNotNull(lcsCommande1);
        assertEquals(4,lcsCommande1.size());
        
        assertEquals(Integer.valueOf(1),lcsCommande1.get(0).getId());
        assertEquals(Integer.valueOf(2),lcsCommande1.get(1).getId());
        assertEquals(Integer.valueOf(5),lcsCommande1.get(2).getId());
        assertEquals(Integer.valueOf(6),lcsCommande1.get(3).getId());
        
        List<LigneCommande> lcsCommande2 = daoLC.findByIdCommandeLigneCommande(2);
        
        assertNotNull(lcsCommande2);
        assertEquals(4,lcsCommande2.size());
        
        assertEquals(Integer.valueOf(3),lcsCommande2.get(0).getId());
        assertEquals(Integer.valueOf(4),lcsCommande2.get(1).getId());
        assertEquals(Integer.valueOf(7),lcsCommande2.get(2).getId());
        assertEquals(Integer.valueOf(8),lcsCommande2.get(3).getId());
        
	}

}
