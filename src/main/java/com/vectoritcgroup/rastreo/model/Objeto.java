package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Objeto implements Serializable {

	private static final long serialVersionUID = 6305062003458299790L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long idObjeto;
	private String nombre;
	private String descripcion;	
	private String serie;
	@Temporal(value = TemporalType.DATE)
	private Date fecAlta;
	@Temporal(value = TemporalType.DATE)
	private Date fecActualizacion;
	private String status;
	private String placas;
	private String tipo;
	private String grupo;
	private byte[] foto;
	
	
	
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

	public Date getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(Date fecAlta) {
		this.fecAlta = fecAlta;
	}
	public Date getFecActualizacion() {
		return fecActualizacion;
	}
	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
