package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.RoleUtilisateur;
import com.poe.javatos.service.crud.IServiceRoleUtilisateurCrud;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDRoleUtilisateur {
	@Autowired
	IServiceRoleUtilisateurCrud daoRole;
	
	@Test
	public void testCrudRole() {

		//IServiceRoleUtilisateurCrud daoRole = new ServiceRoleUtilisateurCrudImpl();
		
		//Creation de deux Roles
		RoleUtilisateur r1 = new RoleUtilisateur();
		r1.setId(1);
		r1.setNom("Commercial");
		
		RoleUtilisateur r2 = new RoleUtilisateur();
		r2.setId(2);
		r2.setNom("Magasinier");
		
		System.err.println(daoRole.getDao());
		daoRole.createRoleUtilisateur(r1);
		daoRole.createRoleUtilisateur(r2);
		
		//Récuperation des deux rôles crées
		RoleUtilisateur r1Recup = daoRole.findByIdRoleUtilisateur(1);
		
		assertNotNull(r1Recup);
		assertEquals("Commercial", r1Recup.getNom());
		
		
		RoleUtilisateur r2Recup = daoRole.findByIdRoleUtilisateur(2);
		
		assertNotNull(r2Recup);
		assertEquals("Magasinier", r2Recup.getNom());
		
	
		//Modification des deux roles
		RoleUtilisateur r1Modifie = r1;
		r1Modifie.setNom("CommercialMod");
		
		RoleUtilisateur r2Modifie = r2;
		r2Modifie.setNom("MagasinierMod");
		
		daoRole.updateRoleUtilisateur(r1Modifie);
		daoRole.updateRoleUtilisateur(r2Modifie);
		
		
		
		RoleUtilisateur rRecupModifie1 = daoRole.findByIdRoleUtilisateur(1);
		assertEquals("CommercialMod", rRecupModifie1.getNom());

		RoleUtilisateur rRecupModifie2 = daoRole.findByIdRoleUtilisateur(2);
		assertEquals("MagasinierMod", rRecupModifie2.getNom());
		
		
		//Afficher la liste des roles
		List<RoleUtilisateur> allRoleUtilisateur = daoRole.findAllRoleUtilisateur();
		assertEquals(2, allRoleUtilisateur.size());
		
		assertEquals("CommercialMod", allRoleUtilisateur.get(0).getNom());
		assertEquals("MagasinierMod", allRoleUtilisateur.get(1).getNom());


	}
}
