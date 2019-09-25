package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Model;
import com.poe.javatos.repository.crud.IModelRepositoryCrud;

public interface IServiceModelCrud {
	
	List<Model> findAllModel();
	
	Model createModel(final Model mModel);
	
	void deleteByIdModel(final Integer idModel);
	
	Model updateModel(final Model mModel);
	
	Optional<Model> findOptionalByIdModel(final Integer idModel);
	
    Model findByIdModel(final Integer idModel);
    
    IModelRepositoryCrud getDao();
}
