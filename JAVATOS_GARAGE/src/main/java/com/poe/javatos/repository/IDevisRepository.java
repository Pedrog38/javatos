package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.global.StatutDevis;

@Repository
public interface IDevisRepository extends JpaRepository<Devis, Integer>
{
	@Query(" select d from Devis d where d.statut = ?1")
    List<Devis> findByStatutDevis(StatutDevis nouveau);
}
