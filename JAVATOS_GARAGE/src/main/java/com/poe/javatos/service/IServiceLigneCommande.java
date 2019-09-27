package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.LigneDevis;

public interface IServiceLigneCommande {
	List<LigneCommande> findByIdCommandeLigneCommande(Integer idCommande);

	List<LigneCommande> findByStatutEnCommandeFournisseurLignesCommande();

	LigneCommande miseAJourAssignation(LigneCommande lc, Integer qteAReserver);

	LigneCommande miseAJourStatut(LigneCommande lc);

	Float calculerPrixLigneCommande(LigneCommande lc);
	Integer calculerDelaiLigneCommande(LigneCommande lc);
}
