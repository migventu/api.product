package com.innoqa.zara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innoqa.zara.dao.Prices;

/**
 * 
 * @author Miguel Ventocilla Barreda
 *
 */

@Repository
public interface IPricesRepository extends CrudRepository<Prices, Long>{

}
