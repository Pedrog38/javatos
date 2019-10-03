package com.poe.javatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.exception.POEException;
import com.poe.javatos.service.IServiceStock;
import com.poe.javatos.service.crud.IServiceClientCrud;

@RestController
public class HelloController {
	
	@Autowired
	IServiceClientCrud serviceClient;
	
	@Autowired
	IServiceStock serviceStock;
	
	@GetMapping("/hello")
	String salutLesKikis() {
		return "hello Yasmine";
	}
	
	
	@GetMapping(value ="/client", produces = "application/json")
	public Client donneMoiUnClient() {
		Client c = new Client();
		c.setNom("georges");
		c.setSexe("HOMME");
		c.setMail("georges@gmail.com");	
		return c;
	}
	
	@GetMapping(value ="/client/{id}", produces = "application/json")
	public Client donneMoiUnClient(@PathVariable(value ="id") Integer idClient) {	
		Client c = new Client();
		c.setId(idClient);
		c.setNom("georges");
		c.setSexe("HOMME");
		c.setMail("georges@gmail.com");	
		return c;
	}
	
	
	@GetMapping(value ="/client2/{id}", produces = "application/json")
	public Client chercherUnClientParLid(@PathVariable(value ="id") Integer idClient) {	
		Client c = serviceClient.findByIdClient(idClient);
		return c;
	}
	
	@GetMapping(value ="/stock/{idModel}", produces = "application/json")
	public Stock chercherUnStockParLidModel(@PathVariable(value ="idModel") Integer idModel) throws POEException {	
		Stock s = serviceStock.findByIdModelStock(idModel);
		return s;
	}
	
	@GetMapping(value ="/bonjourClient/{id}", produces = "application/json")
	public @ResponseBody ResponseEntity<Client> 
		bonjourClient(@PathVariable(value = "id") Integer idClient) {
		try {
			Client c = serviceClient.findByIdClient(idClient);
			if (c!=null) return ResponseEntity.ok().body(c);
		}
		catch (Exception e)
		{			
		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
	
		


