package com.poe;
import java.util.Date;

import com.poe.javatos.global.StatutCommande;

public class Temp {
	
	public static void main(String [] args) {
		
		StatutCommande s = StatutCommande.Livree;
		System.out.println(s.name());
		System.out.println(s);
		
		StatutCommande s2 = StatutCommande.valueOf("EnTraitement");
		System.out.println(s2);
		System.out.println(s2.ordinal());
		
		System.out.println("****************************************************");
	
	Date d1 = new Date(119,0,1);
	DateStringConverter dsc = new DateStringConverter();
	
	String strD = dsc.convertToDatabaseColumn(d1);
	System.out.println(strD);
	
	System.out.println(dsc.convertToEntityAttribute(strD));

			
	}

}
