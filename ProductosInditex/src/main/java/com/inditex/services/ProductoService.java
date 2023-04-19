package com.inditex.services;

import java.time.LocalDateTime;

import com.inditex.services.dto.PriceData;

/**
 * 
 * Servicio de producto.
 * 
 * @author Fidel.
 *
 */
public interface ProductoService {
	
	/**
	 * 
	 * Obtiene el precio final de un producto en un momento determinado.
	 * 
	 * @param idProducto Identificador del producto.
	 * @param idCadena Identificador de la cadena.
	 * @param fecha Fecha para la que se quiere encontrar el precio final del producto.
	 * @return Informacion sobre el precio final del producto en el momento indicado, o null si no hay.
	 */
	public PriceData getFinalPrice(long idProducto, long idCadena, LocalDateTime fecha);
}
