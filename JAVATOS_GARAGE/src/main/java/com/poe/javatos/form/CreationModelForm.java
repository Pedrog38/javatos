package com.poe.javatos.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class CreationModelForm 
{
	
	@NotEmpty(message = "{creation.model.nom.notempty}")
	private String nom;
	
	@NotEmpty(message = "{creation.model.puissance.notempty}")
	@Min(value=0, message = "{creation.model.puissance.positive}")
	private Integer puissance;
	
	@NotEmpty(message = "{creation.model.prix.notempty}")
	@Min(value=0, message = "{creation.model.prix.positive}")
	private Float prixVente;
	
	@NotEmpty(message = "{creation.model.couleur.notempty}")
	private String couleur;
	
	@NotEmpty(message = "{creation.model.delais.notempty}")
	@Min(value=0, message = "{creation.model.delais.positive}")
	private Integer delaisProd;
}
