package com.poe.javatos.form;

import java.util.List;

public class AfficherDevisForm {
	private Integer idDevis;
	private String nomClient;
	private String dateDeCreation;
	private String statut;
	private Float prixTotal;
	private Integer delai;
	private List<AfficherLigneDevisForm> listLigneDevisForm;
	
	public List<AfficherLigneDevisForm> getListLigneDevisForm() {
		return listLigneDevisForm;
	}
	public void setListLigneDevisForm(List<AfficherLigneDevisForm> listLigneDevisForm) {
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
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	

}
