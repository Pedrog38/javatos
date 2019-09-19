package com.poe.javatos;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsCRUDBeanGENERAL {

	@Test
	public void testBeanVide() 
	{

			  ServiceBG dao = new ServiceBG();
			  
			  BG b1 = new BG("1","Bean1");
			  BG b2 = new BG("2","Bean2");
			  
			  dao.createBG(b1);
			  dao.createBG(b2);

			  assertEquals(b1,dao.findByIdBG("1"));
			  
			  assertEquals("Bean1", dao.findByIdBG("1").getNom());
			  //Pour chaque attribut
			  assertEquals("Bean2", dao.findByIdBG("2").getNom());
			  //Pour chaque attribut

			  dao.update("1", "Bean1Modifie");
			  dao.update("2", "Bean2Modifie");

			  assertEquals("Bean1Modifie", dao.findByIdBG("1").getNom());
			  //Pour chaque attribut
			  assertEquals("Bean2Modifie", dao.findByIdBG("2").getNom());
			  //Pour chaque attribut
			  
			  List<BG> bgs = dao.findAllBG();
			  assertEquals(bgs.size(), 2);
			  assertEquals("Bean1Modifie", bgs.get(1).getNom());
			  //Pour chaque attribut
			  assertEquals("Bean2Modifie", bgs.get(2).getNom());
			  //Pour chaque attribut
			  
			  dao.deleteByIdBG("1");
			  dao.deleteByIdBG("2");

			  assertNull(dao.findByIdBG("1"));
			  assertNull(dao.findByIdBG("2"));

	}
	@Test
	public void testBeanAsso()
	

}
