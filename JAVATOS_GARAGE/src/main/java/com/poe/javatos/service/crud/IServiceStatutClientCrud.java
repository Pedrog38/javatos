package com.poe.javatos.service.crud;

import java.util.List;

import com.poe.javatos.bean.StatutClient;

public interface IServiceStatutClientCrud {
	
	StatutClient createStatutclient(StatutClient statutClient);
	
	StatutClient findByIdStatutClient(Integer idStatutClient);
	
	List<StatutClient> findAllStatutClient();
	
	StatutClient updateStatutClient(StatutClient statutClient);
	
	void deleteByIdStatutClient(Integer idStatutClient);

}
