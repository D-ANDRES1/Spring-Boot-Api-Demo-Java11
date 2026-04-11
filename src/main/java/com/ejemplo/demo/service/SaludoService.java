package com.ejemplo.demo.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.dto.SaludoResponse;

@Service
public class SaludoService {
	
	public SaludoResponse crearSaludo(String nombre) {
		String nombreNormalizado = normalizarNombre(nombre);
		String mensaje = String.format("Hola %s. Bienvenido a Springboot 2!", nombreNormalizado);
		return new SaludoResponse(mensaje, Instant.now());
	}
	
	
	
	String normalizarNombre(String nombre) {

	    if (nombre == null || nombre.isBlank()) {
	        return "Mundo";
	    }

	    nombre = nombre.trim();

	    char primeraLetra = Character.toUpperCase(nombre.charAt(0));
	    String resto = nombre.substring(1).toLowerCase();

	    return "Estudiante " + primeraLetra + resto;
	}
}
