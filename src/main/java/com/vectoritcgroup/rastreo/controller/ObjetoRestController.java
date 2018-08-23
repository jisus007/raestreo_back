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
import com.vectoritcgroup.rastreo.model.Objeto;
import com.vectoritcgroup.rastreo.service.ObjetoService;
import com.vectoritcgroup.rastreo.utils.Utilerias;

@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com", maxAge = 3600)
@RestController
public class ObjetoRestController {
	
	@Autowired
    private ObjetoService objetoService;
	
	@Autowired
	Utilerias utilerias;
    	
	@RequestMapping(value = "/objetos/", method = RequestMethod.GET)
    public ResponseEntity<?> listaObjetos(){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
    	List<Objeto> objetos = objetoService.listAll();
    	
    	hmap = utilerias.evaluateResponse(objetos);
    	
    	return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/objeto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getObjeto(@PathVariable long id, Model model){
    	System.out.println("Fetching Objet with id " + id);
    	
    	HashMap<String, Object> hmap = new HashMap<String, Object>();
    	
    	Error error = new Error();
    	
    	Objeto objeto = objetoService.getById(id);
        if (objeto == null) {
            System.out.println("Objet with id " + id + " not found");
            error.setCode(1);
            error.setMessage("No hay informacion");
        }
      
        hmap.put("error", error);
		hmap.put("lista", objeto);
        
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/objeto", method = RequestMethod.POST)
	public ResponseEntity<Error> ceateObjet(@RequestBody Objeto objeto, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating objeto [%s]", objeto.getNombre())); 
		
		Error error = new Error();
		
		Objeto objetoCreado = new Objeto();
		try {
			objetoCreado = objetoService.saveObjeto(objeto);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se inserto el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ubicacion/{id}").buildAndExpand(objetoCreado.getIdObjeto()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
    
	
	@RequestMapping(value = "/objetos/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<?> listaObjetosByNombre(@PathVariable String nombre){
		System.out.println("Fetching Object with nombre " + nombre);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		List<Objeto> objetos = objetoService.getByNombre(nombre);

    	hmap = utilerias.evaluateResponse(objetos);
    	
		return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/objetos/edit/", method = RequestMethod.POST)
	public  ResponseEntity<?> editObj(@RequestBody Objeto objeto, UriComponentsBuilder ucBuilder) {
		System.out.println("Updating object with id " + objeto.getIdObjeto());
		
		Error error = new Error();
		
		try {
			objetoService.updateObjeto(objeto.getIdObjeto(), objeto.getStatus());
		}catch (Exception e) {
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
		return new ResponseEntity<Error>(error, HttpStatus.OK);
	}
	
}
