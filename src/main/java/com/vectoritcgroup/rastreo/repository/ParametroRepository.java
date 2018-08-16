package com.vectoritcgroup.rastreo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vectoritcgroup.rastreo.model.Parametro;

public interface ParametroRepository extends CrudRepository<Parametro, Long>{

	@Query("select p from Parametro p where p.idParametro = :id")
	Parametro findByIdParametro(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("update Parametro p set p.status = :status  where p.idParametro = :id")
	void updateStatus(@Param("id") long idParametro, @Param("status") String status);
}
