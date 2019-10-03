package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.exception.POEException;

public interface IServiceLigneDevis 
{
	List<LigneDevis> findByIdDevisLigneDevis(Integer idDevis) throws POEException;
	Float calculerPrixLigneDevis(LigneDevis ld);
	Integer calculerDelaiLigneDevis(LigneDevis lignedevis);
}
