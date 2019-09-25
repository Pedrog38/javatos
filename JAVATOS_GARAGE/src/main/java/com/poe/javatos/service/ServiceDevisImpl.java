package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.global.StatutDevis;
import com.poe.javatos.repository.IDevisRepository;

@Service
public class ServiceDevisImpl implements IServiceDevis 
{

	@Autowired
	IDevisRepository dao;
	
	@Override
	public List<Devis> findByStatutNouveauDevis() 
	{
		return dao.findByStatutDevis(StatutDevis.Nouveau);
	}

}
