package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Float calculerPrixHTDevis(Devis d) {
		
		Float prixtotal = (float) 0;
		for (LigneDevis ld : service.findByIdDevisLigneDevis(d.getId())) {
			Float prixligne = service.calculerPrixLigneDevis(ld);
			
			prixtotal = prixligne + prixtotal;
		}
		
		return prixtotal;
	}

	@Override
	@Transactional
	public Integer calculerDelaisDevis(Devis d) 
	{
		Integer delaiDevis = 0;
		for (LigneDevis ld : service.findByIdDevisLigneDevis(d.getId())) {
		Integer delaiLigneDevisEnCours = service.calculerDelaiLigneDevis(ld); 
		delaiDevis = Math.max(delaiDevis, delaiLigneDevisEnCours);
			
		}
		
		return delaiDevis;
	}

	@Override
	public Float calculerPrixTTCDevis(Devis d) 
	{
		Float prixHT = calculerPrixHTDevis(d);
		Float TVA = prixHT*(d.getClient().getStatut().getTauxTva()/100);
		return prixHT+TVA;
	}

}
