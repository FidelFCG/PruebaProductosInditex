package com.inditex.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 
 * Datos de la respuesta a la solicitud de precio * 
 * 
 * @author Fidel.
 *
 */
@Schema(name="Respuesta a la solicitud de precio", description="Datos con la respuesta a la solicitud de precio final")
@Data
public class PriceDataResponse implements Serializable{
		
	/**
	 * Identificador de la cadena.
	 */
	@Schema(name="idCadena", example="1", description="Identificador de la cadena.")
	private long idCadena;
	
	/**
	 * Fecha de inicio de aplicacion del precio.
	 */
	@Schema(name="fechaInicioAplicacion", example="2020-06-16T00:00:00", description="Fecha de inicio de aplicacion del precio en formato UTC")
	private LocalDateTime fechaInicioAplicacion;
	
	/**
	 * Fecha de fin de aplicacion del precio.
	 */
	@Schema(name="fechaFinAplicacion", example="2020-06-16T00:00:00", description="Fecha de fin de aplicacion del precio en formato UTC")
	private LocalDateTime fechaFinAplicacion;
	
	/**
	 * Identificador de producto.
	 */
	@Schema(name="idProducto", example="1", description="Identificador de producto")
	private long idProducto;
	
	/**
	 * Identificador de tarifa.
	 */
	@Schema(name="idTarifa", example="1", description="Identificador de tarifa")
	private long idTarifa;
	
	/**
	 * Precio final
	 */
	@Schema(name="precioFinal", example="25.10", description="Precio final")
	private double precioFinal;
	
	/**
	 * ISO de la moneda.
	 */	
	@Schema(name="curr", example="EUR", description="ISO de la moneda")
	@Size(max = 3)
	private String curr;

	private static final long serialVersionUID = 1L;
	
}
