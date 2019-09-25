package com.poe.javatos.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;

public class AssignationStockForm implements Serializable
{
	private LigneCommande ligneCommande;
	
	private Stock stock;
	
	@Valid
	private Integer qteAReserve; 

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Integer getQteAReserve() {
		return qteAReserve;
	}

	public void setQteAReserve(Integer qteAReserve) {
		this.qteAReserve = qteAReserve;
	}
	

	@AssertTrue(message="test")
	public boolean isQteReserveOk()
	{
		return (this.getQteAReserve()>=0)&&(this.getQteAReserve()<=this.getLigneCommande().getQuantite()-this.getLigneCommande().getNbResvervees());
	}
	
	

	
}
