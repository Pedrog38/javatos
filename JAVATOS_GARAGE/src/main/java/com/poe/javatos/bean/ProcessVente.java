package com.poe.javatos.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class ProcessVente 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "statut")
	private String statut;
	
	@ManyToOne
	@JoinColumn(name = "t_client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "t_utilisateur_id")
	private Utilisateur commercialResponsable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Utilisateur getCommercialResponsable() {
		return commercialResponsable;
	}

	public void setCommercialResponsable(Utilisateur commercialResponsable) {
		this.commercialResponsable = commercialResponsable;
	}

	@Override
	public String toString() {
		return "ProcessVente [id=" + id + ", dateCreation=" + dateCreation + ", statut="
				+ statut + ", client=" + client + ", commercialResponsable=" + commercialResponsable + "]";
	}
	
	
	
	
}
