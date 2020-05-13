package br.com.anibal.armory.repository;

import br.com.anibal.armory.model.Price;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Integer> {

    List<Price> findByProductId(Integer product_id);

}