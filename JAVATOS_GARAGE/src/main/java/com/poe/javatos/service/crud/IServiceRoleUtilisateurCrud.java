package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import com.poe.javatos.bean.RoleUtilisateur;


public interface IServiceRoleUtilisateurCrud {

		//Afficher toutes les lignes de t_role
		List<RoleUtilisateur> findAllRoleUtilisateur();
		
		//Afficher une ligne t_role par Id
		RoleUtilisateur findByIdRoleUtilisateur(final Integer idRoleUtilisateur);
		
		Optional<RoleUtilisateur> findOptionalByIdRoleUtilisateur(final Integer idRoleUtilisateur);
		
		//Creer une ligne dans t_role
		RoleUtilisateur createRoleUtilisateur(final RoleUtilisateur pRoleUtilisateur);
		
		//Modifier une ligne dans t_role par Id
		RoleUtilisateur updateRoleUtilisateur(final RoleUtilisateur pRoleUtilisateur);
		
		//Supprimer une ligne dans t_role
		void deleteByIdRoleUtilisateur(final Integer idRoleUtilisateur);
	
}
