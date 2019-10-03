package com.poe.javatos.form;

import java.util.List;

import com.poe.javatos.global.StatutCommande;

public class CommandeForm {
	private Integer idCommande;
	private String commandeDate;
	private String nomClient;
	private Float prixTotalHT;
	private Float prixTotalTTC;
	private Float taux;
	private StatutCommande statutCommande;
	private Integer delaiCommande;
	private List<LigneCommandeForm> listLigneCdForm;
	
	public Integer getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}
	public String getCommandeDate() {
		return commandeDate;
	}
	public void setCommandeDate(String commandeDate) {
		this.commandeDate = commandeDate;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
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

	
	public StatutCommande getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}
	public List<LigneCommandeForm> getListLigneCdForm() {
		return listLigneCdForm;
	}
	public void setListLigneCdForm(List<LigneCommandeForm> listLigneCdForm) {
		this.listLigneCdForm = listLigneCdForm;
	}
	public Integer getDelaiCommande() {
		return delaiCommande;
	}
	public void setDelaiCommande(Integer delaiCommande) {
		this.delaiCommande = delaiCommande;
	}
		
	
}
