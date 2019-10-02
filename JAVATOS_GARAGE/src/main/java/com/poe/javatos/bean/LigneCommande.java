package com.poe.javatos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_ligne_commande")
public class LigneCommande 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "quantite")
	private Integer quantite;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "nb_reservee")
	private Integer nbResvervees;

	@ManyToOne
	@JoinColumn(name = "t_commande_id")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "t_model_id")
	private Model model;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getNbResvervees() {
		return nbResvervees;
	}

	public void setNbResvervees(Integer nbResvervees) {
		this.nbResvervees = nbResvervees;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", statut=" + statut + ", nbResvervees="
				+ nbResvervees + ", commande=" + commande.getId() + ", model=" + model + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nbResvervees == null) ? 0 : nbResvervees.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
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
		LigneCommande other = (LigneCommande) obj;

		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;

		if (nbResvervees == null) {
			if (other.nbResvervees != null)
				return false;
		} else if (!nbResvervees.equals(other.nbResvervees))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		return true;
	}
	
	
}
