package com.vectoritcgroup.rastreo.service;

import java.util.List;

import com.vectoritcgroup.rastreo.model.Tipo;

public interface TipoService {

	public Tipo saveTipo(Tipo tipo);
	
	public List<Tipo> listAll();
	
	public Tipo findByIdTipo(String id);
	
	public void deleteTipo(Tipo tipo);
}
