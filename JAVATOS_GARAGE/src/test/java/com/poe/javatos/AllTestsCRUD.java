package com.poe.javatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{ TestsCRUDBeanStatutClient.class,
			TestsCRUDRoleUtilisateur.class,
			TestsCRUDModel.class,
			 TestsCRUDStock.class, 
			 TestsCRUDBeanClient.class,
			 TestsCRUDUtilisateur.class,
			 TestsCRUDBeanCommande.class,
		 TestsCRUDBeanDevis.class, 
		 TestsCRUDBeanLigneCommande.class,
		 TestsCRUDBeanLigneDevis.class
		 })
public class AllTestsCRUD {

}
