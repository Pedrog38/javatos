package com.poe.javatos.mapper;

import java.util.List;

import com.poe.javatos.bean.Commande;
import com.poe.javatos.form.CommandeATraiterForm;
import com.poe.javatos.form.LigneCommandeATraiterForm;

public class CommandeATraiterMapper 
{
	public static CommandeATraiterForm remplirCommandeATraiterForm(Commande commande, Integer delai, float prixHT, float prixTTC, List<LigneCommandeATraiterForm> listLCATFs, List<LigneCommandeATraiterForm> listLCNonModifiableFs)
	{
		CommandeATraiterForm commandeATraiterForm = new CommandeATraiterForm();
		
		
		commandeATraiterForm.setListLigneCdForm(listLCATFs);
		commandeATraiterForm.setListLigneCdFormNonModifiable(listLCNonModifiableFs);
		commandeATraiterForm.setCommandeDate(commande.getDateCreation().toString());
		commandeATraiterForm.setIdDevis(commande.getId());
		commandeATraiterForm.setIdCommande(commande.getId());
		commandeATraiterForm.setDelaiCommande(delai);
		commandeATraiterForm.setNomClient(commande.getClient().getPrenom()+" "+commande.getClient().getNom());
		commandeATraiterForm.setPrixTotalHT(prixHT);
		commandeATraiterForm.setPrixTotalTTC(prixTTC);
		commandeATraiterForm.setTaux(commande.getClient().getStatut().getTauxTva());
		commandeATraiterForm.setStatutCommande(commande.getStatut());
		
		return commandeATraiterForm;
	}
}
