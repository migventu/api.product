package com.innoqa.zara.services.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoqa.zara.dao.Prices;
import com.innoqa.zara.repository.IPricesRepository;
import com.innoqa.zara.services.IPricesServices;
import com.innoqa.zara.util.Fechas;

/**
 * 
 * @author Miguel Ventocilla Barreda
 * @implNote Clase que tiene la lógica del negocio
 *
 */

@Service("iPricesServices")
public class PricesImpl implements IPricesServices {

	@Autowired
	IPricesRepository pricesRepository;
	
	@Autowired
	Fechas fechas;

	@Override
	public Optional<Prices> getPrice(String fechaAplicacion, Long idProducto, Long idCadena) {
		LocalDateTime dateTime = fechas.localDateTimeToString(fechaAplicacion);
		Predicate<Prices> filterPredicate = x -> x.getStartDate().isBefore(dateTime) && x.getEndDate().isAfter(dateTime)
				&& x.getProductId().equals(idProducto) && x.getBrandId().getId().equals(idCadena);
		List<Prices> prices = getPrices().parallelStream().filter(filterPredicate).collect(Collectors.toList());
		if (prices.stream().count() > 1) {
			return prices.stream().max(Comparator.comparing(Prices::getPriority));
		} else {
			return prices.stream().findFirst();
		}
	}

	@Override
	public List<Prices> getPrices() {
		return StreamSupport.stream(pricesRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}