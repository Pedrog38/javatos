package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.Utilisateur;

public interface IServiceUtilisateurCrud {
	
	List<Utilisateur> findAllUtilisateur();
	
	Utilisateur createUtilisateur(final Utilisateur uUtilisateur);
	
	void deleteByIdUtilisateur(final Integer idUtilisateur);
	
	Utilisateur updateUtilisateur(final Utilisateur uUtilisateur);
	
	Optional<Utilisateur> findOptionalByUtilisateur(final Integer idUtilisateur);
	
	Utilisateur findByUtilisateur(final Integer idUtilisateur);

}
