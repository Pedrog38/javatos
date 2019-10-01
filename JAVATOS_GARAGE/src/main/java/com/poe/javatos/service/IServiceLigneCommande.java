package com.poe.javatos.service;

import java.util.List;
import com.poe.javatos.bean.LigneCommande;

public interface IServiceLigneCommande {
	List<LigneCommande> findByIdCommandeLigneCommande(Integer idCommande);

	List<LigneCommande> findByIdCommandeLigneCommandeNonRenseigne(Integer idCommande);
	
	List<LigneCommande> findByIdCommandeLigneCommandeRenseigne(Integer idCommande);

	List<LigneCommande> findByStatutEnCommandeFournisseurLignesCommande();

	LigneCommande miseAJourAssignation(LigneCommande lc, Integer qteAReserver);

	LigneCommande miseAJourStatut(LigneCommande lc);

	Integer calculerDelaiLigneCommande(LigneCommande lc);

	Float calculerPrixLigneCommande(LigneCommande commande);

}
