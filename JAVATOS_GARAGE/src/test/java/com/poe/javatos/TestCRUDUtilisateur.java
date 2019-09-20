package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.service.crud.IServiceUtilisateurCrud;
import com.poe.javatos.service.crud.ServiceUtilisateurCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUDUtilisateur {
	
	
	@Test
	public void testCRUDUtilisateur () {
		IServiceUtilisateurCrud dao = new ServiceUtilisateurCrudImpl();
		
		Utilisateur u1 = new Utilisateur();
		u1.setId(1);
		u1.setFonction("Commercial");
		u1.setNom("KEBBAJ");
		u1.setPrenom("Yassine");
		u1.setUsername("20Shadows");
		u1.setPassword("natacha");

		Utilisateur u2 = new Utilisateur();
		u1.setId(2);
		u1.setFonction("Magasinier");
		u1.setNom("Dupont");
		u1.setPrenom("Jean");
		u1.setUsername("Tanaka");
		u1.setPassword("Japon");
		
		//TEST CREATE
		
		dao.createUtilisateur(u1);
		dao.createUtilisateur(u2);
		
		Utilisateur uRecup1 = dao.findByUtilisateur(1);
		assertNotNull(uRecup1);
		assertEquals("Commercial",uRecup1.getFonction());
		assertEquals("KEBBAJ",uRecup1.getNom());
		assertEquals("Yassine",uRecup1.getPrenom());
		assertEquals("20Shadows",uRecup1.getUsername());
		assertEquals("natacha",uRecup1.getPassword());
		
		Utilisateur uRecup2 = dao.findByUtilisateur(2);
		assertNotNull(uRecup2);
		assertEquals("Magasinier",uRecup2.getFonction());
		assertEquals("Dupont",uRecup2.getNom());
		assertEquals("Jean",uRecup2.getPrenom());
		assertEquals("Tanaka",uRecup2.getUsername());
		assertEquals("Japon",uRecup2.getPassword());
		
		
		//TEST UPDATE
		Utilisateur u1Modifie = u1;
		u1Modifie.setFonction("Stagiaire");
		Utilisateur u2Modifie = u2;
		u2Modifie.setFonction("Alternant");
		
		dao.updateUtilisateur(u1Modifie);
		dao.updateUtilisateur(u2Modifie);
		
		Utilisateur uRecupModifie1 = dao.findByUtilisateur(1);
		assertEquals("Stagiaire",uRecupModifie1.getFonction());
		assertEquals("KEBBAJ",uRecupModifie1.getNom());
		assertEquals("Yassine",uRecupModifie1.getPrenom());
		assertEquals("20Shadows",uRecupModifie1.getUsername());
		assertEquals("natacha",uRecupModifie1.getPassword());
		
		Utilisateur uRecupModifie2 = dao.findByUtilisateur(2);
		assertEquals("Alternant",uRecupModifie2.getFonction());
		assertEquals("KEBBAJ",uRecupModifie2.getNom());
		assertEquals("Yassine",uRecupModifie2.getPrenom());
		assertEquals("20Shadows",uRecupModifie2.getUsername());
		assertEquals("natacha",uRecupModifie2.getPassword());
		
		//TEST FIND ALL
		
		List<Utilisateur>allUtilisateur = dao.findAllUtilisateur();
		assertEquals(2,allUtilisateur.size());
		
		assertEquals("Stagiaire",allUtilisateur.get(1).getFonction());
		assertEquals("KEBBAJ",allUtilisateur.get(1).getNom());
		assertEquals("Yassine",allUtilisateur.get(1).getPrenom());
		assertEquals("20Shadows",allUtilisateur.get(1).getUsername());
		assertEquals("natacha",allUtilisateur.get(1).getPassword());
		
		assertEquals("Alternant",allUtilisateur.get(2).getFonction());
		assertEquals("KEBBAJ",allUtilisateur.get(2).getNom());
		assertEquals("Yassine",allUtilisateur.get(2).getPrenom());
		assertEquals("20Shadows",allUtilisateur.get(2).getUsername());
		assertEquals("natacha",allUtilisateur.get(2).getPassword());
		
		
	}

	
}
