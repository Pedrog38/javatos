package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.repository.ILigneCommandeRepository;

@Service
public class ServiceLigneCommandeImpl implements IServiceLigneCommande {

	@Autowired
	ILigneCommandeRepository dao;
	
	@Override
	public List<LigneCommande> findByIdCommandeLigneCommande(Integer idCommande) 
	{
		return dao.findByCommandeLigneCommande(idCommande);
	}

}
