package com.poe.javatos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_ligne_devis")
public class LigneDevis 
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
	@JoinColumn(name = "t_devis_id")
	private Devis devis;
	
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

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "LigneDevis [id=" + id + ", quantite=" + quantite + ", statut=" + statut + ", nbResvervees="
				+ nbResvervees + ", devis=" + devis.getId() + ", model=" + model + "]";
	}
	
	
}
