package com.ejemplo.demo.dto;

import java.time.Instant;

public class SaludoResponse {
	private final String mensaje;
	private final Instant timeStamp;
	
	public SaludoResponse( String mensaje, Instant timeStamp) {
		this.mensaje = mensaje;
		this.timeStamp = timeStamp;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public Instant getTimeStamp() {
		return timeStamp;
	}
}
