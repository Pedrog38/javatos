package com.poe.javatos.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.poe.javatos.bean.Model;


public class CreationLigneDevisForm 
{
		
	@NotEmpty(message = "{creation.LigneDevis.quantite.notempty}")
	@Min(value=0, message = "{creation.LigneDevis.quantite.positive}")
	private Integer quantite;

	@NotEmpty(message = "{creation.LigneDevis.idModel.notempty}")
	private Integer idModel;
	
	private Model model;

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Integer getIdModel() {
		return idModel;
	}

	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
