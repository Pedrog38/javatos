package com.poe.javatos.form;

import java.util.List;

import javax.validation.Valid;

import org.springframework.lang.NonNull;

public class ListeAssignationStockForm 
{

	@Valid
	private List<AssignationStockForm> listAss;
	
	private Integer index;

	public List<AssignationStockForm> getListAss() 
	{
		return listAss;
	}

	public void setListAss(List<AssignationStockForm> listAss) 
	{
		this.listAss = listAss;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
	
	
}
