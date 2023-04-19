package com.inditex.controller.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.controller.dto.PriceDataResponse;
import com.inditex.services.dto.PriceData;

/**
 * 
 * Mapeo para las respuestas.
 * 
 * @author Fidel.
 *
 */
@Mapper(componentModel = "spring")
public interface ResponseMapper {

	@Mapping(source = "brand_id", target = "idCadena")
	@Mapping(source = "start_date", target = "fechaInicioAplicacion")
	@Mapping(source = "end_date", target = "fechaFinAplicacion")
	@Mapping(source = "product_id", target = "idProducto")
	@Mapping(source = "price_list", target = "idTarifa")
	@Mapping(source = "price", target = "precioFinal")
	public PriceDataResponse priceDataToPriceDataResponse(PriceData priceData);
}
