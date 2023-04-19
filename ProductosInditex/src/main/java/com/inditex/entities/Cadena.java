package com.inditex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Cadena del grupo Inditex
 * 
 * @author Fidel
 *
 */
@Entity
@Data
public class Cadena {

	/**
	 * Identificador de la cadena.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	/**
	 * Nombre de la cadena.
	 */
	@Column(name="NOMBRE")
	private String nombre;
	
}
