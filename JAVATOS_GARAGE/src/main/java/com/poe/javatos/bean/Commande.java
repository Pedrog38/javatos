package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_commande")
public class Commande extends ProcessVente{

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
		int result = 1;
		result = prime * result + ((lignesCommandes == null) ? 0 : lignesCommandes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (lignesCommandes == null) {
			if (other.lignesCommandes != null)
				return false;
		} else if (!lignesCommandes.equals(other.lignesCommandes))
			return false;
		return true;
	}
	
	
}
