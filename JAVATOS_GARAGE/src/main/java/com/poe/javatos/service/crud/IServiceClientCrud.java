package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Client;
import com.poe.javatos.repository.crud.IClientRepositoryCrud;

public interface IServiceClientCrud {
	
	Client createClient(Client client);
	
	Optional<Client> findOptionalByIdClient(Integer idClient);
	
	Client findByIdClient(Integer idClient);
	
	List<Client> findAllClient();
	
	Client updateClient(Client client);
	
	void deleteByIdClient(Integer idClient);
	
	IClientRepositoryCrud getDao();

}
