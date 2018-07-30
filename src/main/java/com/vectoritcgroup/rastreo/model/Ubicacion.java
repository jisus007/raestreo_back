package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@IdClass(UbicacionPK.class)
@Entity
public class Ubicacion implements Serializable {
	
	private static final long serialVersionUID = 99250510536899653L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idObjeto")
	private Objeto idObjeto;
	@Id
	private Date fecha;
	private String descripcion;	
	private String pais;
	private String latitud;
	private String longitud;
	
	@Transient
	private Date fechaInicio;
	
	@Transient
	private Date fechaFin;

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Objeto getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Objeto idObjeto) {
		this.idObjeto = idObjeto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
}
