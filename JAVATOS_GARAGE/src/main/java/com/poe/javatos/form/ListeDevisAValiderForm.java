package com.poe.javatos.form;

import java.util.List;


public class ListeDevisAValiderForm 
{
	private List<DevisForm> listeDevisForm;
	private Integer indexVisualiser;
	private Integer indexValider;
	private Integer indexAnnuler;
	

	public List<DevisForm> getListeDevisForm() {
		return listeDevisForm;
	}
	public void setListeDevisForm(List<DevisForm> listeDevisForm) {
		this.listeDevisForm = listeDevisForm;
	}
	public Integer getIndexVisualiser() {
		return indexVisualiser;
	}
	public void setIndexVisualiser(Integer indexVisualiser) {
		this.indexVisualiser = indexVisualiser;
	}
	public Integer getIndexValider() {
		return indexValider;
	}
	public void setIndexValider(Integer indexValider) {
		this.indexValider = indexValider;
	}
	public Integer getIndexAnnuler() {
		return indexAnnuler;
	}
	public void setIndexAnnuler(Integer indexAnnuler) {
		this.indexAnnuler = indexAnnuler;
	}

	
	
}
