package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Commande;

public interface IServiceCommande 
{
	List<Commande> findByStatutNouvelleCommande();
	List<Commande> findByStatutsEnTraitementPreteCommande();
}
