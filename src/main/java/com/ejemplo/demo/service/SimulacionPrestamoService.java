package com.ejemplo.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.dto.PrestamoRequest;
import com.ejemplo.demo.dto.PrestamoResponse;

@Service
public class SimulacionPrestamoService {

	
	
	
	public PrestamoResponse Calcular (PrestamoRequest request) {
		
		BigDecimal monto = request.monto();
		    BigDecimal tasaAnual = request.tasaAnual();
		    Integer meses = request.meses();

		    if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
		        throw new IllegalArgumentException("El monto debe ir mayor a 0");
		    }


		    if (tasaAnual == null || tasaAnual.compareTo(BigDecimal.ZERO) <= 0) {
		        throw new IllegalArgumentException("La tasa debe ir mayor a 0");
		    }

		    if (tasaAnual.compareTo(new BigDecimal("100")) > 0) {
		        throw new IllegalArgumentException("La tasa no puede ser mayor a 100 ");
		    }


		    if (meses == null || meses <= 0) {
		        throw new IllegalArgumentException("Los meses deben ser mayor a 0");
		    }

		    
		    if (meses > 360) {
		        throw new IllegalArgumentException("No se permiten mas de 360 meses");
		    }


		    BigDecimal P = monto;
		    
		    

		    BigDecimal i = tasaAnual
		            .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
		            .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

		    BigDecimal unoMasI = BigDecimal.ONE.add(i);

		    BigDecimal potencia = BigDecimal.ONE;
		    for (int k = 0; k < meses; k++) {
		        potencia = potencia.multiply(unoMasI);
		    }

		    
		    
		    
		    BigDecimal numerador = i.multiply(potencia);
		    
		    BigDecimal denominador = potencia.subtract(BigDecimal.ONE);

		    
		    BigDecimal cuota = P.multiply(numerador)
		            .divide(denominador, 2, RoundingMode.HALF_UP);

		    BigDecimal pagarTotal = cuota.multiply(BigDecimal.valueOf(meses))
		            .setScale(2, RoundingMode.HALF_UP);

		    BigDecimal interes = pagarTotal.subtract(P)
		            .setScale(2, RoundingMode.HALF_UP);

		    
		    
		    
		    return new PrestamoResponse(cuota,pagarTotal,interes);
	}
}
