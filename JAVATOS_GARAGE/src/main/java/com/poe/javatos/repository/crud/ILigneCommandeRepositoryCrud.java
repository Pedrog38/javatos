package com.poe.javatos.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poe.javatos.bean.LigneCommande;

public interface ILigneCommandeRepositoryCrud extends JpaRepository<LigneCommande, Integer> {

}
