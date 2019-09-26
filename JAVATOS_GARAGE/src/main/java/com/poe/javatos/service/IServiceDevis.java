package com.poe.javatos.service;

import java.util.List;

import com.poe.javatos.bean.Devis;

public interface IServiceDevis 
{
	List<Devis> findByStatutNouveauDevis();
	Float calculerPrix(Devis devis);
}
