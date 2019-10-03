package com.poe.javatos.form;

import com.poe.javatos.global.StatutLigneCommande;

public class LigneCommandeForm {
	private String nomModel;
	private Integer quantite;
	private Integer delai;
	private StatutLigneCommande statut;
	private float prixHT;
	
	public String getNomModel() {
		return nomModel;
	}
	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public float getPrixHT() {
		return prixHT;
	}
	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}
	public StatutLigneCommande getStatut() {
		return statut;
	}
	public void setStatut(StatutLigneCommande statut) {
		this.statut = statut;
	}
	
}

