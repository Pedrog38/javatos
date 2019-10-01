package com.poe.javatos.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class ListeGestionStockMapper {
	
	@Valid
	private List<GestionStockMapper> listForm = new ArrayList<GestionStockMapper>();

	private Integer index;
	
	public List<GestionStockMapper> getListForm() {
		return listForm;
	}

	public void setListForm(List<GestionStockMapper> listForm) {
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
