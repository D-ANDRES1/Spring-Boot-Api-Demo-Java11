package com.ejemplo.demo.dto;

import java.math.BigDecimal;

public record PrestamoResponse(
		
		BigDecimal cuotaMensual,
	    BigDecimal totalPagar,
	    BigDecimal interesTotal
		
		) {

}
