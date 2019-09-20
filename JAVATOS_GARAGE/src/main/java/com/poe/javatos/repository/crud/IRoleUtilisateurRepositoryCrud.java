package com.poe.javatos.repository.crud;



import org.springframework.data.jpa.repository.JpaRepository;


import com.poe.javatos.bean.RoleUtilisateur;

public interface IRoleUtilisateurRepositoryCrud extends JpaRepository<RoleUtilisateur, Integer>{
	
}
