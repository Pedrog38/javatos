package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.global.StatutLigneCommande;

@Repository
public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, Integer>
{
	@Query(" select lc from LigneCommande lc where lc.commande.id = ?1")
    List<LigneCommande> findByCommandeLigneCommande(Integer idCommande);
	
	@Query(" select lc from LigneCommande lc where lc.statut = ?1")
    List<LigneCommande> findByStatutLignesCommande(StatutLigneCommande encommandefournisseur);
	
	@Query(" select lc from LigneCommande lc where lc.commande.id = ?1 and lc.statut = ?2")
    List<LigneCommande> findByCommandeLigneCommandeStatut(Integer idCommande, StatutLigneCommande statut);

	@Query(" select lc from LigneCommande lc where lc.commande.id = ?1 and (lc.statut = ?2 or lc.statut = ?3)")
    List<LigneCommande> findByCommandeLigneCommandeStatuts(Integer idCommande, StatutLigneCommande statut1, StatutLigneCommande statut2);
}
