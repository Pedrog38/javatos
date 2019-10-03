package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.repository.ILigneDevisRepository;

@Service
public class ServiceLigneDevisImpl implements IServiceLigneDevis {

	@Autowired
	ILigneDevisRepository dao;
	
	@Override
	public List<LigneDevis> findByIdDevisLigneDevis(Integer idDevis) throws POEException 
	{
		if (idDevis==null || idDevis<1) throw new POEException("Id de Devis invalide " + idDevis);
		return dao.findByDevisLigneDevis(idDevis);
	}

	@Override
	public Float calculerPrixLigneDevis(LigneDevis ld) {
		Float prix = (float) 0;
		Float prixModel =(float) 0;
		Integer quantite =0;
		
		prixModel = ld.getModel().getPrixVente();
		quantite = ld.getQuantite();
		
		prix = prixModel * quantite;
		return prix;
	}

	@Override
	public Integer calculerDelaiLigneDevis(LigneDevis lignedevis) {
		Integer delaiTotal = 0;
		delaiTotal = lignedevis.getQuantite()* lignedevis.getModel().getDelaisProd();
		return delaiTotal;
	}

}
