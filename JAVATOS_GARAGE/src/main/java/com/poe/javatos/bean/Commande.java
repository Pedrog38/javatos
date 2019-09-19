package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_commande")
public class Commande extends ProcessVente
{
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> lignesCommandes;

	public List<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}

	@Override
	public String toString() {
		
		return  super.toString()+" Commande [lignesCommandes=" + lignesCommandes + "]";
	}
	
	
}
