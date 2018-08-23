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
public class Parametro implements Serializable {


	private static final long serialVersionUID = 6295600551573528968L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long idParametro;
	private String codigo;
	private String valor;
	private String status;
	@Temporal(value = TemporalType.DATE)
	private Date fecActualizacion;
	
	
	public long getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getFecActualizacion() {
		return fecActualizacion;
	}
	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}
	
	
	
	
	
	
}
