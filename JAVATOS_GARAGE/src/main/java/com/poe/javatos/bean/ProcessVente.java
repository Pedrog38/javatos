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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcessVente other = (ProcessVente) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
