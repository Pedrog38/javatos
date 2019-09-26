package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.repository.IDevisRepository;

@Service
public class ServiceDevisImpl implements IServiceDevis 
{

	@Autowired
	IDevisRepository dao;
	
	@Autowired
	IServiceLigneDevis serviceDevis;
	
	@Override
	public List<Devis> findByStatutNouveauDevis() 
	{
		return dao.findByStatutDevis(StatutDevis.Nouveau);
	}

	@Override
	public Float calculerPrix(Devis devis) {
		float prixDevis =0;
		for (LigneDevis ld : devis.getLignesDevis()) {
			prixDevis = prixDevis+ serviceDevis.calculerLignePrixDevis(ld);
			
		}
		return prixDevis;
		 
	}

}
