package com.poe.javatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{ TestsCRUDBeanStatutClient.class,
			TestCRUDRoleUtilisateur.class,
			TestCRUDModel.class,
			 TestCRUDStock.class, 
			 TestsCRUDBeanClient.class,
			 TestCRUDUtilisateur.class,
		 TestsCRUDBeanDevis.class, 
		 TestsCRUDBeanLigneDevis.class
		 })
public class AllTestsCRUD {

}
