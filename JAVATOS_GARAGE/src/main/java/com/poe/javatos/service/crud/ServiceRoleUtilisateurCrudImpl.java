package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.RoleUtilisateur;
import com.poe.javatos.repository.crud.IRoleUtilisateurRepositoryCrud;

@Service
public class ServiceRoleUtilisateurCrudImpl implements IServiceRoleUtilisateurCrud {

	@Autowired
	private IRoleUtilisateurRepositoryCrud dao;
	
	public IRoleUtilisateurRepositoryCrud getDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RoleUtilisateur> findAllRoleUtilisateur() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public RoleUtilisateur findByIdRoleUtilisateur(Integer idRoleUtilisateur) {
		return dao.findById(idRoleUtilisateur).orElse(null);
		
	}

	@Override
	@Transactional
	public RoleUtilisateur createRoleUtilisateur(RoleUtilisateur pRoleUtilisateur) {
		return dao.save(pRoleUtilisateur);
		
	}

	@Override
	@Transactional
	public RoleUtilisateur updateRoleUtilisateur(RoleUtilisateur pRoleUtilisateur) {
		return dao.save(pRoleUtilisateur);
		
	}

	@Override
	@Transactional
	public void deleteByIdRoleUtilisateur(Integer idRoleUtilisateur) {
		 dao.deleteById(idRoleUtilisateur);
		
		
		
	}

	@Override
	public Optional<RoleUtilisateur> findOptionalByIdRoleUtilisateur(Integer idRoleUtilisateur) {
		// TODO Auto-generated method stub
		return dao.findById(idRoleUtilisateur);
	}

	

	
	


}
