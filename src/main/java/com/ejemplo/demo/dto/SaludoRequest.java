package com.ejemplo.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class SaludoRequest {
	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 50, message = "El nombre no debe excederse de 50 caracteres")
	private String nombre;
	
	public SaludoRequest() {}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
