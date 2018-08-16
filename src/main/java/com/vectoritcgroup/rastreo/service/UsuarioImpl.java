package com.vectoritcgroup.rastreo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectoritcgroup.rastreo.model.Usuario;
import com.vectoritcgroup.rastreo.repository.UsuarioRepository;
import com.vectoritcgroup.rastreo.service.UsuarioService;




@Service
public class UsuarioImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario findByIdUsuario(long id) {
		System.out.println("buscando");
		System.out.println(id);
		return usuarioRepository.findByIdUsuario(id);
	}
	
	@Override
	public List<Usuario> listAll() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuarios::add);
		if (usuarios.isEmpty()) {
			Usuario usuario = new Usuario();
			usuarios.add(usuario);

		}
		return usuarios;
	}
	
	@Override
	public void bajaUsuario(long id, String status) {
		usuarioRepository.updateStatus(id, status);
	}
	

	
}
