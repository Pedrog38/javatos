package com.poe.javatos.form;

import java.util.List;

public class ListeDevisForm 
{
	private List<DevisForm> listeDevisForm;
	private Integer index;
	private Integer indexAnnuler ;
	private Integer indexValider;
	

	public List<DevisForm> getListeDevisForm() {
		return listeDevisForm;
	}
	public void setListeDevisForm(List<DevisForm> listeDevisForm) {
		this.listeDevisForm = listeDevisForm;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getIndexAnnuler() {
		return indexAnnuler;
	}
	public void setIndexAnnuler(Integer indexAnnuler) {
		this.indexAnnuler = indexAnnuler;
	}
	public Integer getIndexValider() {
		return indexValider;
	}
	public void setIndexValider(Integer indexValider) {
		this.indexValider = indexValider;
	}
	

}
