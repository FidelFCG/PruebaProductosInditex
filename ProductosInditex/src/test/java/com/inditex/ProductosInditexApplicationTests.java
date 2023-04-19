package com.inditex;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * 
 * Test para probar la obtencion del precio final.
 * 
 * @author Fidel
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductosInditexApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 
	 * Comprueba que se obtiene correctamente un precio para el producto y fecha indicados.
	 * 
	 * @throws Exception Cuando se produce alguna excepcion en la operacion.
	 */
	@Test
	void precioFinalCorrecto() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/producto/35455/precio")
							.param("fecha", "2020-06-16T00:00:00")
							.param("idCadena", "1")
							.contentType(MediaType.APPLICATION_JSON)
							.content("\"precioFinal\": 38.95"))
					.andExpect(status().isOk());
		
	}
	
	/**
	 * 
	 * Comprueba que no se encuentra un precio para el producto y fecha indicados.
	 * 
	 * @throws Exception Cuando se produce alguna excepcion en la operacion.
	 */
	@Test
	void precioFinalNoSeEncuentra() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/producto/35455/precio")
							.param("fecha", "2021-06-16T00:00:00")
							.param("idCadena", "1")
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isNoContent());
		
	}

}
