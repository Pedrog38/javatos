package com.poe.javatos.form;

import java.util.ArrayList;
import java.util.List;

public class ListeGestionStockForm {
	
	private List<GestionStockForm> listForm = new ArrayList<GestionStockForm>();

	public List<GestionStockForm> getListForm() {
		return listForm;
	}

	public void setListForm(List<GestionStockForm> listForm) {
		this.listForm = listForm;
	}

	@Override
	public String toString() {
		return "ListeGestionStockForm [listForm=" + listForm + "]";
	}
	
	
	
}
