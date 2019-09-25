package com.poe.javatos.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class CreationLigneDevisForm 
{
		
	@NotEmpty(message = "{creation.LigneDevis.quantite.notempty}")
	@Min(value=0, message = "{creation.LigneDevis.quantite.positive}")
	private Integer quantite;

	@NotEmpty(message = "{creation.LigneDevis.idModel.notempty}")
	private Integer idModel;
}
