package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.repository.crud.IStatutClientRepositoryCrud;

@Service
public class ServiceStatutClientCrudImpl implements IServiceStatutClientCrud {
	
	@Autowired
	private IStatutClientRepositoryCrud dao;
	
	public IStatutClientRepositoryCrud getDao() {
		return dao;
	}

	@Override
	@Transactional
	public StatutClient createStatutclient(StatutClient statutClient) {
		return dao.save(statutClient);
	}

	@Override
	@Transactional
	public Optional<StatutClient> findOptionalByIdStatutClient(Integer idStatutClient) {
		return dao.findById(idStatutClient);
	}
	
	@Override
	@Transactional
	public StatutClient findByIdStatutClient(Integer idStatutClient) {
		return dao.findById(idStatutClient).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StatutClient> findAllStatutClient() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public StatutClient updateStatutClient(StatutClient statutClient) {
		return dao.save(statutClient);
	}

	@Override
	@Transactional
	public void deleteByIdStatutClient(Integer idStatutClient) {
		dao.deleteById(idStatutClient);

	}


}
