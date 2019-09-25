package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.repository.crud.IStatutClientRepositoryCrud;

public interface IServiceStatutClientCrud {
	
	StatutClient createStatutclient(StatutClient statutClient);
	
	Optional<StatutClient> findOptionalByIdStatutClient(Integer idStatutClient);
	
	StatutClient findByIdStatutClient(Integer idStatutClient);
	
	List<StatutClient> findAllStatutClient();
	
	StatutClient updateStatutClient(StatutClient statutClient);
	
	void deleteByIdStatutClient(Integer idStatutClient);
	
	IStatutClientRepositoryCrud getDao();

}
