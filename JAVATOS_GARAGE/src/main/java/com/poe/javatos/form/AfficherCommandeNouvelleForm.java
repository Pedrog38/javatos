package com.poe.javatos.form;

import java.util.List;

import javax.validation.Valid;

import com.poe.javatos.global.StatutCommande;

public class AfficherCommandeNouvelleForm 
{
	private Integer idCommande;
	private String commandeDate;
	private String nomClient;
	private Integer idDevis;
	private float prixTotal;
	private StatutCommande statutCommande;
	private Integer delaiCommande;
	
	@Valid
	private List<AfficherLigneCommandeNouvelleForm> listLigneCdForm;
	private Integer index;
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
	public Integer getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(Integer idDevis) {
		this.idDevis = idDevis;
	}
	public float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
	
	public StatutCommande getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}
	public Integer getDelaiCommande() {
		return delaiCommande;
	}
	public void setDelaiCommande(Integer delaiCommande) {
		this.delaiCommande = delaiCommande;
	}
	public List<AfficherLigneCommandeNouvelleForm> getListLigneCdForm() {
		return listLigneCdForm;
	}
	public void setListLigneCdForm(List<AfficherLigneCommandeNouvelleForm> listLigneCdForm) {
		this.listLigneCdForm = listLigneCdForm;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
	
}
