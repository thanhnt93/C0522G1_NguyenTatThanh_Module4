package com.codegym.model;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private  double price;

    @Getter @Setter
    private String producer;

    public Product() {
    }

    public Product(int id, String name, double price, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }
}
