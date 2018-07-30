package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;
import java.util.Date;

public class UbicacionPK implements Serializable {
	
	private static final long serialVersionUID = 4649638271103596746L;
	private long idObjeto;
	private Date fecha;

	public UbicacionPK() { }

	
	public long getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(long idObjeto) {
		this.idObjeto = idObjeto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UbicacionPK))
			return false;
		UbicacionPK pk = (UbicacionPK) obj;
		return pk.fecha == fecha && pk.idObjeto == idObjeto;
	}
}