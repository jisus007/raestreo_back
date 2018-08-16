package com.vectoritcgroup.rastreo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vectoritcgroup.rastreo.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.idUsuario = :id")
	Usuario findByIdUsuario(@Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("update Usuario u set u.estatus = :status  where u.idUsuario = :id")
	void updateStatus(@Param("id") long idObjeto, @Param("status") String status);
}
