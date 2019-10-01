package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.exception.POEException;

public interface IServiceDevis 
{
	List<Devis> findByStatutNouveauDevis() throws POEException;
	Float calculerPrixDevis(Devis d) throws POEException;
	
	Integer calculerDelaisDevis(Devis d) throws POEException;
}
