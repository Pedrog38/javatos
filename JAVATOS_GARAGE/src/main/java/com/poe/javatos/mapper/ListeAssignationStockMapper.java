package com.poe.javatos.mapper;

import java.util.List;

import javax.validation.Valid;

import org.springframework.lang.NonNull;

public class ListeAssignationStockMapper 
{

	@Valid
	private List<AssignationStockMapper> listAss;
	
	private Integer index;

	public List<AssignationStockMapper> getListAss() 
	{
		return listAss;
	}

	public void setListAss(List<AssignationStockMapper> listAss) 
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
