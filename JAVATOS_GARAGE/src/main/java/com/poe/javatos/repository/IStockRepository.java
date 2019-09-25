package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer>
{
	@Query(" select s from Stock s where s.qteCommandee>0")
    List<Stock> findStocksEnCommandeFournisseur();
	
	@Query(" select s from Stock s where s.model.id == ?1")
    List<Stock> findByIdModelStocks(Integer idModel);
}
