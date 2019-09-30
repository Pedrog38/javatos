package com.poe.javatos.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class ListeGestionStockForm {
	
	@Valid
	private List<GestionStockForm> listForm = new ArrayList<GestionStockForm>();

	private Integer index;
	
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

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
	
}
