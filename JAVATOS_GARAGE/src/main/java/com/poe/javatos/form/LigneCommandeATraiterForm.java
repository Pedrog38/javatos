package com.poe.javatos.form;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

public class LigneCommandeATraiterForm 
{
	private String statut;
	private Integer idLigneCommande;
	private String nomModel;
	private Integer qteDemande;
	private Integer qteDejaReserve;
	private Integer qteDejaCommandee;
	@Valid
	private Integer qteAReserver;
	private Integer qteACommander;
	private Integer idModel;
	private Integer qteDispo;
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getNomModel() {
		return nomModel;
	}
	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}
	public Integer getQteDemande() {
		return qteDemande;
	}
	public void setQteDemande(Integer qteDemande) {
		this.qteDemande = qteDemande;
	}
	public Integer getQteAReserver() {
		return qteAReserver;
	}
	public void setQteAReserver(Integer qteAReserver) {
		this.qteAReserver = qteAReserver;
	}
	public Integer getQteACommander() {
		return qteACommander;
	}
	public void setQteACommander(Integer qteACommander) {
		this.qteACommander = qteACommander;
	}
	public Integer getIdModel() {
		return idModel;
	}
	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}
	public Integer getQteDispo() {
		return qteDispo;
	}
	public void setQteDispo(Integer qteDispo) {
		this.qteDispo = qteDispo;
	}
	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Integer getQteDejaReserve() {
		return qteDejaReserve;
	}
	public void setQteDejaReserve(Integer qteDejaReserve) {
		this.qteDejaReserve = qteDejaReserve;
	}
	public Integer getQteDejaCommandee() {
		return qteDejaCommandee;
	}
	public void setQteDejaCommandee(Integer qteDejaCommandee) {
		this.qteDejaCommandee = qteDejaCommandee;
	}
	@Override
	public String toString() {
		return "LigneCommandeATraiterForm [statut=" + statut + ", idLigneCommande=" + idLigneCommande + ", nomModel="
				+ nomModel + ", qteDemande=" + qteDemande + ", qteDejaReserve=" + qteDejaReserve + ", qteDejaCommandee="
				+ qteDejaCommandee + ", qteAReserver=" + qteAReserver + ", qteACommander=" + qteACommander
				+ ", idModel=" + idModel + ", qteDispo=" + qteDispo	+ "]";
	}
	
	
	
	
	
	
//	@AssertTrue(message="Qtes incorrectes")
//	public boolean isQtesOk()
//	{
//		return (this.qteACommander>=0)&&(this.qteAReserver>=0)&&(getQteACommander()+getQteAReserver()==getQteDispo());
//	}
	
//	@AssertTrue(message="Qte reserve incorrecte")
//	public boolean isQteReserveTraitementCommandeOk()
//	{
//		return (this.getQteAReserver()>=0)&&(getQteAReserver()<=getQteDispo());
//	}
}
