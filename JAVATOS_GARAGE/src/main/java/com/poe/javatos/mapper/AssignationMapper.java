package com.poe.javatos.mapper;

import com.poe.javatos.bean.LigneCommande;
import com.poe.javatos.bean.Stock;
import com.poe.javatos.form.AssignationStockForm;

public class AssignationMapper {
	
	public static AssignationStockForm ligneToAssignation(LigneCommande lc, Stock s) {
	AssignationStockForm ass = new AssignationStockForm();
	ass.setIdLigneCommande(lc.getId());
	ass.setNomClient(lc.getCommande().getClient().getPrenom()+" "+lc.getCommande().getClient().getNom());
	ass.setNomModel(lc.getModel().getNom());
	ass.setQuantiteLigneCommande(lc.getQuantite());
	ass.setNbReserveLigneCommande(lc.getNbResvervees());
			
	ass.setIdStock(s.getId());
	ass.setQteDispoStock(s.getQteDispo());
	ass.setQteAReserve(0);
	
	return ass;

}
}
