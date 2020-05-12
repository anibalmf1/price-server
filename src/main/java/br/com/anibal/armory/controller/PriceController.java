package br.com.anibal.armory.controller;

import br.com.anibal.armory.model.Price;
import br.com.anibal.armory.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PriceController.PRICE_URL)
public class PriceController {
    public static final String PRICE_URL = "/price";
    public static final String GET_PRICE_URL = "/{product_id}";

    @Autowired
    private PriceService service;

    @GetMapping(GET_PRICE_URL)
    public ResponseEntity<Price> getPrice(@PathVariable Integer product_id) {
        Price price = service.getPrice(product_id);

        if (price == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}
