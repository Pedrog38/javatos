package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.repository.crud.ILigneCommandeRepositoryCrud;
import com.poe.javatos.service.IServiceLigneCommande;

@Service
public class ServiceLigneCommandeCrudImpl implements IServiceLigneCommandeCrud {



	@Autowired
	private ILigneCommandeRepositoryCrud dao;
	
	
	public ILigneCommandeRepositoryCrud getDao() {
		return dao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<LigneCommande> findAllLigneCommande() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
		return dao.save(ligneCommande);
	}

	@Override
	@Transactional
	public void deleteById(Integer idLigneCommande) {
		dao.deleteById(idLigneCommande);

	}

	@Override
	@Transactional
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande) {
		return dao.save(ligneCommande);
	}

	@Override
	@Transactional
	public Optional<LigneCommande> findOptionalByIdLigneCommande(Integer idLigneCommande) {
		return dao.findById(idLigneCommande);
	}

	@Override
	public LigneCommande findByIdLigneCommande(Integer idLigneCommande) {
		return dao.findById(idLigneCommande).orElse(null);
	}

}
