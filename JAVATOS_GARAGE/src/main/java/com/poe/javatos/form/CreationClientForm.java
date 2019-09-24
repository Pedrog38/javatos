package com.poe.javatos.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.poe.javatos.bean.StatutClient;

public class CreationClientForm 
{
	@NotEmpty(message = "{creation.client.nom.notempty}")
	private String nom;

	@NotEmpty(message = "{creation.client.prenom.notempty}")
	private String prenom;
	@Pattern(regexp = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$", 
			message = "{creation.client.mail.notvalide}")
	private String mail;

	@NotEmpty(message = "{creation.client.adresse.notempty}")
	private String adresse;

	@Pattern(regexp ="^(\\d\\d){4}(\\d\\d)$",
			message = "{creation.client.telephone.notvalide}")
	private String telephone;

	@Pattern(regexp ="^(HOMME)|(FEMME)$",
			message = "{creation.client.sexe.notvalide}")
	private String sexe;

	private StatutClient statutClient;

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

	public StatutClient getStatutClient() {
		return statutClient;
	}

	public void setStatutClient(StatutClient statutClient) {
		this.statutClient = statutClient;
	}

	
}
