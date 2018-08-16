package com.vectoritcgroup.rastreo.service;

import java.util.List;

import com.vectoritcgroup.rastreo.model.Grupo;


public interface GrupoService {
	
	public Grupo saveGrupo(Grupo grupo);
	
	List<Grupo> listAll();
	
	public Grupo findByIdGrupo(String id);
	
	
	public void deleteGrupo(Grupo grupo);
}
