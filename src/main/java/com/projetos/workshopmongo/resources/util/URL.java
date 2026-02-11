package com.projetos.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodeParam(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF-8");
			
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String textDate, Date defaultDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);			
		}catch(ParseException e) {
			return defaultDate;
		}
	}

}
