package com.codegym.service.impl;

import com.codegym.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculator {

    @Override
    public Double calculate(String string, double num1, double num2) {
        double result = 0;
        switch (string) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;

        }
return result;
    }
}
