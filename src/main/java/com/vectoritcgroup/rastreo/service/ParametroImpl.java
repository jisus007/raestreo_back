package com.vectoritcgroup.rastreo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectoritcgroup.rastreo.model.Parametro;
import com.vectoritcgroup.rastreo.repository.ParametroRepository;

@Service
public class ParametroImpl implements ParametroService{

	@Autowired
	ParametroRepository parametroRepository;
	
	@Override
	public Parametro saveParametro(Parametro parametro) {
		return parametroRepository.save(parametro);
	}
	
	@Override
	public List<Parametro> listAll() {
		List<Parametro> parametros = new ArrayList<>();
		parametroRepository.findAll().forEach(parametros::add);
		if (parametros.isEmpty()) {
			Parametro parametro = new Parametro();
			parametros.add(parametro);

		}
		return parametros;
	}
	
	
	@Override
	public Parametro findByIdParametro(long id) {
		System.out.println(id);
		return parametroRepository.findByIdParametro(id);
	}
	
	@Override
	public void bajaParametro(long id, String status) {
		parametroRepository.updateStatus(id, status);
	}
	

}