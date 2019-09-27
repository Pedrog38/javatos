package com.poe.javatos.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_model")
public class Model 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "puissance")
	private Integer puissance;
	
	@Column(name = "prix_vente_ht")
	private Float prixVente;
	
	@Column(name = "couleur")
	private String couleur;
	
	@Column(name = "delais_production")
	private Integer delaisProd;

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

	@Override
	public String toString() {
		return "Model [id=" + id + ", nom=" + nom + ", puissance=" + puissance + ", prixVente=" + prixVente
				+ ", couleur=" + couleur + ", delaisProd=" + delaisProd + "]";
	}
	
	
	
	
	
	
	
}
