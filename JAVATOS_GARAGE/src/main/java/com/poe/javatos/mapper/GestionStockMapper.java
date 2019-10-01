package com.poe.javatos.mapper;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

public class GestionStockMapper {
	
	private Integer qteDispo;
	
	private Integer qteCommandee;
	
	private Integer idModel;
	
	@Valid
	private Integer qteRecue;
	
	private String nomModele;

	public Integer getQteDispo() {
		return qteDispo;
	}

	public void setQteDispo(Integer qteDispo) {
		this.qteDispo = qteDispo;
	}

	public Integer getQteCommandee() {
		return qteCommandee;
	}

	public void setQteCommandee(Integer qteCommandee) {
		this.qteCommandee = qteCommandee;
	}

	public Integer getIdModel() {
		return idModel;
	}

	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}

	public Integer getQteRecue() {
		return qteRecue;
	}

	public void setQteRecue(Integer qteRecue) {
		this.qteRecue = qteRecue;
	}

	public String getNomModele() {
		return nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}

	@AssertTrue(message = "Quantié reçue incorrecte")
	public boolean isQteRecueOk() {
		return (this.getQteRecue()>=0)&&(this.getQteRecue()<=this.getQteCommandee());
	}
	
	@Override
	public String toString() {
		return "GestionStockForm [qteDispo=" + qteDispo + ", qteCommandee=" + qteCommandee + ", idModel=" + idModel
				+ ", qteRecue=" + qteRecue + ", nomModele=" + nomModele + "]";
	}
	
	

}
