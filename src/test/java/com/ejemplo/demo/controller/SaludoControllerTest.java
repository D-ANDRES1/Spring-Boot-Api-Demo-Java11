package com.ejemplo.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.demo.dto.SaludoResponse;
import com.ejemplo.demo.service.SaludoService;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(PruebaResponseController.class)
public class SaludoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SaludoService saludoService;
	
	@Test
	@DisplayName("Debe responser el Health del Workshop")
	void debeResponderHealthDelWorkshop() throws Exception {
		mockMvc.perform(get("/api/v1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.Estado").value("Ok"));
	}
	
	
	
	
	@Test
	@DisplayName("Debe responder la respuesta")
	void debeResponderLaRespuesta() throws Exception {
		
		when(saludoService.crearSaludo("Ana"))
	    .thenReturn(new SaludoResponse("Estudiante Ana", Instant.now()));
		
		mockMvc.perform(get("/api/v1/saludos")
				.param("nombre", "Ana"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.mensaje").value("Estudiante Ana"));
	}
	
	@Test
	@DisplayName("Debe verificar si actua VALIDATION_ERROR")
	void debeVerificarSiActuaVALIDATION_ERROR() throws Exception {
		mockMvc.perform(post("/api/v1/saludos")
				.contentType(APPLICATION_JSON).content("{\"nombre\": \"\"}"))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.codigo").value("VALIDATION_ERROR"));
	}
	
	
}
