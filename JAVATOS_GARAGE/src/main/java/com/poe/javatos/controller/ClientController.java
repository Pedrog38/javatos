package com.poe.javatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.ServiceClientCrudImpl;

@RestController
public class ClientController {
	
	@Autowired
	ServiceClientCrudImpl serviceclient;
	
	@RequestMapping(value = "/creerCreationClient", method = RequestMethod.POST)
	ResponseEntity<Client> addClient(@RequestBody Client personne) {
	System.err.println("add");
	this.serviceclient.createClient(personne);
	return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	
	
	}
}
