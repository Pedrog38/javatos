package com.poe.javatos.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poe.javatos.bean.Commande;

public interface CommandeRepositoryCrud extends JpaRepository<Commande, Integer> {

}
