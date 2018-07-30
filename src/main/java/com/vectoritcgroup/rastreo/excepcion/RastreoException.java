package com.vectoritcgroup.rastreo.excepcion;

public class RastreoException extends Exception {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -6881591089769096933L;

	/** Propiedad del tipo que almacena el codigo de error */
	private String codError;

	/** Propiedad del tipo que almacena el mensaje de error */
	private String msgError;

	/** Propiedad del tipo mensaje de error */
	private String tipoError;

	/**
	 * Metodo get que sirve para obtener el valor de la propiedad codError
	 * 
	 * @return codError Objeto del tipo String
	 */
	public String getCodError() {
		return codError;
	}

	/**
	 * Modifica el valor de la propiedad codError
	 * 
	 * @param codError
	 *            Objeto del tipo String
	 */
	public void setCodError(String codError) {
		this.codError = codError;
	}

	/**
	 * Metodo get que sirve para obtener el valor de la propiedad msgError
	 * 
	 * @return msgError Objeto del tipo String
	 */
	public String getMsgError() {
		return msgError;
	}

	/**
	 * Modifica el valor de la propiedad msgError
	 * 
	 * @param msgError
	 *            Objeto del tipo String
	 */
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	/**
	 * Metodo get que sirve para obtener la propiedad tipoError
	 * 
	 * @return tipoError Objeto del tipo String
	 */
	public String getTipoError() {
		return tipoError;
	}

	/**
	 * Metodo set que modifica la referencia de la propiedad tipoError
	 * 
	 * @param tipoError
	 *            del tipo String
	 */
	public void setTipoError(String tipoError) {
		this.tipoError = tipoError;
	}

}
