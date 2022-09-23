package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String name;
    private String image;
    private String description;
    private Integer price;
    private  short discount;

    public ProductDto() {
    }

    public ProductDto(long id, String name, String image,
                      String description, Integer price,
                      short discount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
