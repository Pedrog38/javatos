package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Client;
import com.poe.javatos.repository.crud.IClientRepositoryCrud;

@Service
public class ServiceClientCrudImpl implements IServiceClientCrud {
	
	@Autowired
	private IClientRepositoryCrud dao;
	
	public IClientRepositoryCrud getDao() {
		return dao;
	}

	@Override
	@Transactional
	public Client createClient(Client client) {
		return dao.save(client);
	}

	@Override
	@Transactional
	public Optional<Client> findByIdClient(Integer idClient) {
		return dao.findById(idClient);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAllClient() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Client updateClient(Client client) {
		return dao.save(client);
	}

	@Override
	@Transactional
	public void deleteByIdClient(Integer idClient) {
		dao.deleteById(idClient);

	}

}
