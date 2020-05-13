package br.com.anibal.armory.service;

import br.com.anibal.armory.model.Price;
import br.com.anibal.armory.repository.PriceRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository repository;

    public Optional<Price> getPrice(Integer product_id) {
        List<Price> prices = repository.findByProductId(product_id);
        return Optional.ofNullable(Iterables.getLast(prices, null));
    }

    public Optional<Price> savePrice(Price price) {
        Price created = repository.save(price);
        return Optional.of(created);
    }
}
