package com.inditex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 
 * Precio final y tarifa que aplica a un producto de una
 * cadena entre unas fechas determinadas.
 * 
 * @author Fidel
 *
 */
@Entity
@Data
public class Precio {
	
	/**
	 * Identificador de precio.
	 */
	@EmbeddedId
	private PrecioId precioId;	
	
	/**
	 * Identificador de la tarifa de precios aplicable.
	 */
	@ManyToOne
	@JoinColumn(name="PRICE_LIST")
	private Tarifa price_list;
		
	/**
	 * Precio final de venta.
	 */
	@Column(name="PRICE")
	private double price;
	
	/**
	 * ISO de la moneda.
	 */
	@Column(name="CURR")
	@Size(max = 3)
	private String curr;
	
}
