package com.poe.javatos.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_client")
public class Client {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_de_creation")
	private Date dateCreation;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "sexe")
	private String sexe;
	
	@ManyToOne
	@JoinColumn(name = "t_statut_id")
	private StatutClient statut;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public StatutClient getStatut() {
		return statut;
	}

	public void setStatut(StatutClient statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adresse=" + adresse
				+ ", dateCreation=" + dateCreation + ", telephone=" + telephone + ", sexe=" + sexe + ", statut="
				+ statut + "]";
	}
	
	

}
