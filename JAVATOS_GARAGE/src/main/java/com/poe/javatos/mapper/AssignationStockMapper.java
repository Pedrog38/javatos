package com.poe.javatos.mapper;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.AssignationStockForm;


public class AssignationStockMapper
{
	public static AssignationStockForm remplirAssignationStockForm(LigneCommande lc,Integer delai, Stock s)
	{
		AssignationStockForm assignationStockForm = new AssignationStockForm();
		assignationStockForm.setIdLigneCommande(lc.getId());
		assignationStockForm.setNomClient(lc.getCommande().getClient().getPrenom()+" "+lc.getCommande().getClient().getNom());
		assignationStockForm.setNomModel(lc.getModel().getNom());
		assignationStockForm.setDelaisProd(delai);
		assignationStockForm.setQuantiteLigneCommande(lc.getQuantite());
		assignationStockForm.setNbReserveLigneCommande(lc.getNbResvervees());			
		assignationStockForm.setIdStock(s.getId());
		assignationStockForm.setQteDispoStock(s.getQteDispo());
		assignationStockForm.setQteAReserve(Math.min(s.getQteDispo(), (lc.getQuantite()-lc.getNbResvervees())));
		return assignationStockForm;
	}
	
}
