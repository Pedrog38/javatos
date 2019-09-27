package com.poe.javatos.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;


public class CreationDevisForm 
{
	
	private List<CreationLigneDevisForm> lignedevis;
	
	private int idClient;
	
	private String DateDevis;
	
	private String submit;

	public List<CreationLigneDevisForm> getLignedevis() {
		return lignedevis;
	}

	public void setLignedevis(List<CreationLigneDevisForm> lignedevis) {
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
