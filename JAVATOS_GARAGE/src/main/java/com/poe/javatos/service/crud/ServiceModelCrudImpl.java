package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Model;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.repository.crud.IModelRepositoryCrud;

@Service
public class ServiceModelCrudImpl implements IServiceModelCrud {

	@Autowired
	private IModelRepositoryCrud dao;
	
	@Autowired
	private IServiceStockCrud serviceStockCrud;
	
	public IModelRepositoryCrud getDao() {
		return dao;
	}
	
	@Override
	@Transactional(readOnly = true) //  indique au conteneur les méthodes qui doivent s'exécuter dans un contexte transactionnel.
	public List<Model> findAllModel() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Model createModel(Model mModel) 
	{
		Model m = dao.save(mModel);
		Stock s = new Stock();
		s.setModel(m);
		s.setQteCommandee(0);
		s.setQteDispo(0);
		s.setQteReservee(0);
		serviceStockCrud.createStock(s);
		return m;

	}

	@Override
	@Transactional
	public void deleteByIdModel(Integer idModel) {
		dao.deleteById(idModel);

	}

	@Override
	@Transactional
	public Model updateModel(Model mModel) {
		return dao.save(mModel);

	}
	
	@Override
	@Transactional
	public Model findByIdModel(final Integer idModel) {
		return dao.findById(idModel).orElse(null);
	}
	
	@Override
	@Transactional
	public Optional<Model> findOptionalByIdModel(final Integer idModel) {
		return dao.findById(idModel);
	}

}
