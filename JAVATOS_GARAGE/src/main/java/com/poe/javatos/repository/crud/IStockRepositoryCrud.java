package com.poe.javatos.repository.crud;



import org.springframework.data.jpa.repository.JpaRepository;

import com.poe.javatos.bean.Stock;

public interface IStockRepositoryCrud extends JpaRepository<Stock, Integer>{

		
	
}
