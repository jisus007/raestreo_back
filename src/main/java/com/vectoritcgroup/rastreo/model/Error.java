package com.vectoritcgroup.rastreo.model;

public class Error {
	
	private Integer code;
	private String message;
	
	public Error() {
		this.code = 0;
		this.message = "Exito";
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 

	
	
}
