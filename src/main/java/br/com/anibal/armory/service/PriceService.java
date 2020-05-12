package br.com.anibal.armory.service;

import br.com.anibal.armory.model.Price;
import br.com.anibal.armory.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    private PriceRepository repository;

    public Price getPrice(Integer product_id) {
        return repository.findByProductId(product_id);
    }
}
