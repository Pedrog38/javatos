package com.poe.javatos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Model;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.repository.IStockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testServiceStock {

	@Autowired	
	IServiceStock iss; 
	
	@Autowired
	IStockRepository dao;
	

	@Test
	public void testFindByIdModel()
	{
		Integer id = 1;
		Stock model1 = null;
		try  {
			model1 = iss.findByIdModelStock(id);
		}
		catch (Exception e) {
			fail("Probleme interrogation service avec id" +id);
		}
		assertNotNull(model1);
		assertEquals((int)model1.getId(),1);
		assertEquals((int)model1.getQteDispo(),45);
	}
	
	@Test (expected = POEException.class)
	public void testStockExisteNot() throws POEException {
		Integer id = 99;
		iss.findByIdModelStock(id);
	}

	
	@Test(expected = NullPointerException.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
	    String test = null;
	    test.length();
	}
}
