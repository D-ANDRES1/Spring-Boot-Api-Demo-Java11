package com.ejemplo.demo.dto;

import java.time.Instant;



public record SaludoResponse(
        String mensaje,
        Instant timestamp
) {
}