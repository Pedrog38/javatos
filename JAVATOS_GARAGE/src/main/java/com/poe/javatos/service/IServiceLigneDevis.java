package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.LigneDevis;

public interface IServiceLigneDevis 
{
	List<LigneDevis> findByIdDevisLigneDevis(Integer idDevis);
	Float calculerPrixLigneDevis(LigneDevis ld);
}
