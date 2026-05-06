package com.ejemplo.demo.dto;

import java.time.Instant;
import java.util.Map;

public record ErrorResponse(
        String codigo,
        String mensaje,
        Instant timestamp,
        Map<String, String> detalles
) {
}