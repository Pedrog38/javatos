package com.poe.javatos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_statut")
public class StatutClient 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "taux_tva")
	private Float tauxTva;

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

	public Float getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(Float tauxTva) {
		this.tauxTva = tauxTva;
	}

	@Override
	public String toString() {
		return "StatutClient [id=" + id + ", nom=" + nom + ", tauxTva=" + tauxTva + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((tauxTva == null) ? 0 : tauxTva.hashCode());
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
		StatutClient other = (StatutClient) obj;
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
		if (tauxTva == null) {
			if (other.tauxTva != null)
				return false;
		} else if (!tauxTva.equals(other.tauxTva))
			return false;
		return true;
	}
	
	
}
