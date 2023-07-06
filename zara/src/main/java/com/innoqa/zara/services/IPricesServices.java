package com.innoqa.zara.services;

import java.util.List;
import java.util.Optional;

import com.innoqa.zara.dao.Prices;
import com.innoqa.zara.exception.BusinessException;

/**
 * 
 * 
 * @author Miguel Ventocilla Barreda
 *
 */

public interface IPricesServices {
	
	/**
	 * Obtener toda la lista de la tabla Prices
	 * @return List Prices
	 */
	List<Prices> getPrices();

	/**
	 * Obtener un valor opcional de la tabla Prices
	 * @param String fechaAplicacion
	 * @param Long idProducto
	 * @param Long idCadena
	 * @return Optional Prices
	 */
	Optional<Prices> getPrice(String fechaAplicacion, Long idProducto, Long idCadena);

}