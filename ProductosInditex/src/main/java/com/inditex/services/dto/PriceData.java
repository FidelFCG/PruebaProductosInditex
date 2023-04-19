package com.inditex.services.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 
 * Informacion sobre el precio de un producto.
 * 
 * @author Fidel.
 *
 */
@Data
public class PriceData {
	
	/**
	 * Identificador de cadena.
	 */
	private long brand_id;
	
	/**
	 * Fecha de inicio de aplicacion del precio tarifa.
	 */
	private LocalDateTime start_date;
	
	/**
	 * Fecha de fin de aplicacion del precio tarifa.
	 */
	private LocalDateTime end_date;	
	
	/**
	 * Identificador de codigo de producto.
	 */
	private long product_id;
	
	/**
	 * Desambiguador de aplicacion de precios.
	 */
	private long priority;
	
	/**
	 * Identificador de la tarifa de precios aplicable.
	 */
	private long price_list;
	
	/**
	 * Precio final de venta.
	 */
	private double price;
	
	/**
	 * ISO de la moneda.
	 */
	@Size(max = 3)
	private String curr;
				
}
