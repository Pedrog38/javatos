package com.poe.javatos.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;

@RestController
public class ClientRestController {
	
	@Autowired
	IServiceClientCrud serviceClientCrud;
	
	@PostMapping("/createclient")
	public @ResponseBody ResponseEntity<Client> createClient(@RequestBody Client clientACreer) {
		
		try {
			Client c = serviceClientCrud.createClient(clientACreer);
			if (c!=null && c.getId()>0) {
				return ResponseEntity.ok().body(c);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
