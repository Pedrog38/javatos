package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.repository.crud.IDevisRepositoryCrud;



public interface IServiceDevisCrud 
{
	Devis createDevis(Devis devis);
	Optional<Devis> findOptionalByIdDevis(Integer idDevis);
	Devis findByIdDevis(Integer idDevis);
	List<Devis> findAllDevis();
	Devis updateDevis(Devis devis);
	void deleteByIdDevis(Integer idDevis);
	IDevisRepositoryCrud getDao();
}
