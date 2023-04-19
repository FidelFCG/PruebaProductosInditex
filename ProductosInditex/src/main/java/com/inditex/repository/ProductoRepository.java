package com.inditex.repository;

import java.time.LocalDateTime;

import com.inditex.entities.Precio;

/**
 * 
 * Repositorio de producto.
 * 
 * @author Fidel.
 *
 */
public interface ProductoRepository {

	/**
	 * Obtiene el precio final de un producto para la fecha indicada.
	 * 
	 * @param idProducto Identificador del producto.
	 * @param idCadena Identificador de la cadena.
	 * @param fecha Fecha en la que se quiere conocer el precio final.
	 * @return Precio final del producto o null si no se encuentra informacion.
	 */
	public Precio findPrecioFinal(long idProducto, long idCadena, LocalDateTime fecha);
}
