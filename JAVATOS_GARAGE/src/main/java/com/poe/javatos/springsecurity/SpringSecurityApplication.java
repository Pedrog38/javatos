package com.poe.javatos.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.poe.javatos.springsecurity.repo.UserRepository;
import com.poe.javatos.springsecurity.service.UserService;

public class SpringSecurityApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	UserService userDetailsService;
	
	@Override
	public void run(String... args) throws Exception {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
	}

}
