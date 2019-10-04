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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((qteCommandee == null) ? 0 : qteCommandee.hashCode());
		result = prime * result + ((qteDispo == null) ? 0 : qteDispo.hashCode());
		result = prime * result + ((qteReservee == null) ? 0 : qteReservee.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (qteCommandee == null) {
			if (other.qteCommandee != null)
				return false;
		} else if (!qteCommandee.equals(other.qteCommandee))
			return false;
		if (qteDispo == null) {
			if (other.qteDispo != null)
				return false;
		} else if (!qteDispo.equals(other.qteDispo))
			return false;
		if (qteReservee == null) {
			if (other.qteReservee != null)
				return false;
		} else if (!qteReservee.equals(other.qteReservee))
			return false;
		return true;
	}
	
	
}
