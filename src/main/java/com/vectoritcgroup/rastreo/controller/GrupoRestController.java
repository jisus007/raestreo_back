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
import com.vectoritcgroup.rastreo.model.Grupo;
import com.vectoritcgroup.rastreo.service.GrupoService;
import com.vectoritcgroup.rastreo.utils.Utilerias;


@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com", maxAge = 3600)
@RestController
public class GrupoRestController {
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	Utilerias utilerias;
	
	
	@RequestMapping(value = "/grupo", method = RequestMethod.POST)
	public ResponseEntity<Error> createGrupo(@RequestBody Grupo grupo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating grupo [%s]", grupo.getDescripcion())); 
		System.out.println(String.format("Creating grupo [%s]", grupo.getIdGrupo())); 
		
		Error error = new Error();
	
		Grupo grupoCreado = new Grupo();
		try {
			grupoCreado = grupoService.saveGrupo(grupo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se inserto el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/grupo/{id}").buildAndExpand(grupo.getIdGrupo()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
    @RequestMapping(value = "/grupo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getGrupo(@PathVariable String id, Model model){
    	System.out.println("Fetching Usuario with id " + id);
    	
    	HashMap<String, Object> hmap = new HashMap<String, Object>();
    	
    	Error error = new Error();
    	
    	Grupo grupo = grupoService.findByIdGrupo(id);
        if (grupo == null) {
            System.out.println("Usuario with id " + id + " not found");
            error.setCode(1);
            error.setMessage("No hay informacion");
        }

        hmap.put("error", error);
		hmap.put("lista", grupo);
        
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
	
    
    
    @RequestMapping(value = "/grupos/", method = RequestMethod.GET)
    public ResponseEntity<?> listaGrupos(){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
    	List<Grupo> grupo = grupoService.listAll();
    	
    	hmap = utilerias.evaluateResponse(grupo);
    	
    	return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
	@RequestMapping(value = "/grupo/update/", method = RequestMethod.POST)
	public ResponseEntity<Error> updateGrupo(@RequestBody Grupo grupo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Actualizando usuario [%s]", grupo.getDescripcion())); 
		
		Error error = new Error();
	
		Grupo grupoCreado = new Grupo();
		try {
			grupoCreado = grupoService.saveGrupo(grupo);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/grupo/{id}").buildAndExpand(grupo.getIdGrupo()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/grupo/delete/", method = RequestMethod.POST)
	public ResponseEntity<Error> deleteGrupo(@RequestBody Grupo grupo, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Borrando grupo [%s]", grupo.getDescripcion())); 
		
		Error error = new Error();
		try {
			grupoService.deleteGrupo(grupo);
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
