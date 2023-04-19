package com.inditex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 * Tarifa de precios
 * 
 * @author Fidel
 *
 */
@Entity
@Data
public class Tarifa {
	
	/**
	 * Identificador de la tarifa.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	/**
	 * Nombre de la tarifa.
	 */
	@Column(name="NOMBRE")
	private String nombre;
	
}
