package br.com.anibal.armory.controller;

import br.com.anibal.armory.model.Price;
import br.com.anibal.armory.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(PriceController.PRICE_URL)
public class PriceController {

    final Logger logger = LoggerFactory.getLogger(PriceController.class);

    public static final String PRICE_URL = "/price";
    public static final String GET_PRICE_URL = "/{product_id}";

    @Autowired
    private PriceService service;

    @GetMapping(GET_PRICE_URL)
    public ResponseEntity<Price> getPrice(@PathVariable Integer product_id) {
        Optional<Price> price = service.getPrice(product_id);
        return price.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Price> savePrice(@RequestBody @Valid Price price) {
        logger.info("CALL TO savePrice");
        Optional<Price> created = service.savePrice(price);
        return created.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
}
