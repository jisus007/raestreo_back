package com.vectoritcgroup.rastreo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vectoritcgroup.rastreo.service.UbicacionService;
import com.vectoritcgroup.rastreo.utils.Utilerias;
import com.vectoritcgroup.rastreo.model.Ubicacion;
import com.vectoritcgroup.rastreo.model.Error;

@RestController
public class UbicacionRestController {

	@Autowired
	private UbicacionService ubicacionService;
	
	@Autowired
	Utilerias utilerias;


	@RequestMapping(value = "/ubicaciones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getObjeto(@PathVariable String id) {
		System.out.println("Fetching Ubicacion with idObjeto " + id);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		List<Ubicacion> ubicaciones = ubicacionService.getTravel(Long.valueOf(id));
		
		hmap = utilerias.evaluateResponse(ubicaciones);
		
        return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ubicacion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<Error> createUbicacion(@RequestBody Ubicacion ubicacion, UriComponentsBuilder ucBuilder) {
        System.out.println(String.format("Creating ubicacion [%s]", ubicacion.getIdObjeto().getIdObjeto()+ ", Lat: "+ubicacion.getLatitud()+", Lon: "+ubicacion.getLongitud())); 
        ubicacionService.saveUbicacion(ubicacion);
       
        Error error = new Error();
        
        HttpHeaders headers = new HttpHeaders();
        try {
        	ubicacionService.saveUbicacion(ubicacion);
        }catch (Exception e) {
			// TODO: handle exception
        	error.setCode(1);
        	error.setMessage("No se guardo el registro");
		}
        
        headers.setLocation(ucBuilder.path("/ubicacion/{id}").buildAndExpand(ubicacion.getIdObjeto()).toUri());
        return new ResponseEntity<Error>(error,headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = "/ubicacionPorFecha", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<?> getObjetos(@RequestBody Ubicacion ubicacion){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		System.out.println("Consultando ubicaciones por fechas " + ubicacion.getFechaInicio() + " -" +ubicacion.getFechaFin());
		List<Ubicacion> ubicaciones = ubicacionService.getTravels(ubicacion.getIdObjeto().getIdObjeto(), ubicacion.getFechaInicio(), ubicacion.getFechaFin());
		
		hmap = utilerias.evaluateResponse(ubicaciones);
		
		return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ubicacionDiaActual/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> getObjetosToday(@PathVariable Long id){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
				
		System.out.println("Buscando ubicacion with idObjeto " + id );
		
		List<Ubicacion> ubicaciones = ubicacionService.getTravelsToday(id);
		
		hmap = utilerias.evaluateResponse(ubicaciones);
		
		return new ResponseEntity<HashMap<String, Object>>(hmap,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/ultimaUbicacion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> getLastTravel(@PathVariable Long id){
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();

		System.out.println("Searching last ubication with idObjeto " + id );
		
		List<Ubicacion> ubicaciones = ubicacionService.getLastTravel(id);
	
		hmap = utilerias.evaluateResponse(ubicaciones);
		
		return new ResponseEntity<HashMap<String, Object>>(hmap,HttpStatus.OK);
	}
	


}
