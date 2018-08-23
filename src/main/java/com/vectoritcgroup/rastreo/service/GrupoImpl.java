package com.vectoritcgroup.rastreo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectoritcgroup.rastreo.model.Grupo;
import com.vectoritcgroup.rastreo.repository.GrupoRepository;

@Service
public class GrupoImpl implements GrupoService{
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Override
	public Grupo saveGrupo(Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	@Override
	public List<Grupo> listAll() {
		List<Grupo> grupos = new ArrayList<>();
		grupoRepository.findAll().forEach(grupos::add);
		if (grupos.isEmpty()) {
			Grupo grupo = new Grupo();
			grupos.add(grupo);

		}
		return grupos;
	}
	
	
	@Override
	public Grupo findByIdGrupo(String id) {
		System.out.println("buscando");
		System.out.println(id);
		return grupoRepository.findByIdGrupo(id);
	}
	
	@Override
	public void deleteGrupo(Grupo grupo) {
		 grupoRepository.deleteGrupo(grupo.getIdGrupo());
	}
}
