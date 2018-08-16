package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 7529130526435615155L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String idGrupo;
	private String descripcion;
	
	
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

    
	
	
}
