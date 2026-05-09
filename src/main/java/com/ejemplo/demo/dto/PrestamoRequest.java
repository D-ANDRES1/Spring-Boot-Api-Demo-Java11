package com.ejemplo.demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PrestamoRequest(
		@NotNull
		@Positive
		BigDecimal monto,
		
		@NotNull
		@Positive
		BigDecimal tasaAnual,
		
		
		@Min(1)
		@Max(360)
		int meses
		
		) {

}
