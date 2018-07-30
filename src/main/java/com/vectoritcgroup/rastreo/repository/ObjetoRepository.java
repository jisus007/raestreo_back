package com.vectoritcgroup.rastreo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vectoritcgroup.rastreo.model.Objeto;


public interface ObjetoRepository extends CrudRepository<Objeto, Long> {
	
	Objeto findByIdObjeto(long idObjeto);
	
	@Query("select o from Objeto o where o.nombre like %:nombre%")
	List<Objeto> findByNombre(@Param("nombre") String nombre);

}
