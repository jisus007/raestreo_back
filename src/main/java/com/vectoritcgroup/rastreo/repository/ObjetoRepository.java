package com.vectoritcgroup.rastreo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vectoritcgroup.rastreo.model.Objeto;


public interface ObjetoRepository extends CrudRepository<Objeto, Long> {
	
	Objeto findByIdObjeto(long idObjeto);
	
	@Query("select o from Objeto o where o.nombre like %:nombre%")
	List<Objeto> findByNombre(@Param("nombre") String nombre);
	
	@Transactional
	@Modifying
	@Query("update Objeto o set o.status = :status  where o.idObjeto = :id")
	void updateStatus(@Param("id") long idObjeto, @Param("status") String status);

}
