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
import com.vectoritcgroup.rastreo.model.Tipo;
import com.vectoritcgroup.rastreo.service.TipoService;
import com.vectoritcgroup.rastreo.utils.Utilerias;
@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com/", maxAge = 3600)
@RestController
public class TipoRestController {
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	Utilerias utilerias;
	
	@RequestMapping(value = "/tipo/", method = RequestMethod.POST)
	public ResponseEntity<Error> createTipo(@RequestBody Tipo tipo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating tipo [%s]", tipo.getDescripcion())); 
		
		Error error = new Error();
	
		Tipo tipoCreado = new Tipo();
		try {
			tipoCreado = tipoService.saveTipo(tipo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se inserto el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/tipo/{id}").buildAndExpand(tipo.getIdTipo()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
    @RequestMapping(value = "/tipo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getTipo(@PathVariable String id, Model model){
    	System.out.println("Fetching Tipo with id " + id);
    	
    	HashMap<String, Object> hmap = new HashMap<String, Object>();
    	
    	Error error = new Error();
    	
    	Tipo tipo = tipoService.findByIdTipo(id);
        if (tipo == null) {
            System.out.println("Tipo with id " + id + " not found");
            error.setCode(1);
            error.setMessage("No hay informacion");
        }

        hmap.put("error", error);
		hmap.put("lista", tipo);
        
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/tipos/", method = RequestMethod.GET)
    public ResponseEntity<?> listaGrupos(){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
    	List<Tipo> tipo = tipoService.listAll();
    	
    	hmap = utilerias.evaluateResponse(tipo);
    	
    	return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
	@RequestMapping(value = "/tipo/update/", method = RequestMethod.POST)
	public ResponseEntity<Error> updateGrupo(@RequestBody Tipo tipo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Actualizando tipo [%s]", tipo.getDescripcion())); 
		
		Error error = new Error();
	
		Tipo tipoCreado = new Tipo();
		try {
			tipoCreado = tipoService.saveTipo(tipo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/tipo/{id}").buildAndExpand(tipo.getIdTipo()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/tipo/delete/", method = RequestMethod.POST)
	public ResponseEntity<Error> deleteGrupo(@RequestBody Tipo tipo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Borrando tipo [%s]", tipo.getDescripcion())); 
		
		Error error = new Error();
		
		try {
			tipoService.deleteTipo(tipo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se borro el registro");
		}
		
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/grupo/{id}").buildAndExpand(grupo.getIdGrupo()).toUri());
        return new ResponseEntity<Error>(error,HttpStatus.OK);
	}
    
}
