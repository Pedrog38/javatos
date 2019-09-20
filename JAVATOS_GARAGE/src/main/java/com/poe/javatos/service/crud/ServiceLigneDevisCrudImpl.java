package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.repository.crud.ILigneDevisRepositoryCrud;

@Service
public class ServiceLigneDevisCrudImpl implements IServiceLigneDevisCrud 
{

	@Autowired
	private ILigneDevisRepositoryCrud dao;
	
	public ILigneDevisRepositoryCrud getDao()
	{
		return dao;
	}
	
	@Override
	@Transactional
	public LigneDevis createLigneDevis(LigneDevis ligneDevis) 
	{
		return dao.save(ligneDevis);
	}

	@Override
	@Transactional(readOnly = true)
	public LigneDevis findByIdLigneDevis(Integer idLigneDevis) 
	{
		return dao.findById(idLigneDevis).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<LigneDevis> findOptionalByIdLigneDevis(Integer idLigneDevis) 
	{
		return dao.findById(idLigneDevis);
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<LigneDevis> findAllLigneDevis() 
	{
		return dao.findAll();
	}

	@Override
	@Transactional
	public LigneDevis updateLigneDevis(LigneDevis ligneDevis) 
	{
		return dao.save(ligneDevis);
	}

	@Override
	@Transactional
	public void deleteByIdLigneDevis(Integer idLigneDevis) 
	{
		dao.deleteById(idLigneDevis);

	}

}
