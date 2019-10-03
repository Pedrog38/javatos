package com.poe;

import java.util.Date;

import com.poe.javatos.global.DateStringConverter;

public class Temp {

	public static void main(String[] args) {


		Date d1 = new Date(119,0,1);
		
		DateStringConverter dsc = new DateStringConverter();
	
		String strD = dsc.convertToDatabaseColumn(d1);
		
		System.out.println(strD);
		System.out.println(dsc.convertToEntityAttribute(strD));
	}

}
