package com.vectoritcgroup.rastreo.model;

import java.io.Serializable;

public class Token implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5488781318427765819L;
	
	private String token;
	
	private Long time;
	
	public Token() {
		this.time = 0L;
		this.token = "";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
}
