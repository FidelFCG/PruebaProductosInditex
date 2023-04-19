package com.inditex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 * Producto
 * 
 * @author Fidel
 *
 */
@Entity
@Data
public class Producto {
	
	/**
	 * Identificador de producto.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	/**
	 * Nombre de producto.
	 */
	@Column(name="NOMBRE")
	private String nombre;
			
}
