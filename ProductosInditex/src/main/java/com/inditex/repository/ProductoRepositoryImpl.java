package com.inditex.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inditex.entities.Precio;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Repositorio de producto.
 * 
 * @author Fidel.
 *
 */
@Slf4j
@Repository
public class ProductoRepositoryImpl implements ProductoRepository{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Precio findPrecioFinal(long idProducto, long idCadena, LocalDateTime fecha) {
		
		log.info("getFinalPrice [idProducto: " + idProducto + ", idCadena: " + idCadena + ", fecha: " + fecha + "]");
		
		Optional<Precio> precio = entityManager.createQuery("select p from Precio p where p.precioId.product_id.id = ?1 and p.precioId.brand_id.id = ?2 "
					+ "and p.precioId.start_date < ?3 and p.precioId.end_date > ?3 order by p.precioId.priority desc")
					.setParameter(1, idProducto)
					.setParameter(2, idCadena)
					.setParameter(3, Timestamp.valueOf(fecha))
					.getResultStream()
					.findFirst();
		
		// Si hay resultado se devuelve, y si no, se devuelve null
		if(precio.isPresent()){
			return precio.get();
		}else {
			return null;
		}
				
	}
	
}
