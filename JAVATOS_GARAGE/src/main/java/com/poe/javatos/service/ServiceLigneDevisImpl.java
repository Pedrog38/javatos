package com.poe.javatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.repository.ILigneDevisRepository;

@Service
public class ServiceLigneDevisImpl implements IServiceLigneDevis {

	@Autowired
	ILigneDevisRepository dao;
	
	@Override
	public List<LigneDevis> findByIdDevisLigneDevis(Integer idDevis) 
	{
		return dao.findByDevisLigneDevis(idDevis);
	}

}
