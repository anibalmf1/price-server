package br.com.anibal.armory.controller;

import br.com.anibal.armory.model.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PriceController.PRICE_URL)
public class PriceController {

    private final Logger logger = LoggerFactory.getLogger(PriceController.class);

    public static final String PRICE_URL = "/price";
    public static final String GET_PRICE_URL = "/{product_id}";

    @GetMapping(GET_PRICE_URL)
    public Price getPrice(@PathVariable Integer product_id) {
        logger.info("CALL TO " + GET_PRICE_URL);
        Price price = new Price();
        price.setProduct_id(product_id);
        price.setPrice(150);
        return price;
    }
}
