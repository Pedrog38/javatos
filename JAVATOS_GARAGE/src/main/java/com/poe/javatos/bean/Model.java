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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((delaisProd == null) ? 0 : delaisProd.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prixVente == null) ? 0 : prixVente.hashCode());
		result = prime * result + ((puissance == null) ? 0 : puissance.hashCode());
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
		Model other = (Model) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (delaisProd == null) {
			if (other.delaisProd != null)
				return false;
		} else if (!delaisProd.equals(other.delaisProd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prixVente == null) {
			if (other.prixVente != null)
				return false;
		} else if (!prixVente.equals(other.prixVente))
			return false;
		if (puissance == null) {
			if (other.puissance != null)
				return false;
		} else if (!puissance.equals(other.puissance))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
