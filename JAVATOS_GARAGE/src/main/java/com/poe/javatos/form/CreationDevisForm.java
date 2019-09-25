package com.poe.javatos.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.poe.javatos.bean.Client;
import com.poe.javatos.bean.LigneDevis;
import com.poe.javatos.bean.Model;


public class CreationDevisForm 
{
	@NotEmpty(message = "{creation.Devis.delais.notempty}")	
	@Min(value=0, message = "{creation.Devis.delais.positive}")
	private Integer delaisProd;
	
	@NotEmpty(message = "{creation.Devis.dateCreation.notempty}")	
	private String dateCreation;
	
	@NotEmpty(message = "{creation.Devis.idClient.notempty}")	
	private Integer idClient;
	
	private Client client;
	
	
	@NotEmpty(message = "{creation.Devis.idCommercialResponsable.notempty}")	
	private Integer idCommercialResponsable;
	
	@NotEmpty(message = "{creation.Devis.lignesDevis.notempty}")
	private List<CreationLigneDevisForm> lignesDevis;
	
	private CreationLigneDevisForm ligneDevis = lignesDevis.get(lignesDevis.size()-1);
	

	public Integer getDelaisProd() {
		return delaisProd;
	}

	public void setDelaisProd(Integer delaisProd) {
		this.delaisProd = delaisProd;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdCommercialResponsable() {
		return idCommercialResponsable;
	}

	public void setIdCommercialResponsable(Integer idCommercialResponsable) {
		this.idCommercialResponsable = idCommercialResponsable;
	}

	public List<CreationLigneDevisForm> getLignesDevis() {
		return lignesDevis;
	}

	public void setLignesDevis(List<CreationLigneDevisForm> lignesDevis) {
		this.lignesDevis = lignesDevis;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CreationLigneDevisForm getLigneDevis() {
		return ligneDevis;
	}

	public void setLigneDevis(CreationLigneDevisForm ligneDevis) {
		this.ligneDevis = ligneDevis;
	}
	
	
	
}
