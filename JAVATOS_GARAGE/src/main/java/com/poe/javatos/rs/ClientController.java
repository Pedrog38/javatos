package com.poe.javatos.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Client;
import com.poe.javatos.service.crud.IServiceClientCrud;

@RestController
public class ClientController {
	
	@Autowired
	IServiceClientCrud serviceClient;
	
	@PostMapping(path="/createclient",
		produces= MediaType.APPLICATION_JSON_VALUE ,
		consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createAClient(@RequestBody Client clientToSave){
		
	try{
		Client newClient = serviceClient.createClient(clientToSave) ;
		if (newClient !=null && newClient .getId() > 0 )
		    return ResponseEntity.ok().body(newClient) ;
	     }
		catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);


}
}
