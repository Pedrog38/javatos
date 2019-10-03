package com.poe.javatos.form;

import java.util.List;

public class ListeCommandeForm {
	private List<CommandeForm> listeCommandeForm;
	private Integer index;
	private List<CommandeForm> listCommandeFormPretes;
	private Integer indexLivrerPrete;
	private Integer indexVisualisePrete;
	private List<CommandeForm> listCommandeFormEnTraitement;
	private Integer indexVisualiseEnTraitement;
	
	public List<CommandeForm> getListeCommandeForm() {
		return listeCommandeForm;
	}
	public void setListeCommandeForm(List<CommandeForm> listeCommandeForm) {
		this.listeCommandeForm = listeCommandeForm;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public List<CommandeForm> getListCommandeFormPretes() {
		return listCommandeFormPretes;
	}
	public void setListCommandeFormPretes(List<CommandeForm> listCommandeFormPretes) {
		this.listCommandeFormPretes = listCommandeFormPretes;
	}
	public List<CommandeForm> getListCommandeFormEnTraitement() {
		return listCommandeFormEnTraitement;
	}
	public void setListCommandeFormEnTraitement(List<CommandeForm> listCommandeFormEnTraitement) {
		this.listCommandeFormEnTraitement = listCommandeFormEnTraitement;
	}
	
	public Integer getIndexLivrerPrete() {
		return indexLivrerPrete;
	}
	public void setIndexLivrerPrete(Integer indexLivrerPrete) {
		this.indexLivrerPrete = indexLivrerPrete;
	}
	public Integer getIndexVisualisePrete() {
		return indexVisualisePrete;
	}
	public void setIndexVisualisePrete(Integer indexVisualisePrete) {
		this.indexVisualisePrete = indexVisualisePrete;
	}
	public Integer getIndexVisualiseEnTraitement() {
		return indexVisualiseEnTraitement;
	}
	public void setIndexVisualiseEnTraitement(Integer indexVisualiseEnTraitement) {
		this.indexVisualiseEnTraitement = indexVisualiseEnTraitement;
	}
	

}
