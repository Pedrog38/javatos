package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.LigneCommande;

@Repository
public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, Integer>
{
	@Query(" select lc from LigneCommande lc where lc.commande.id = ?1")
    List<LigneCommande> findByCommandeLigneCommande(Integer idCommande);
}
