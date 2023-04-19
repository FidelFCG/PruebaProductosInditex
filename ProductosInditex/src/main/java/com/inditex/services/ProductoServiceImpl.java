package com.inditex.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.entities.Precio;
import com.inditex.repository.ProductoRepository;
import com.inditex.services.dto.PriceData;
import com.inditex.services.mappings.ServiceMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Servicio de producto.
 * 
 * @author Fidel.
 *
 */
@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService{
		
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ServiceMapper serviceMapper;
		
	@Override
	public PriceData getFinalPrice(long idProducto, long idCadena, LocalDateTime fecha) {
		
		log.info("getFinalPrice [idProducto: " + idProducto + ", idCadena: " + idCadena + ", fecha: " + fecha + "]");
		
		// Se obtiene el precio final del producto para la fecha indicada
		Precio precio = productoRepository.findPrecioFinal(idProducto, idCadena, fecha);
		
		// Se construye la respuesta del servicio con la informacion sobre el precio final
		// y se devuelve.
		return serviceMapper.precioToPriceData(precio);
		
	}
	
}
