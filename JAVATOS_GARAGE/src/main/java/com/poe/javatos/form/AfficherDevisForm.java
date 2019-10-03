package com.poe.javatos.form;

import java.util.List;

import com.poe.javatos.global.StatutCommande;

public class AfficherDevisForm {
	private Integer idDevis;
	private String nomClient;
	private String dateDeCreation;
	private StatutCommande statut;
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
	
	public StatutCommande getStatut() {
		return statut;
	}
	public void setStatut(StatutCommande statut) {
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
