package com.poe.javatos.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.form.ListeDevisAValiderForm;

public interface IServiceDevis 
{
	List<Devis> findByStatutNouveauDevis();
	Float calculerPrixHTDevis(Devis d);
	Float calculerPrixTTCDevis(Devis d);
	Integer calculerDelaisDevis(Devis d);
	String traiterDevis(ListeDevisAValiderForm listeDevisForm, ModelMap model);
	Devis validerDevis(Devis d);
	Devis annulerDevis(Devis d);
}
