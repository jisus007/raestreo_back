package com.vectoritcgroup.rastreo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vectoritcgroup.rastreo.model.Error;
import com.vectoritcgroup.rastreo.model.Usuario;
import com.vectoritcgroup.rastreo.service.UsuarioService;
import com.vectoritcgroup.rastreo.utils.Utilerias;

@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com", maxAge = 3600)
@RestController
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	Utilerias utilerias;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Error> createUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating usuario [%s]", usuario.getNombre())); 
		
		Error error = new Error();
	
		Usuario usuarioCreado = new Usuario();
		try {
			usuarioCreado = usuarioService.saveUsuario(usuario);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se inserto el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getUsuario(@PathVariable long id, Model model){
    	System.out.println("Fetching Usuario with id " + id);
    	
    	HashMap<String, Object> hmap = new HashMap<String, Object>();
    	
    	Error error = new Error();
    	
    	Usuario usuario = usuarioService.findByIdUsuario(id);
        if (usuario == null) {
            System.out.println("Usuario with id " + id + " not found");
            error.setCode(1);
            error.setMessage("No hay informacion");
        }

        hmap.put("error", error);
		hmap.put("lista", usuario);
        
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
    public ResponseEntity<?> listaUsuarios(){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
    	List<Usuario> usuario = usuarioService.listAll();
    	
    	hmap = utilerias.evaluateResponse(usuario);
    	
    	return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
	@RequestMapping(value = "/usuario/edit/", method = RequestMethod.POST)
	public  ResponseEntity<?> editObj(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
		System.out.println("Baja logica with id " + usuario.getIdUsuario());
		
		Error error = new Error();
		
		try {
			usuarioService.bajaUsuario(usuario.getIdUsuario(), usuario.getEstatus());
		}catch (Exception e) {
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
		return new ResponseEntity<Error>(error, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/usuario/update/", method = RequestMethod.POST)
	public ResponseEntity<Error> updateUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Actualizando usuario [%s]", usuario.getNombre())); 
		
		Error error = new Error();
	
		Usuario usuarioCreado = new Usuario();
		try {
			usuarioCreado = usuarioService.saveUsuario(usuario);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
}
