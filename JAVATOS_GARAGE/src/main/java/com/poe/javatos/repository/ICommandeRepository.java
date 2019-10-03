package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.global.StatutCommande;
import com.poe.javatos.global.StatutLigneCommande;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande, Integer>
{
	@Query(" select c from Commande c where c.statut = ?1")
    List<Commande> findByStatutCommande(StatutCommande statut);
	
	@Query(" select c from Commande c where c.statut = ?1 OR c.statut = ?2")
    List<Commande> findByStatutsCommande(StatutCommande statut1, StatutCommande statut2);
	
	@Query(" select distinct c from Commande c, LigneCommande lc where lc.commande.id=c.id and lc.statut=?1")
    List<Commande> findCommandeByStatutLigneCommande(StatutLigneCommande statutLigneCommande);

}
