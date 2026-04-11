package com.ejemplo.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.dto.SaludoRequest;
import com.ejemplo.demo.dto.SaludoResponse;
import com.ejemplo.demo.service.SaludoService;

@RestController
@RequestMapping("/api/v1")
public class PruebaResponseController {

	@GetMapping
	public ResponseEntity<Map<String,String>> respuesta() {
		return ResponseEntity.ok(Map.of(
				"Estado", "Ok",
				"Mensaje", "Workshop Springbook activo"
				));
	}
	
	private final SaludoService saludoService;
	
	public PruebaResponseController(SaludoService saludoService) {
		this.saludoService = saludoService;
	}
	
	@GetMapping("/saludos")
	public ResponseEntity<SaludoResponse> saludar(
			@RequestParam(defaultValue = "Mundo") String nombre){
		return ResponseEntity.ok(saludoService.crearSaludo(nombre));
	}
	
	@PostMapping("/saludos")
	public ResponseEntity<SaludoResponse> saludarPost(
			@Valid @RequestBody SaludoRequest request){
		return ResponseEntity.ok(saludoService.crearSaludo(request.getNombre()));
	}
	
	
	
	
	
//	@GetMapping("/error")
//	public ResponseEntity<String> error() {
//		return ResponseEntity.badRequest().body("no funciono");
//	}
}
