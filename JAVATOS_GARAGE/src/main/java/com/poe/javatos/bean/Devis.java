package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.poe.javatos.global.StatutDevis;

@Entity
@Table(name="t_devis")
public class Devis extends ProcessVente 
{

	StatutDevis statut;
	
	
	@OneToMany(mappedBy = "devis",fetch = FetchType.LAZY)
	private List<LigneDevis> lignesDevis;

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

	
	
	
}
