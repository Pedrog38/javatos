package com.poe.javatos.form;

import java.util.List;

import javax.validation.Valid;

public class ListeAssignationStockForm 
{

	@Valid
	private List<AssignationStockForm> listAss;

	public List<AssignationStockForm> getListAss() 
	{
		return listAss;
	}

	public void setListAss(List<AssignationStockForm> listAss) 
	{
		this.listAss = listAss;
	}
	
	
	
	
}
