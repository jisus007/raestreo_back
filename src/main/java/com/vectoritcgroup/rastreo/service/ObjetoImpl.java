package com.vectoritcgroup.rastreo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectoritcgroup.rastreo.model.Objeto;
import com.vectoritcgroup.rastreo.repository.ObjetoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjetoImpl implements ObjetoService {

	@Autowired
    private ObjetoRepository objetoRepository;

	@Override
	public List<Objeto> listAll() {
		List<Objeto> objetos = new ArrayList<>();
		objetoRepository.findAll().forEach(objetos::add);
		if (objetos.isEmpty()) {
			Objeto objeto = new Objeto();
			objetos.add(objeto);

		}
		return objetos;
	}

	@Override
	public Objeto getById(long id) {
		return objetoRepository.findByIdObjeto(id);
	}
	
	@Override
	public List<Objeto> getByNombre(String nombre) {
		return objetoRepository.findByNombre(nombre);
	}

	@Override
	public Objeto saveObjeto(Objeto objeto) {
		return objetoRepository.save(objeto);
	}

	@Override
	public Objeto updateObjeto(Objeto objeto) {
		return objetoRepository.save(objeto);
	}

	@Override
	public void deleteObjetoById(long id) {
		objetoRepository.deleteById(id);
	
	}

	@Override
	public boolean isObjetoExist(Objeto objeto) {
		return getById(objeto.getIdObjeto())!=null;
	}
	
	@Override
	public void deleteAllObjetos(){
		objetoRepository.deleteAll();
	}

    
}
