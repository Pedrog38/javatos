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
	IServiceLigneDevis service;
	
	@Override
	public List<Devis> findByStatutNouveauDevis() 
	{
		return dao.findByStatutDevis(StatutDevis.Nouveau);
	}

	@Override
	public Float calculerPrixDevis(Devis d) {
		Float prixtotal = (float) 0;
		for (LigneDevis ld : d.getLignesDevis()) {
			Float prixligne = service.calculerPrixLigneDevis(ld);
			
			prixtotal = prixligne + prixtotal;
		}
		
		return prixtotal;
	}

	@Override
	public Integer calculerDelaisDevis(Devis d) 
	{
		Integer delaiDevis = 0;
		for (LigneDevis ld : d.getLignesDevis()) {
		Integer delaiLigneDevisEnCours = service.calculerDelaiLigneDevis(ld); 
		delaiDevis = Math.max(delaiDevis, delaiLigneDevisEnCours);
			
		}
		
		return delaiDevis;
	}

}
