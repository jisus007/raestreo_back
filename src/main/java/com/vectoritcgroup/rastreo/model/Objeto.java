package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Objeto implements Serializable {

	private static final long serialVersionUID = 6305062003458299790L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long idObjeto;
	private String nombre;
	private String descripcion;	
	private String serie;
	private String fecAlta;
	private String fecActualizacion;
	private String status;
	public long getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(long idObjeto) {
		this.idObjeto = idObjeto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}
	public String getFecActualizacion() {
		return fecActualizacion;
	}
	public void setFecActualizacion(String fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
