package com.inditex.services.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.entities.Precio;
import com.inditex.services.dto.PriceData;


/**
 * 
 * Mapeo para los dto de servicio
 * 
 * @author Fidel
 *
 */
@Mapper(componentModel = "spring")
public interface ServiceMapper {

	@Mapping(source = "precioId.brand_id.id", target = "brand_id")
	@Mapping(source = "precioId.start_date", target = "start_date")
	@Mapping(source = "precioId.end_date", target = "end_date")
	@Mapping(source = "precioId.product_id.id", target = "product_id")
	@Mapping(source = "precioId.priority.", target = "priority")
	@Mapping(source = "price_list.id", target = "price_list")
	public PriceData precioToPriceData(Precio precio);
}
