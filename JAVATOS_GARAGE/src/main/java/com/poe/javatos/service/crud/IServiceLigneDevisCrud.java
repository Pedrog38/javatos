package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.repository.crud.ILigneDevisRepositoryCrud;

public interface IServiceLigneDevisCrud 
{
	LigneDevis createLigneDevis(LigneDevis ligneDevis);
	Optional<LigneDevis> findOptionalByIdLigneDevis(Integer idLigneDevis);
	LigneDevis findByIdLigneDevis(Integer idLigneDevis);
	List<LigneDevis> findAllLigneDevis();
	LigneDevis updateLigneDevis(LigneDevis ligneDevis);
	void deleteByIdLigneDevis(Integer idLigneDevis);
	ILigneDevisRepositoryCrud getDao();
}
