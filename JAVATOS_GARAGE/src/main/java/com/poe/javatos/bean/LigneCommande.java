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
	
	
	
}
