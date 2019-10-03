package com.poe.javatos.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.form.ListeCommandeForm;

public interface IServiceCommande 
{
	List<Commande> findByStatutNouvelleCommande();

	List<Commande> findByStatutsEnTraitementPreteCommande();

	List<Commande> findByStatutEnTraitementCommande();

	List<Commande> findByStatutPreteCommande();

	Commande mettreAJourStatut(Commande c);

	Integer calculerDelaisCommande(Commande c);

	Float calculerPrixHTCommande(Commande c);

	Float calculerPrixTTCCommande(Commande c);

	List<Commande> findByStatutNouvelleEnTraitementCommande();

	List<Commande> findCommandeByLignesCommandeNonRenseigne();

	List<Commande> findCommandeATraiter();

	String traiterVisualiserLivrerCommande( ListeCommandeForm listeCommandeForm, ModelMap model);

	Commande livrerCommande(Commande c);
}
