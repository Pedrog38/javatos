package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.repository.crud.ILigneCommandeRepositoryCrud;

public interface IServiceLigneCommandeCrud {
	
	List<LigneCommande> findAllLigneCommande();
	
	LigneCommande createLigneCommande(final LigneCommande ligneCommande);
	
	void deleteById(final Integer idLigneCommande);
	
	LigneCommande updateLigneCommande(final LigneCommande ligneCommande);
	
	Optional<LigneCommande> findOptionalByIdLigneCommande(final Integer idLigneCommande);
 	
	LigneCommande findByIdLigneCommande(final Integer idLigneCommande);
	
	ILigneCommandeRepositoryCrud getDao();
}
