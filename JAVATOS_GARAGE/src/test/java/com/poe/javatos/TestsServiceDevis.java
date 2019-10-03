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

import com.poe.javatos.bean.Devis;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.service.IServiceDevis;
import com.poe.javatos.service.crud.IServiceClientCrud;
import com.poe.javatos.service.crud.IServiceDevisCrud;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsServiceDevis {

	@Autowired
	IServiceDevisCrud daoDevisCrud;
	@Autowired
	IServiceClientCrud daoClientCrud;
	@Autowired
	IServiceUtilisateurCrud daoUtilisateurCrud;
	@Autowired
	IServiceDevis daoDevis;
	
	@Test
	public void test() throws POEException 
	{
		Devis d1 = new Devis();
		 d1.setId(3);
		// d1.setDelaisProd(10);
		 Date date1= new Date();
		 d1.setDateCreation(date1);
		 d1.setStatut(StatutDevis.Nouveau);
		 d1.setClient(daoClientCrud.findByIdClient(1));
		 d1.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(1));
		 
		 Devis d2 = new Devis();
		 d2.setId(4);
		 //d2.setDelaisProd(20);
		 Date date2= new Date();
		 d2.setDateCreation(date2);
		 d2.setStatut(StatutDevis.Annule);
		 d2.setClient(daoClientCrud.findByIdClient(2));
		 d2.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(2));
		 
		 Devis d3 = new Devis();
		 d3.setId(5);
		// d3.setDelaisProd(20);
		 Date date3= new Date();
		 d3.setDateCreation(date3);
		 d3.setStatut(StatutDevis.Valide);
		 d3.setClient(daoClientCrud.findByIdClient(1));
		 d3.setCommercialResponsable(daoUtilisateurCrud.findByIdUtilisateur(1));
		 
		 daoDevisCrud.createDevis(d1);
		 daoDevisCrud.createDevis(d2);
		 daoDevisCrud.createDevis(d3);
		 
		 List<Devis> devisNouveaux = daoDevis.findByStatutNouveauDevis();
		 
		 assertNotNull(devisNouveaux);
		 assertEquals(1,devisNouveaux.size());
		 assertEquals(Integer.valueOf(3),devisNouveaux.get(0).getId());
		 
	}

}
