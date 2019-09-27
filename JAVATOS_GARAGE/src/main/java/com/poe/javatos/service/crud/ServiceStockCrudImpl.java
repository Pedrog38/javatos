package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Stock;
import com.poe.javatos.repository.crud.IStockRepositoryCrud;

@Service
public class ServiceStockCrudImpl implements IServiceStockCrud {

	@Autowired
	private IStockRepositoryCrud dao;
	
	public IStockRepositoryCrud getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Stock> findAllStock() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Stock findByIdStock(Integer idStock) {
		return dao.findById(idStock).orElse(null);
		
	}

	@Override
	@Transactional
	public Stock createStock(Stock pStock) {
		return dao.save(pStock);
		
	}

	@Override
	@Transactional
	public Stock updateStock(Stock pStock) {
		return dao.save(pStock);
		
	}

	@Override
	@Transactional
	public void deleteByIdStock(Integer idStock) {
		dao.deleteById(idStock);
		
	}

	@Override
	public Optional<Stock> findOptionalByIdStock(Integer idStock) {
		return dao.findById(idStock);
	}
	
	

	

}
