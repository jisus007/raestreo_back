package com.vectoritcgroup.rastreo.utils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vectoritcgroup.rastreo.model.Error;

@Component
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
	
	/**
	 * Metodo para vealuar respuesta
	 * @param entity
	 * @return
	 */
	public HashMap<String, Object> evaluateResponse(List<?> entity){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		Error error = new Error();
	
		if(entity.isEmpty()) {
			 error.setCode(1);
			 error.setMessage("No existen Registros");
		}
		
		hmap.put("error", error);
		hmap.put("lista", entity);
		
		return hmap;
	}
	
	
	public byte[] imageCode(String cadena) {
		
		byte[] image = null;
		
		try {
			image = Base64.getEncoder().encode(cadena.getBytes());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return image;
	}
	
	public String decodeImge(byte[] image) {
	String imageDecode = new String();
		try {
			byte[] decodedString = Base64.getDecoder().decode(new String(image).getBytes("UTF-8"));
			imageDecode.valueOf(decodedString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imageDecode;
	}
	
	
}
