package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_devis")
public class Devis extends ProcessVente 
{

	@OneToMany(mappedBy = "devis",fetch = FetchType.LAZY)
	private List<LigneDevis> lignesDevis;

	public List<LigneDevis> getLignesDevis() {
		return lignesDevis;
	}

	public void setLignesDevis(List<LigneDevis> lignesDevis) {
		this.lignesDevis = lignesDevis;
	}

	@Override
	public String toString() {
		return super.toString() +" Devis [lignesDevis=" + lignesDevis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lignesDevis == null) ? 0 : lignesDevis.hashCode());
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
		Devis other = (Devis) obj;
		if (lignesDevis == null) {
			if (other.lignesDevis != null)
				return false;
		} else if (!lignesDevis.equals(other.lignesDevis))
			return false;
		return true;
	}
	
	
	
}
