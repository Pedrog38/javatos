package com.poe.javatos.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;

public class AssignationStockForm 
{
	private LigneCommande ligneCommande;
	
	private Stock stock;
	
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
	
	@AssertTrue
	private boolean isModelSame()
	{
		return ligneCommande.getModel().getId()==stock.getModel().getId();
	}
	
	@AssertTrue
	private boolean isQteReserveOk()
	{
		return (qteAReserve>=0)&&(qteAReserve<=ligneCommande.getQuantite()-ligneCommande.getNbResvervees());
	}
	
	

	
}
