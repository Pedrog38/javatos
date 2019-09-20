package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.repository.crud.IUtilisateurRepositoryCrud;

public class ServiceUtilisateurCrudImpl implements IServiceUtilisateurCrud {
	
	@Autowired
	private IUtilisateurRepositoryCrud dao;
	
	public IUtilisateurRepositoryCrud getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> findAllUtilisateur() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Utilisateur createUtilisateur(Utilisateur uUtilisateur) {
			return dao.save(uUtilisateur);

	}

	@Override
	@Transactional
	public void deleteByIdUtilisateur(Integer idUtilisateur) {
		dao.deleteById(idUtilisateur);

	}

	@Override
	@Transactional
	public Utilisateur updateUtilisateur(Utilisateur uUtilisateur) {
		return dao.save(uUtilisateur);
	}

	@Override
	@Transactional
	public Optional<Utilisateur> findByUtilisateur(Integer idUtilisateur) {
			return dao.findById(idUtilisateur);
	}

}
