package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.bean.Devis;

public interface IServiceCommande 
{
	List<Commande> findByStatutNouvelleCommande();
	List<Commande> findByStatutsEnTraitementPreteCommande();
	Commande mettreAJourStatut(Commande c);
	Integer calculerDelaisCommande(Commande c);
	Float calculerPrixHTCommande(Commande c);
	Float calculerPrixTTCCommande(Commande c);
	List<Commande> findByStatutNouvelleEnTraitementCommande();
	List<Commande> findCommandeByLignesCommandeNonRenseigne();
	List<Commande> findCommandeATraiter();
}
