package com.poe.javatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestsServicesStock.class,
	TestsServiceCommande.class,
	TestsServiceDevis.class,
	TestsServiceLigneCommande.class,
	TestsLigneDevis.class})
public class AllTestsServiceAutre {

}
