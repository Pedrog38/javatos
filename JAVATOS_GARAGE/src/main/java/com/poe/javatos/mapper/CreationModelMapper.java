package com.poe.javatos.mapper;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreationModelMapper 
{
	
	@NotEmpty(message = "{creation.model.nom.notempty}")
	private String nom;
	
	@NotNull(message = "{creation.model.puissance.notempty}")
	@Min(value=0, message = "{creation.model.puissance.positive}")
	private Integer puissance;
	
	@NotNull(message = "{creation.model.prix.notempty}")
	@Min(value=0, message = "{creation.model.prix.positive}")
	private Float prixVente;
	
	@NotEmpty(message = "{creation.model.couleur.notempty}")
	private String couleur;
	
	@NotNull(message = "{creation.model.delais.notempty}")
	@Min(value=0, message = "{creation.model.delais.positive}")
	private Integer delaisProd;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPuissance() {
		return puissance;
	}

	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	public Float getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Float prixVente) {
		this.prixVente = prixVente;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getDelaisProd() {
		return delaisProd;
	}

	public void setDelaisProd(Integer delaisProd) {
		this.delaisProd = delaisProd;
	}
	
	
}
