package com.vectoritcgroup.rastreo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectoritcgroup.rastreo.model.Tipo;
import com.vectoritcgroup.rastreo.repository.TipoRepository;

@Service
public class TipoImpl implements TipoService {
	
	@Autowired
	TipoRepository tipoRepository;
	
	@Override
	public Tipo saveTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	@Override
	public List<Tipo> listAll() {
		List<Tipo> tipos = new ArrayList<>();
		tipoRepository.findAll().forEach(tipos::add);
		if (tipos.isEmpty()) {
			Tipo grupo = new Tipo();
			tipos.add(grupo);

		}
		return tipos;
	}
	
	
	@Override
	public Tipo findByIdTipo(String id) {
		System.out.println("buscando");
		System.out.println(id);
		return tipoRepository.findByIdTipo(id);
	}
	
	@Override
	public void deleteTipo(Tipo tipo) {
		tipoRepository.delete(tipo);
	}
	
}
