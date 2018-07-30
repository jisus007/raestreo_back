package com.vectoritcgroup.rastreo.service;

import java.util.List;

import com.vectoritcgroup.rastreo.model.Objeto;

public interface ObjetoService {

    List<Objeto> listAll();

    Objeto getById(long id);
    
    List<Objeto> getByNombre(String nombre);

    Objeto saveObjeto(Objeto user);

    Objeto updateObjeto(Objeto user);

	void deleteObjetoById(long id);

	boolean isObjetoExist(Objeto user);

	void deleteAllObjetos();

}
