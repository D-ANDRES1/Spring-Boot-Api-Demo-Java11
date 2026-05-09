package com.ejemplo.demo.controller;

import com.ejemplo.demo.dto.PrestamoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PrestamoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    
    @Test
    void calcularPrestamo_ok() throws Exception {

        PrestamoRequest request = new PrestamoRequest(
        		 BigDecimal.valueOf(10000)
        		,BigDecimal.valueOf(10000)
        		,24);
        
        mockMvc.perform(post("/api/v1/simulaciones/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cuotaMensual").exists())
                .andExpect(jsonPath("$.totalPagar").exists())
                .andExpect(jsonPath("$.interesTotal").exists());
    }
    
    
    @Test
    void calcularPrestamo_validacion() throws Exception {

        PrestamoRequest request = new PrestamoRequest(
        		 BigDecimal.valueOf(-90000)
        		,BigDecimal.valueOf(17)
        		,100000000);
        
        
        mockMvc.perform(post("/api/v1/simulaciones/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
