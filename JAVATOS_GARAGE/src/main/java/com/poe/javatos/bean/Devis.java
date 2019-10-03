package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.poe.javatos.global.StatutDevis;

@Entity
@Table(name="t_devis")
public class Devis extends ProcessVente 
{

	
	
	@OneToMany(mappedBy = "devis",fetch = FetchType.LAZY)
	private List<LigneDevis> lignesDevis;

	//private String statut;
	@Column(name = "statut")
	@Enumerated(EnumType.STRING)
	private StatutDevis statut;
		
		
	public List<LigneDevis> getLignesDevis() {
		return lignesDevis;
	}

	public void setLignesDevis(List<LigneDevis> lignesDevis) {
		this.lignesDevis = lignesDevis;
	}

	public StatutDevis getStatut() {
		return statut;
	}

	public void setStatut(StatutDevis statut) {
		this.statut = statut;
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
