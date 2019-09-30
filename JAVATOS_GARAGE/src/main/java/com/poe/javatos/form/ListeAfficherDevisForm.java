package com.poe.javatos.form;

import java.util.List;

public class ListeAfficherDevisForm {
	private List<AfficherDevisForm> listeDevisForm;
	private Integer index;
	private Integer indexAnnuler ;
	private Integer indexValider;
	

	public List<AfficherDevisForm> getListeDevisForm() {
		return listeDevisForm;
	}
	public void setListeDevisForm(List<AfficherDevisForm> listeDevisForm) {
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
