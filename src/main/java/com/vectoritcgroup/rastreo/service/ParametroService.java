package com.vectoritcgroup.rastreo.service;

import java.util.List;

import com.vectoritcgroup.rastreo.model.Parametro;

public interface ParametroService {
	
	public Parametro saveParametro(Parametro parametro);
	
	public List<Parametro> listAll();
	
	public Parametro findByIdParametro(long id);
	
	public void bajaParametro(long id, String status);

}
