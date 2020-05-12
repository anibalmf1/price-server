package br.com.anibal.armory.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "product_id")
    private int productId;

    private double price;

}
