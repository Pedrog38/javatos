package com.poe.javatos.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.Devis;
import com.poe.javatos.bean.Utilisateur;
import com.poe.javatos.form.CreationDevisForm;
import com.poe.javatos.form.CreationLigneDevisForm;
import com.poe.javatos.global.StatutDevis;


public class CreationDevisMapper 
{
	public static CreationDevisForm remplirCreationDevisForm()
	{
		CreationDevisForm creationDevisForm = new CreationDevisForm();
		
		List<CreationLigneDevisForm> lp =  new ArrayList<CreationLigneDevisForm>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		creationDevisForm.setSubmit("");
		
		creationDevisForm.setDateDevis(format.format(date));
		
		CreationLigneDevisForm cldf = new CreationLigneDevisForm();
		cldf.setQuantite(0);
		
		lp.add(cldf);
		
		creationDevisForm.setLignedevis(lp);
		
		return creationDevisForm;
	}
	
	public static Devis remplirCreationDevisForm(CreationDevisForm creationDevisForm, Client client, Utilisateur commercial)
	{
		Devis d = new Devis();
		d.setClient(client);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try 
		{
			Date dateCreation = format.parse(creationDevisForm.getDateDevis());
			d.setDateCreation(dateCreation);
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		d.setStatut(StatutDevis.Nouveau);
		d.setCommercialResponsable(commercial);
		return d;
	}
	
		
}
