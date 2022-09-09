package com.chuyendoi.controller;

import com.chuyendoi.service.Convert;
import com.chuyendoi.service.IConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    private IConvert convert;

    @GetMapping("")
    public String chuyenDoi() {
        return "result";
    }

    @PostMapping
    public String converts(@RequestParam double usd, Model model) {
        Double results = convert.money(usd);
        model.addAttribute("results", results);
        return "result";
    }
}
