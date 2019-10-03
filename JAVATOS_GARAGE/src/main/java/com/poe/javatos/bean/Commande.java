package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.poe.javatos.global.StatutCommande;

@Entity
@Table(name = "t_commande")
public class Commande extends ProcessVente{

	StatutCommande statut;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lignesCommandes == null) ? 0 : lignesCommandes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (lignesCommandes == null) {
			if (other.lignesCommandes != null)
				return false;
		} else if (lignesCommandes.size() != other.lignesCommandes.size())
			return false;
		return true;
	}
	
	public StatutCommande getStatut() {
		
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}
}
