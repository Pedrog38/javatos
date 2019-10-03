package com.poe.javatos.form;

import java.util.List;

import com.poe.javatos.global.StatutDevis;


public class DevisForm {
	private Integer idDevis;
	private String nomClient;
	private String dateDeCreation;
	private StatutDevis statut;
	private Float prixTotalHT;
	private Float prixTotalTTC;
	private Float taux;
	private Integer delai;
	private List<LigneDevisForm> listLigneDevisForm;
	
	public List<LigneDevisForm> getListLigneDevisForm() {
		return listLigneDevisForm;
	}
	public void setListLigneDevisForm(List<LigneDevisForm> listLigneDevisForm) {
		this.listLigneDevisForm = listLigneDevisForm;
	}
	public Integer getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(Integer idDevis) {
		this.idDevis = idDevis;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	public StatutDevis getStatut() {
		return statut;
	}
	public void setStatut(StatutDevis statut) {
		this.statut = statut;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	public Float getPrixTotalHT() {
		return prixTotalHT;
	}
	public void setPrixTotalHT(Float prixTotalHT) {
		this.prixTotalHT = prixTotalHT;
	}
	public Float getPrixTotalTTC() {
		return prixTotalTTC;
	}
	public void setPrixTotalTTC(Float prixTotalTTC) {
		this.prixTotalTTC = prixTotalTTC;
	}
	public Float getTaux() {
		return taux;
	}
	public void setTaux(Float taux) {
		this.taux = taux;
	}
	

}
