package com.vectoritcgroup.rastreo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilerias {
	
	/**
	 * Se convierte String a date
	 * @param dateInString
	 * @return
	 */
	public Date formartDDMMYY(String fecha) {
		Date date = null;
		String[] f = fecha.split("/");
		String dateInString = f[1]+"/"+f[0]+"/"+f[2];
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
        try {

            date = formatter.parse(dateInString);           
            System.out.println("fecha String: " +formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return date;
	}
	
	/**
	 * Se convierte un date a string
	 * @param fecha
	 * @return
	 */
	public String formatStringDDMMYYYY(Date fecha) {
		String convertido;		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		convertido = formatter.format(fecha);
		System.out.println("fecha Date: " +convertido);
		return convertido;
	}
	
	/**
	 * funcion para convertir un string en long
	 * @param dto
	 * @return
	 */
	public long formatLong(String dto) {
		long l = Long.parseLong(dto);
		return l;
	}
}
