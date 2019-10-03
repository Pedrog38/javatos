package com.poe.javatos.restcontroller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.StatutClient;
import com.poe.javatos.service.crud.IServiceClientCrud;

@RestController
public class HellorestController {
	
	@Autowired
	IServiceClientCrud dao;
	
	@GetMapping("/hello")
	String salutToutLeMonde() {
		return "Hello the world";
	}
	
	@GetMapping(value = "/client/{id}", produces = "application/json")
	public Client getClient(@PathVariable(value = "id") int id) {
		Client c = new Client();
		// remplir client
		c.setId(id);
		c.setNom("JONG UN");
		c.setPrenom("KIM");
		c.setDateCreation(new Date());
		StatutClient statut = new StatutClient();
		statut.setNom("statutest");
		c.setStatut(statut);
		return c;
	}
	
	@GetMapping(value = "/clientdb/{id}", produces = "application/json")
	public @ResponseBody ResponseEntity<Client> getClientDb(@PathVariable(value = "id") int id) {
		
		try {
			Client c = dao.findByIdClient(id);
			if (c!=null) {
				return ResponseEntity.ok().body(c);
			}
		}
		catch (Exception e) {}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
