package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Usuario implements Serializable{
	

	private static final long serialVersionUID = 1152367634523090669L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long idUsuario;
	private String nombre;
	@Temporal(value = TemporalType.DATE)
	private Date fecha;
	private String curp;
	private String rfc;
	private String numeroLic;
	private String tipoLic;
	@Temporal(value = TemporalType.DATE)
	private Date vigencia;
	private String correo;
	private byte[] foto;
	private String estatus;
	private String password;
	private String perfil;
	
	//@Transient
	//private String fotoString;
	
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNumeroLic() {
		return numeroLic;
	}
	public void setNumeroLic(String numeroLic) {
		this.numeroLic = numeroLic;
	}
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getTipoLic() {
		return tipoLic;
	}
	public void setTipoLic(String tipoLic) {
		this.tipoLic = tipoLic;
	}

}
