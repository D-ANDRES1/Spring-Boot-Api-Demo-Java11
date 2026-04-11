package com.ejemplo.demo.dto;

import java.time.Instant;
import java.util.Map;

public class ErrorResponse {
	private final String codigo;
	private final String mensaje;
	private final Instant timeStamp;
	private final Map<String, String> detalles;
	
	public ErrorResponse(String codigo, String mensaje, Instant timeStamp, Map<String,String> detalles) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.timeStamp = timeStamp;
		this.detalles = detalles;
	}
	
	public String getCodigo() { return codigo; }
	
	public String getMensaje() { return mensaje; }
	
	public Instant getTimeStamp() { return timeStamp; }
	
	public Map<String,String> getDetalles() { return detalles; }
}
