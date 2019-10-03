package com.poe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;

public class DateStringConverter implements AttributeConverter<Date, String> {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public String convertToDatabaseColumn(Date uneDate) {
		
		return sdf.format(uneDate);
		//"2019-02-02 15:02:00; 
	}

	
	//De la base 
	@Override
	public Date convertToEntityAttribute(String dbData) {
	
		try {
		return sdf.parse(dbData);
	}
		catch (ParseException pe) {
			return new Date();
		}


}
}
