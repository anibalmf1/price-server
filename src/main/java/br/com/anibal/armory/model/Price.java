package br.com.anibal.armory.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(name = "product_id")
    @NotNull
    private int productId;

    @NotNull
    private double price;

}
