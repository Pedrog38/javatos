package com.poe.javatos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_stock")
public class Stock 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "qte_dispo")
	private Integer qteDispo;
	
	@Column(name = "qte_reservee")
	private Integer qteReservee;
	
	@Column(name = "qte_commandee")
	private Integer qteCommandee;
	
	@ManyToOne
	@JoinColumn(name = "t_model_id")
	private Model model;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQteDispo() {
		return qteDispo;
	}

	public void setQteDispo(Integer qteDispo) {
		this.qteDispo = qteDispo;
	}

	public Integer getQteReservee() {
		return qteReservee;
	}

	public void setQteReservee(Integer qteReservee) {
		this.qteReservee = qteReservee;
	}

	public Integer getQteCommandee() {
		return qteCommandee;
	}

	public void setQteCommandee(Integer qteCommandee) {
		this.qteCommandee = qteCommandee;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", qteDispo=" + qteDispo + ", qteReservee=" + qteReservee + ", qteCommandee="
				+ qteCommandee + ", model=" + model + "]";
	}
	
	
}
