package com.codegym.controller;

import com.codegym.model.Mail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MailController {

    @GetMapping("")
    public String settingMail() {

        return "redirect:/edit";
    }


    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("mail", new Mail());
        return "setting";
    }

    @PostMapping("/update")
    public String updateMail(@ModelAttribute Mail mail, Model model) {

        if (mail.getSpamsFilter() == null) {
            mail.setSpamsFilter("no spams ");
        }
        if (mail.getSignature().equals("")) {
            mail.setSignature("user not character name");
        }
        model.addAttribute("mail", mail);
        return "setting";
    }
}

