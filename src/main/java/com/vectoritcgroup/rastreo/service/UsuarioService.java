package com.vectoritcgroup.rastreo.service;

import java.util.List;

import com.vectoritcgroup.rastreo.model.Usuario;

public interface UsuarioService {
	
	Usuario saveUsuario(Usuario user);

	Usuario findByIdUsuario(long id);
	
	List<Usuario> listAll();
	
	void bajaUsuario(long id, String status);
}
