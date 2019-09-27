package com.poe.javatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;

@Repository
public interface ILigneDevisRepository extends JpaRepository<Devis, Integer>
{
	@Query(" select ld from LigneDevis ld where ld.devis.id = ?1")
    List<LigneDevis> findByDevisLigneDevis(Integer idDevis);
}
