package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void amountDecrease(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            if (productMap.get(productDto) > 1) {
                Integer currentValue = productMap.get(productDto);
                productMap.replace(productDto, currentValue - 1);
            } else {
                productMap.remove(productDto);
            }

        }
    }

    public Integer countTotalPayment() {
        Integer payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
