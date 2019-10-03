package com.poe.javatos.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.poe.javatos.global.StatutCommande;

@MappedSuperclass
public class ProcessVente 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	private Date dateCreation;
	
	//private String statut;
	@Column(name = "statut")
	@Enumerated(EnumType.STRING)
	private StatutCommande statut;
	
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

	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
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
