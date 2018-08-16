package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -336367746365046546L;

	@Id
	private String idTipo;
	private String descripcion;
	
	
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
