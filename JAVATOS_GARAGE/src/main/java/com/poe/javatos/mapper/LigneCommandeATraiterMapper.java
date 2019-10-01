package com.poe.javatos.mapper;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

public class LigneCommandeATraiterMapper 
{
	private String statut;
	private Integer idLigneCommande;
	private String nomModel;
	private Integer qteDemande;
	private Integer qteDejaReserve;
	private Integer qteDejaCommandee;
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
	
	
	
	
	
	@AssertTrue(message="Les quantitées sont obligatoires")
	public boolean isQtesNotNull()
	{
		return ((getQteACommander()!=null)&&(getQteAReserver()!=null));
	}
	@AssertTrue(message="La quantitée à reserver doit être positive et inferieure au stock disponible")
	public boolean isQteReserveeOk()
	{
		if(isQtesNotNull())
		{			
			return ((getQteAReserver()>=0)&&(getQteAReserver()<=getQteDispo()));
		}
		return true;
	}
	@AssertTrue(message="La quantitée à commander doit être positive")
	public boolean isQteACommanderOk()
	{
		if(isQtesNotNull()&&isQteReserveeOk())
		{
			return (getQteACommander()>=0);			
		}
		return true;
	}
	@AssertTrue(message="La somme des quantitées à commander et à reserver doit être égale à la quantité demandée")
	public boolean isQtesOk()
	{
		if((isQtesNotNull()&&isQteACommanderOk())&&(isQteReserveeOk()))
		{
			return (
					(getQteACommander()>=0)
				&&(getQteAReserver()>=0)
				&&(getQteAReserver()<=getQteDispo())
				&&(getQteACommander()+getQteAReserver()==getQteDemande())
				);
		}
		return true;
	}
}
