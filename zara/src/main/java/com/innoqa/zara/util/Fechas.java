package com.innoqa.zara.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Miguel Ventocilla Barreda
 *
 */

@Service
public class Fechas {
	
	/**
	 * Conversión de una fecha en formato cadena a LocalDateTime
	 * 
	 * @param string fecha
	 * @return LocalDateTime
	 */
	public LocalDateTime localDateTimeToString(String string) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss", Locale.US);
		return LocalDateTime.parse(string, formatter);
	}

	/**
	 * Conversión de un LocalDateTime a una fecha en formato cadena 
	 * 
	 * @param localDateTime
	 * @return string fecha
	 */
	public String StringToLocalDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss", Locale.US);
		return localDateTime.format(formatter);
	}
}
