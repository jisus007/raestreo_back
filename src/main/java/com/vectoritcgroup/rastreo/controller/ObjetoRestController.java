package com.vectoritcgroup.rastreo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vectoritcgroup.rastreo.model.Objeto;
import com.vectoritcgroup.rastreo.service.ObjetoService;


@RestController
public class ObjetoRestController {
	
	@Autowired
    private ObjetoService objetoService;
    
	@RequestMapping(value = "/objetos/", method = RequestMethod.GET)
    public ResponseEntity<List<Objeto>> listaObjetos(){
    	List<Objeto> objetos = objetoService.listAll();
    	if (null == objetos || objetos.isEmpty()) {
    		return new ResponseEntity<List<Objeto>>(HttpStatus.NO_CONTENT);
		}
    	return new ResponseEntity<List<Objeto>>(objetos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/objeto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Objeto> getObjeto(@PathVariable long id, Model model){
    	System.out.println("Fetching Objet with id " + id);
    	Objeto objeto = objetoService.getById(id);
        if (objeto == null) {
            System.out.println("Objet with id " + id + " not found");
            return new ResponseEntity<Objeto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Objeto>(objeto, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/objeto", method = RequestMethod.POST)
	public ResponseEntity<Void> ceateObjet(@RequestBody Objeto objeto, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating objeto [%s]", objeto.getNombre())); 
		Objeto objetoCreado = objetoService.saveObjeto(objeto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ubicacion/{id}").buildAndExpand(objetoCreado.getIdObjeto()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
    
	
	@RequestMapping(value = "/objetos/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<Objeto>> listaObjetosByNombre(@PathVariable String nombre){
		System.out.println("Fetching Object with nombre " + nombre);
		List<Objeto> objetos = objetoService.getByNombre(nombre);
		if (objetos == null || objetos.isEmpty()) {
			System.out.println("Objet with nombre " + nombre + " not found");
			return new ResponseEntity<List<Objeto>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Objeto>>(objetos, HttpStatus.OK);
	}
}
