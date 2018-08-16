package com.vectoritcgroup.rastreo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vectoritcgroup.rastreo.model.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
	
	@Query("select t from Tipo t where t.idTipo = :id")
	Tipo findByIdTipo(@Param("id") String id);

}
