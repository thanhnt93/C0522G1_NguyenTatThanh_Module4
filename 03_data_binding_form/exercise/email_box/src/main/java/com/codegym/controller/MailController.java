package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping("")
    public String boxMail(Model model) {
        List<Mail> emailList = mailService.findAll();
        model.addAttribute("mailList", emailList);
        return "index";
    }

    @GetMapping("/update")
    public String edit(Model model) {
        model.addAttribute("mail", new Mail());
        return "setting";
    }

    @PostMapping("/edit")
    public String updateMail(@ModelAttribute Mail mail, Model model) {

        if (mail.getSpamsFillter() == null) {
            mail.setSpamsFillter("no spams ");
        }
        if (mail.getSignature().equals("")) {
            mail.setSignature("user not character name");
        }
        model.addAttribute("mail1", mail);
        return "setting";
    }
}

