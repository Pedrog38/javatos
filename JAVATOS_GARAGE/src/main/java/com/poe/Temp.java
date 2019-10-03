package com.poe;

import com.poe.javatos.global.StatutCommande;
public class Temp {

	public static void main(String [] args) {
		
		StatutCommande s = StatutCommande.Livree;
		System.out.println(s.name());
		System.out.println(s);
		
		StatutCommande s2 = StatutCommande.valueOf("EnTraitement");
		System.out.println(s2);
		System.out.println(s2.ordinal()); 
	}
}
