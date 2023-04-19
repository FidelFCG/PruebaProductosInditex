package com.inditex.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.controller.dto.PriceDataResponse;
import com.inditex.controller.mappings.ResponseMapper;
import com.inditex.services.ProductoService;
import com.inditex.services.dto.PriceData;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * API REST de Producto.
 * 
 * @author Fidel.
 *
 */
@Slf4j
@Tag(name = "API de Productos", description = "API para ofrecer funcionalidad sobre productos")
@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	ResponseMapper responseMapper;
			
	/**
	 * 
	 * Obtiene el precio final de un producto en la fecha indicada.
	 * 
	 * @param id Identificador del producto.
	 * @param fecha Fecha para la que se quiere obtener el precio final.
	 * @param idCadena Identificador de la cadena de Inditex.
	 * @return Informacion sobre el precio final.
	 */
	@Operation(description = "Obtiene el precio final de un producto en la fecha indicada", summary = "Devuelve un 204 si no encuentra datos")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Exito de la operacion"),
			@ApiResponse(responseCode = "204", description = "No hay datos sobre el precio final para el producto en la fecha indicada"),
			@ApiResponse(responseCode = "500", description = "Error interno")})
	@GetMapping("/{id}/precio")	
	public ResponseEntity<PriceDataResponse> getPrice(@PathVariable long id, @RequestParam LocalDateTime fecha, @RequestParam long idCadena) {
		
		log.info("getPrice [id: " + id + ", fecha: " + fecha + ", idCadena: " + idCadena + "]");
		
		// Se obtiene el precio final del produco para la fecha indicada	
		PriceData priceData = productoService.getFinalPrice(id, idCadena, fecha);
		
		
		// Se construye la respuesta al cliente, con el precio final si hay datos		
		if(priceData != null) {
			
			PriceDataResponse priceDataResponse = responseMapper.priceDataToPriceDataResponse(priceData);
			
			return ResponseEntity.ok(priceDataResponse);
			
		}else {
			
			return new ResponseEntity<PriceDataResponse>(HttpStatus.NO_CONTENT);
			
		}
		
		
	}
		
	
}
