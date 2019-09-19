package com.poe.javatos.service.crud;

import java.util.List;

import com.poe.javatos.bean.Model;

public interface IServiceModelCrud {
	
	List<Model> getAllModel();
	
	void creerModel(final Model mModel);
	
	void supprimerModel(final Integer idModel);
	
	void modifierModel(final List<Model> mListeModel);
		
}
