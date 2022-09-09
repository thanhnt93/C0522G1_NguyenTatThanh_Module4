package com.convert.controller;

import com.convert.service.IConvertService;
import com.convert.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {

    @Autowired
    private IConvertService convertService;

    @GetMapping("/convert")
    public String convert() {
        return "convertMoney";
    }

    @GetMapping("result")
    public String converts(@RequestParam double usd, Model model) {
        Double convertMoney = convertService.money(usd);
        model.addAttribute("convertMoney", convertMoney);
        return "convertMoney";
    }
}
