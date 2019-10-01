package com.poe.javatos.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class CreationDevisMapper 
{
	
	private List<CreationLigneDevisMapper> lignedevis;
	
	private int idClient;
	
	private String DateDevis;
	
	private String submit;



	public List<CreationLigneDevisMapper> getLignedevis() {
		return lignedevis;
	}

	public void setLignedevis(List<CreationLigneDevisMapper> lignedevis) {
		this.lignedevis = lignedevis;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getDateDevis() {
		return DateDevis;
	}

	public void setDateDevis(String dateDevis) {
		DateDevis = dateDevis;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	@Override
	public String toString() {
		return "CreationDevisForm [lignedevis=" + lignedevis + ", idClient=" + idClient + ", DateDevis=" + DateDevis
				+ ", submit=" + submit + "]";
	}

	
		
}
