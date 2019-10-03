package com.poe.javatos.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.form.ListeDevisAValiderForm;

public interface IServiceDevis 
{
	List<Devis> findByStatutNouveauDevis()throws POEException;
	Float calculerPrixHTDevis(Devis d)throws POEException;
	Float calculerPrixTTCDevis(Devis d)throws POEException;
	Integer calculerDelaisDevis(Devis d)throws POEException;
	String traiterDevis(ListeDevisAValiderForm listeDevisForm, ModelMap model)throws POEException;
	Devis validerDevis(Devis d)throws POEException;
	Devis annulerDevis(Devis d)throws POEException;
}
