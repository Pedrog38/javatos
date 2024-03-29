package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.repository.crud.IDevisRepositoryCrud;
import com.poe.javatos.repository.crud.ILigneDevisRepositoryCrud;

@Service
public class ServiceDevisCrudImpl implements IServiceDevisCrud 
{

	@Autowired
	private IDevisRepositoryCrud dao;
	
	public IDevisRepositoryCrud getDao()
	{
		return dao;
	}
	
	@Override
	@Transactional
	public Devis createDevis(Devis devis) 
	{
		return dao.save(devis);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Devis> findOptionalByIdDevis(Integer idDevis) 
	{
		return dao.findById(idDevis);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Devis findByIdDevis(Integer idDevis) 
	{
		return dao.findById(idDevis).orElse(null);
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<Devis> findAllDevis() 
	{
		return dao.findAll();
	}

	@Override
	@Transactional
	public Devis updateDevis(Devis devis) 
	{
		return dao.save(devis);
	}

	@Override
	@Transactional
	public void deleteByIdDevis(Integer idDevis) 
	{
		dao.deleteById(idDevis);

	}

}
