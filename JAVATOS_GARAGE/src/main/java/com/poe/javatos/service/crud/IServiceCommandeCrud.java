package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Commande;

public interface IServiceCommandeCrud {
	
	List<Commande> findAllCommande();
	
	Commande createCommande(final Commande commande);
	
	void deleteByIdCommande(final Integer idCommande);
	
	Commande updateCommande(final Commande commande);
	
	Optional<Commande> findOptionalByIdCommande(final Integer idCommande);

	Commande findByIdCommande(final Integer idCommande);
}
