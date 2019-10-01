package com.poe.javatos.form;

import java.util.List;

public class ListeAfficherCommandeECForm {
	
	private List<AfficherCommandeECForm> listeCommandeECForm;
	private Integer indexVisualiser;
	private Integer indexLivrerClient;
	
	public List<AfficherCommandeECForm> getListeCommandeECForm() {
		return listeCommandeECForm;
	}
	public void setListeCommandeECForm(List<AfficherCommandeECForm> listeCommandeECForm) {
		this.listeCommandeECForm = listeCommandeECForm;
	}
	public Integer getIndexVisualiser() {
		return indexVisualiser;
	}
	public void setIndexVisualiser(Integer indexVisualiser) {
		this.indexVisualiser = indexVisualiser;
	}
	public Integer getIndexLivrerClient() {
		return indexLivrerClient;
	}
	public void setIndexLivrerClient(Integer indexLivrerClient) {
		this.indexLivrerClient = indexLivrerClient;
	}
	

}
