package com.poe.javatos.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poe.javatos.bean.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query(" select u from Utilisateur u " +
            " where u.username = ?1")
    Optional<Utilisateur> findUserWithName(String username);

}
