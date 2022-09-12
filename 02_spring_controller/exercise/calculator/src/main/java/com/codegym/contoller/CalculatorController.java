package com.codegym.contoller;


import com.codegym.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculator calculator;

    @GetMapping("")
    public String home() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String string,
                            @RequestParam(defaultValue = "0") double num1,
                            @RequestParam(defaultValue = "0") double num2,
                            Model model) {
        String result = calculator.calculate(string, num1, num2);
        model.addAttribute("result", result);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calculator";
    }
}
