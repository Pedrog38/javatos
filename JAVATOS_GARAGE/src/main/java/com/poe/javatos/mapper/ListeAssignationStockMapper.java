package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.form.AssignationStockForm;
import com.poe.javatos.form.ListeAssignationStockForm;

public class ListeAssignationStockMapper 
{
	public static ListeAssignationStockForm remplirListeAssignationForm(List<AssignationStockForm>listAssignationForm)
	{
		ListeAssignationStockForm listeAssignationStockForm = new ListeAssignationStockForm();
		listeAssignationStockForm.setListAss(listAssignationForm);
		listeAssignationStockForm.setIndex(0);
		return listeAssignationStockForm;
	}
	
}
