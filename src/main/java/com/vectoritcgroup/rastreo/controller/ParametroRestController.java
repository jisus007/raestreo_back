package com.vectoritcgroup.rastreo.controller;

import java.util.Base64;
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
import com.vectoritcgroup.rastreo.model.Parametro;
import com.vectoritcgroup.rastreo.service.ParametroService;
import com.vectoritcgroup.rastreo.utils.Utilerias;



@CrossOrigin(origins = "https://app-rastreo-web.herokuapp.com", maxAge = 3600)
@RestController
public class ParametroRestController {
	
	@Autowired
	ParametroService parametroService;
	
	@Autowired
	Utilerias utilerias;
	
	@RequestMapping(value = "/parametro/", method = RequestMethod.POST)
	public ResponseEntity<Error> createParametro(@RequestBody Parametro parametro, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Creating tipo [%s]", parametro.getCodigo())); 
		
		Error error = new Error();
	
		Parametro parametroCreado = new Parametro();
		
		System.out.println(parametro.getValor());
		
		byte[] keyPublica = Base64.getEncoder().encode(parametro.getValor().getBytes());
		
		parametro.setValorbd(keyPublica);
		
		
		System.out.println(keyPublica.toString());
		
		try {
			parametroCreado = parametroService.saveParametro(parametro);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se inserto el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/parametro/{id}").buildAndExpand(parametroCreado.getIdParametro()).toUri());
    
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	

    @RequestMapping(value = "/parametro/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getParametro(@PathVariable Long id, Model model){
    	System.out.println("Fetching Tipo with id " + id);
    	
    	HashMap<String, Object> hmap = new HashMap<String, Object>();
    	
    	Error error = new Error();
    	
    	Parametro parametro = parametroService.findByIdParametro(id);
        
    	byte [] decodeValor = Base64.getDecoder().decode(parametro.getValorbd());
    	
    	String key = new String(decodeValor);
    	
    	System.out.println(key);
    	
    	parametro.setValor(key);
    	
    	if (parametro == null) {
            System.out.println("Tipo with id " + id + " not found");
            error.setCode(1);
            error.setMessage("No hay informacion");
        }

        hmap.put("error", error);
		hmap.put("lista", parametro);
        
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/parametros/", method = RequestMethod.GET)
    public ResponseEntity<?> listaParametros(){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
    	List<Parametro> parametro = parametroService.listAll();
    	
    	hmap = utilerias.evaluateResponse(parametro);
    	
    	return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
    }
    
    
	@RequestMapping(value = "/parametro/update/", method = RequestMethod.POST)
	public ResponseEntity<Error> updateParametro(@RequestBody Parametro parametro, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Actualizando tipo [%s]", parametro.getCodigo())); 
		
		Error error = new Error();
	
		Parametro parametroCreado = new Parametro();
		try {
			parametroCreado = parametroService.saveParametro(parametro);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/parametro/{id}").buildAndExpand(parametro.getCodigo()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/parametro/edit/", method = RequestMethod.POST)
	public  ResponseEntity<?> editParametro(@RequestBody Parametro parametro, UriComponentsBuilder ucBuilder) {
		System.out.println("Baja logica with id " + parametro.getIdParametro());
		
		Error error = new Error();
		
		try {
			parametroService.bajaParametro(parametro.getIdParametro(), parametro.getStatus());
		}catch (Exception e) {
			e.printStackTrace();
			error.setCode(1);
			error.setMessage("No se actualizo el registro");
		}
		
		return new ResponseEntity<Error>(error, HttpStatus.OK);
	}
}
