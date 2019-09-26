package com.poe.javatos.service.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.javatos.bean.Utilisateur;

@RestController
@RequestMapping("/user")
public class SpringController {
	
	@GetMapping
	public ResponseEntity<Utilisateur> getUser(){
		
		Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
	}
	

}
