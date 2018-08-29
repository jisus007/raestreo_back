package com.vectoritcgroup.rastreo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.vectoritcgroup.rastreo.model.Ubicacion;
import com.vectoritcgroup.rastreo.model.UbicacionPK;


public interface UbicacionRepository extends CrudRepository<Ubicacion, UbicacionPK> {
	

	
	@Query("select c from Ubicacion c where c.idObjeto.idObjeto = :id")
	List<Ubicacion> findByIdObjeto(@Param("id") long id);
	
	@Query("select c from Ubicacion c where c.idObjeto.idObjeto = :id and fecha between :fechaInicio and :fechaFin")
	List<Ubicacion> findByDates(@Param("id") long id, @Param("fechaInicio") Date fechaInicio,@Param("fechaFin") Date fechaFin);

	@Query( value = " select * from ubicacion u where u.id_objeto = :id  and cast(u.fecha as date) = current_date-1 ", nativeQuery = true)
	List<Ubicacion> findByToday(@Param("id") long id);
	
	@Query( value = " select * from ubicacion u where u.id_objeto = :id order by u.fecha desc LIMIT 1 ", nativeQuery = true)
	List<Ubicacion> findByLastTravel(@Param("id") long id);
	

}