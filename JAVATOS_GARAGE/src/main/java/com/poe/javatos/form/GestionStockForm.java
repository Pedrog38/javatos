package com.poe.javatos.form;

public class GestionStockForm {
	
	private Integer qteDispo;
	
	private Integer qteCommandee;
	
	private Integer idModel;
	
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

	@Override
	public String toString() {
		return "GestionStockForm [qteDispo=" + qteDispo + ", qteCommandee=" + qteCommandee + ", idModel=" + idModel
				+ ", qteRecue=" + qteRecue + ", nomModele=" + nomModele + "]";
	}
	
	

}
