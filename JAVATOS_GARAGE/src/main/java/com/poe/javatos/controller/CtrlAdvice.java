package com.poe.javatos.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class CtrlAdvice extends DefaultHandlerExceptionResolver implements ErrorViewResolver {

	@ExceptionHandler(Exception.class)
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();

        mav.addObject("titre", "Erreur Générale");
        mav.addObject("MsgErr", status.getReasonPhrase());
        mav.setViewName("Erreur");

        return mav;
	}

}