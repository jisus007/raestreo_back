package com.vectoritcgroup.rastreo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vectoritcgroup.rastreo.model.Ubicacion;
import com.vectoritcgroup.rastreo.repository.UbicacionRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UbicacionImpl implements UbicacionService {


    @PersistenceContext
    private EntityManager em;
	
	@Autowired
	private UbicacionRepository ubicacionRepository;

	@Override
	public List<Ubicacion> getTravel(long idobjeto) {
		List<Ubicacion> travel = new ArrayList<>();
//		Objeto objeto = new Objeto();
//		objeto.setIdObjeto(idobjeto);
		ubicacionRepository.findByIdObjeto(idobjeto).forEach(travel::add);
		return travel;
	}
	
	@Override
	public List<Ubicacion> getTravelByDate(Ubicacion ubicacion) {
		List<Ubicacion> recorrido = new ArrayList<>();
		ubicacionRepository.findAll().forEach(recorrido::add);
		return recorrido;
	}

	@Override
	public Ubicacion saveUbicacion(Ubicacion ubicacion) {
		return ubicacionRepository.save(ubicacion);
	}
    
	
	@Override
	public List<Ubicacion> getTravels(long idobjeto,Date fechaInicio, Date fechaFin) {
		List<Ubicacion> travels = new ArrayList<>();
		
		ubicacionRepository.findByDates(idobjeto, fechaInicio, fechaFin).forEach(travels::add);
		
		return travels;
		
	}
	
	@Override
	public List<Ubicacion> getTravelsToday(long idobjeto) {

		System.out.println("----searching for today------");
		
		List<Ubicacion> travels = new ArrayList<>();
		
		ubicacionRepository.findByToday(idobjeto).forEach(travels::add);
		
		return travels;

	}
	
	@Override
	public List<Ubicacion> getLastTravel(long idobjeto) {

		System.out.println("----last ubication------");
		
		List<Ubicacion> travels = new ArrayList<>();
		
		ubicacionRepository.findByLastTravel(idobjeto).forEach(travels::add);
		
		return travels;

	}
}
