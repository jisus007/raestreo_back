package com.vectoritcgroup.rastreo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vectoritcgroup.rastreo.model.Grupo;


public interface GrupoRepository extends CrudRepository<Grupo, Long>{
	
	@Query("select g from Grupo g where g.idGrupo = :id")
	Grupo findByIdGrupo(@Param("id") String id);
}
