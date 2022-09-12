package com.codegym.service.impl;

import com.codegym.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculator {

    @Override
    public String calculate(String string, double num1, double num2) {
        try {
            switch (string) {
                case "add":
                    return String.valueOf(num1 + num2);
                case "sub":
                    return String.valueOf(num1 - num2);
                case "mul":
                    return String.valueOf(num1 * num2);
                case "div":
                    if (num2 == 0) {
                        return "Not divisible by 0";
                    } else {
                        return String.valueOf(num1 / num2);
                    }
            }
        } catch (NumberFormatException e) {
            return "Please input number !";
        }
        return "";
    }
}
