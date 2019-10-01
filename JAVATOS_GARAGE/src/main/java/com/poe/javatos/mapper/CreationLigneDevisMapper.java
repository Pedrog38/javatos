package com.poe.javatos.mapper;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.poe.javatos.bean.Model;


public class CreationLigneDevisMapper 
{
		
	private int quantite;

	private int idModel;

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdModel() {
		return idModel;
	}

	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}

	@Override
	public String toString() {
		return "CreationLigneDevisForm [quantite=" + quantite + ", idModel=" + idModel + "]";
	}

		
		
	
}
