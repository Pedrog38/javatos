package com.poe.javatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Tout accès à url <host>/user/** nécessite d’être authentifié. 
 * L’authentification se fait via une requête de type Post à url <host>/login.
 * @author Mr Security
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value ="/login", method = ResquestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value ="logout", required = false) String logout {
				
				ModelAndView model = new ModelAndView();
				if (error != null) {
					model.addObject("error", "Mauvais nom d'utilisateur ou mot de passe!");
				}
				
				if (logout != null) {
					model.addObject("msg",)
				}
			}
			
			
			
			)
	
	

	
	
}
