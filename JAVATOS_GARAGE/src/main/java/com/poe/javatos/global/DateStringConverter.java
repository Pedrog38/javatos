package com.poe.javatos.global;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;

public class DateStringConverter implements AttributeConverter<Date, String> {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public String convertToDatabaseColumn(Date uneDate) {
		
		return sdf.format(uneDate);
	}

	@Override
	public Date convertToEntityAttribute(String dbData) {
		try {
			return sdf.parse(dbData);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	

}
