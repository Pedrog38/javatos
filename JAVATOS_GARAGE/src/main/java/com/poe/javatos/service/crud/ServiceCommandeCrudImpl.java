package com.poe.javatos.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.repository.crud.ICommandeRepositoryCrud;

@Service
public class ServiceCommandeCrudImpl implements IServiceCommandeCrud {

	@Autowired
	private ICommandeRepositoryCrud dao;
	
	public ICommandeRepositoryCrud getDao(){
		return dao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Commande> findAllCommande() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Commande createCommande(Commande commande) {
		return dao.save(commande);
	}

	@Override
	@Transactional
	public void deleteByIdCommande(Integer idCommande) {
		dao.deleteById(idCommande);
		
	}

	@Override
	@Transactional
	public Commande updateCommande(Commande commande) {
		//commande = dao.findById(commande.getId()).orElse(null);
		
		return dao.save(commande);
	}

	@Override
	@Transactional
	public Optional<Commande> findOptionalByIdCommande(Integer idCommande) {
		return dao.findById(idCommande);
	}

	@Override
	public Commande findByIdCommande(Integer idCommande) {
		
		return dao.findById(idCommande).orElse(null);
	}

}
