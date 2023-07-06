package com.innoqa.zara.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innoqa.zara.dao.Prices;
import com.innoqa.zara.services.IPricesServices;

/**
 * 
 * @author Miguel Ventocilla Barreda
 *
 */

@RestController
@RequestMapping(value = "/api")
public class PricesController {

	@Autowired
	private IPricesServices iPricesServices;

	/**
	 * End-Point de tipo de Test el cual retorna un objeto Price
	 * 
	 * @param String fechaAplicacion
	 * @param Long idProducto
	 * @param Long idCadena
	 * @return ResponseEntity Prices
	 */
	@GetMapping(value = "/prices")
	public ResponseEntity<Prices> getPrices (
			@RequestParam(value = "fechaAplicacion", required = true) String fechaAplicacion,
			@RequestParam(value = "idProducto", required = true) Long idProducto,
			@RequestParam(value = "idCadena", required = true) Long idCadena) {
		Optional<Prices> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}
		return ResponseEntity.noContent().build();
	}
}
