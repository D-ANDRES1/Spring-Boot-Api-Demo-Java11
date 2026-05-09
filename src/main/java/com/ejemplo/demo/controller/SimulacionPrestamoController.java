package com.ejemplo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.dto.PrestamoRequest;
import com.ejemplo.demo.dto.PrestamoResponse;
import com.ejemplo.demo.service.SimulacionPrestamoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/simulaciones")
@Tag(name = "Simulacion de Prestamos", description = "API simulada de ejemplo, para calcular un prestamo")
public class SimulacionPrestamoController {
	
	private final SimulacionPrestamoService simulacionPrestamoService;
	
	public SimulacionPrestamoController (SimulacionPrestamoService simulacionPrestamoService) {
		this.simulacionPrestamoService = simulacionPrestamoService;
	}

	@PostMapping("/prestamo")
	@Operation(
            summary = "ejemplo de prestamo",
            description = "Calcula cuota mensual, total a pagar e interes total"
    )
	public ResponseEntity<PrestamoResponse> CalcularPrestamo(@Valid @RequestBody PrestamoRequest request){
		
		return ResponseEntity.ok(simulacionPrestamoService.Calcular(request));
	}
	
	
}
