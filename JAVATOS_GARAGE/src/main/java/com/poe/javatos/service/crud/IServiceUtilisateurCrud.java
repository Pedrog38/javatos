package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.repository.crud.IUtilisateurRepositoryCrud;

public interface IServiceUtilisateurCrud {
	
	List<Utilisateur> findAllUtilisateur();
	
	Utilisateur createUtilisateur(final Utilisateur uUtilisateur);
	
	void deleteByIdUtilisateur(final Integer idUtilisateur);
	
	Utilisateur updateUtilisateur(final Utilisateur uUtilisateur);
	
	Optional<Utilisateur> findOptionalByIdUtilisateur(final Integer idUtilisateur);
	
	Utilisateur findByIdUtilisateur(final Integer idUtilisateur);
	
	IUtilisateurRepositoryCrud getDao();

}
