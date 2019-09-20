package com.poe.javatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.service.crud.IServiceStockCrud;
import com.poe.javatos.service.crud.ServiceStockCrudImpl;
import com.poe.javatos.service.crud.IServiceModelCrud;
import com.poe.javatos.service.crud.ServiceModelCrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUDStock {
	
	@Test
	public void testCrudStock() {

		IServiceStockCrud daoStock = new ServiceStockCrudImpl();
		IServiceModelCrud daoModel = new ServiceModelCrudImpl();
		
		//Creation de stock
		Stock s1 = new Stock();
		s1.setId(1);
		s1.setQteDispo(10);
		s1.setQteReservee(10);
		s1.setQteCommandee(10);
		s1.setModel(daoModel.findByIdModel(1));
		
		Stock s2 = new Stock();
		s2.setId(2);
		s2.setQteDispo(20);
		s2.setQteReservee(20);
		s2.setQteCommandee(20);
		s2.setModel(daoModel.findByIdModel(2));
		
		daoStock.createStock(s1);
		daoStock.createStock(s2);
		
		//Récupération des deux stocks ajoutés et verification
		Stock s1Recup = daoStock.findByIdStock(1);
		
		assertNotNull(s1Recup);
		assertEquals(Integer.valueOf(10),s1Recup.getQteDispo());
		assertEquals(Integer.valueOf(10),s1Recup.getQteReservee());
		assertEquals(Integer.valueOf(10),s1Recup.getQteCommandee());
		assertEquals(daoModel.findByIdModel(1),s1Recup.getModel());
		
		Stock s2Recup = daoStock.findByIdStock(2);
		
		assertNotNull(s2Recup);
		assertEquals(Integer.valueOf(20),s2Recup.getQteDispo());
		assertEquals(Integer.valueOf(20),s2Recup.getQteReservee());
		assertEquals(Integer.valueOf(20),s2Recup.getQteCommandee());
		assertEquals(daoModel.findByIdModel(2),s2Recup.getModel());
		
		//Modification des deux stock 
		Stock s1Modifie = s1;
		s1Modifie.setQteDispo(15);
		s1Modifie.setQteReservee(15);
		s1Modifie.setQteCommandee(15);
		s1Modifie.setModel(daoModel.findByIdModel(1));
		
		Stock s2Modifie = s2;
		s2Modifie.setQteDispo(25);
		s2Modifie.setQteReservee(25);
		s2Modifie.setQteCommandee(25);
		s2Modifie.setModel(daoModel.findByIdModel(2));
		
		daoStock.updateStock(s1Modifie);
		daoStock.updateStock(s2Modifie);
		
		Stock rRecupModifie1 = daoStock.findByIdStock(1);
		assertEquals(Integer.valueOf(15),rRecupModifie1.getQteDispo());
		assertEquals(Integer.valueOf(15),rRecupModifie1.getQteReservee());
		assertEquals(Integer.valueOf(15),rRecupModifie1.getQteCommandee());
		assertEquals(daoModel.findByIdModel(1),rRecupModifie1.getModel());
		
		Stock rRecupModifie2 = daoStock.findByIdStock(2);
		assertEquals(Integer.valueOf(25),rRecupModifie2.getQteDispo());
		assertEquals(Integer.valueOf(25),rRecupModifie2.getQteReservee());
		assertEquals(Integer.valueOf(25),rRecupModifie2.getQteCommandee());
		assertEquals(daoModel.findByIdModel(2),rRecupModifie2.getModel());
		
		
		//Afficher la liste des stock
		List<Stock> allStock = daoStock.findAllStock();
		assertEquals(2, allStock.size());
		
		assertEquals(Integer.valueOf(15),allStock.get(1).getQteDispo());
		assertEquals(Integer.valueOf(15),allStock.get(1).getQteReservee());
		assertEquals(Integer.valueOf(15),allStock.get(1).getQteCommandee());
		assertEquals(daoModel.findByIdModel(1),allStock.get(1).getModel());
		
		assertEquals(Integer.valueOf(25),allStock.get(2).getQteDispo());
		assertEquals(Integer.valueOf(25),allStock.get(2).getQteReservee());
		assertEquals(Integer.valueOf(25),allStock.get(2).getQteCommandee());
		assertEquals(daoModel.findByIdModel(2),allStock.get(2).getModel());
}


}
