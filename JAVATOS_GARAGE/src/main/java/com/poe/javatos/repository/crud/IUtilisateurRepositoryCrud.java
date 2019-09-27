package com.poe.javatos.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poe.javatos.bean.Utilisateur;

public interface IUtilisateurRepositoryCrud extends JpaRepository<Utilisateur, Integer> {


}
