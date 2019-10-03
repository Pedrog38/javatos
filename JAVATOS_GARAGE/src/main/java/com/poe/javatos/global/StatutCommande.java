package com.poe.javatos.global;

public enum StatutCommande 

{
	//Commande
	Nouvelle,EnTraitement,Prete,Livree;

	
	public StatutCommande statusSuivant() 
	{
		int  o = ordinal();
		switch (o) {
		case 0:return StatutCommande.Nouvelle;
		case 1:return StatutCommande.EnTraitement;
		case 2:return StatutCommande.Prete;
		default :
			throw new IllegalAccessError();
		
		}
	}
	
}
