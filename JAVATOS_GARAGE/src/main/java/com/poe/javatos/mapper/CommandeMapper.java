package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.form.CommandeForm;
import com.poe.javatos.form.LigneCommandeForm;

public class CommandeMapper 
{
	public static CommandeForm remplirCommandeForm(Commande commande, float prixHT, float prixTTC, Integer delai)
	{
		CommandeForm commandeForm = new CommandeForm();
		commandeForm.setCommandeDate(commande.getDateCreation().toString());
		commandeForm.setIdCommande(commande.getId());
		commandeForm.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
		commandeForm.setPrixTotalHT(prixHT);
		commandeForm.setPrixTotalTTC(prixTTC);
		commandeForm.setTaux(commande.getClient().getStatut().getTauxTva());
		commandeForm.setStatutCommande(commande.getStatut());
		commandeForm.setDelaiCommande(delai);
		
		return commandeForm;
	}
	
	public static CommandeForm remplirCommandeForm(Commande commande, float prixHT, float prixTTC, Integer delai, List<LigneCommandeForm> lignesCommandeForm)
	{
		CommandeForm commandeForm = remplirCommandeForm(commande, prixHT, prixTTC, delai);
		commandeForm.setListLigneCdForm(lignesCommandeForm);
		return commandeForm;
	}
}
