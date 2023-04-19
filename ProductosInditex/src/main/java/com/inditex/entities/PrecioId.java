package com.inditex.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * 
 * Identificador de Precio.
 * 
 * @author Fidel
 *
 */
@Embeddable
@Data
public class PrecioId implements Serializable{
	
	/**
	 * Foreign key de la cadena del grupo.
	 */
	@JoinColumn(name="BRAND_ID")
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cadena brand_id;
	
	/**
	 * Fecha de inicio de aplicacion del precio tarifa.
	 */
	@Column(name="START_DATE")
	private Timestamp start_date;
	
	/**
	 * Fecha de fin de aplicacion del precio tarifa.
	 */
	@Column(name="END_DATE")
	private Timestamp end_date;
		
	/**
	 * Identificador de codigo de producto.
	 */
	@JoinColumn(name="PRODUCT_ID")
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Producto product_id;
	
	/**
	 * Desambiguador de aplicacion de precios.
	 */
	@Column(name="PRIORITY")
	private long priority;
	
	private static final long serialVersionUID = 1L;
			
}
