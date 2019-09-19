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
	
	
	
}
