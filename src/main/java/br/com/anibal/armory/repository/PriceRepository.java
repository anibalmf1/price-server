package br.com.anibal.armory.repository;

import br.com.anibal.armory.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Integer> {

    Price findByProductId(Integer product_id);

}