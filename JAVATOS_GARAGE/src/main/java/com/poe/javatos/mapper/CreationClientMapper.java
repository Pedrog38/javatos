package com.poe.javatos.mapper;

import java.util.Date;

import com.poe.javatos.bean.Client;
import com.poe.javatos.form.CreationClientForm;

public class CreationClientMapper 
{
	public static Client remplirClient(CreationClientForm cForm)
	{
		Client client = new Client();
		client.setNom(cForm.getNom());
		client.setPrenom(cForm.getPrenom());
		client.setDateCreation(new Date());
		client.setAdresse(cForm.getAdresse());
		client.setMail(cForm.getMail());
		client.setSexe(cForm.getSexe());
		client.setTelephone(cForm.getTelephone());
		client.setStatut(cForm.getStatutClient());
		return client;
	}
	
}
