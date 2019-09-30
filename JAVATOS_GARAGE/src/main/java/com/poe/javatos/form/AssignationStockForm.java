package com.poe.javatos.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;


public class AssignationStockForm implements Serializable
{
	private Integer idLigneCommande;
	
	private String nomClient;
	
	private String nomModel;
	
	private Integer delaisProd;
	
	private Integer quantiteLigneCommande;
	
	private Integer nbReserveLigneCommande;
	
	private Integer idStock;
	
	private Integer qteDispoStock;
	
	@Valid
	private Integer qteAReserve;

	

	

	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}





	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}





	public String getNomClient() {
		return nomClient;
	}





	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}





	public String getNomModel() {
		return nomModel;
	}





	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}





	public Integer getDelaisProd() {
		return delaisProd;
	}





	public void setDelaisProd(Integer delaisProd) {
		this.delaisProd = delaisProd;
	}





	public Integer getQuantiteLigneCommande() {
		return quantiteLigneCommande;
	}





	public void setQuantiteLigneCommande(Integer quantiteLigneCommande) {
		this.quantiteLigneCommande = quantiteLigneCommande;
	}





	public Integer getNbReserveLigneCommande() {
		return nbReserveLigneCommande;
	}





	public void setNbReserveLigneCommande(Integer nbReserveLigneCommande) {
		this.nbReserveLigneCommande = nbReserveLigneCommande;
	}





	public Integer getIdStock() {
		return idStock;
	}





	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}





	public Integer getQteDispoStock() {
		return qteDispoStock;
	}





	public void setQteDispoStock(Integer qteDispoStock) {
		this.qteDispoStock = qteDispoStock;
	}





	public Integer getQteAReserve() {
		return qteAReserve;
	}





	public void setQteAReserve(Integer qteAReserve) {
		this.qteAReserve = qteAReserve;
	}





	@AssertTrue(message="Qte à reserver incorrecte")
	public boolean isQteReserveOk()
	{
		return (this.getQteAReserve()>=0)&&(this.getQteAReserve()<=Math.min(this.getQuantiteLigneCommande()-this.getNbReserveLigneCommande(),this.qteDispoStock));
	}
	
	

	
}
