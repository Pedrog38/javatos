package com.poe.javatos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllTestsCRUD.class, 
	AllTestsServiceAutre.class })
public class AllTests 
{

}
