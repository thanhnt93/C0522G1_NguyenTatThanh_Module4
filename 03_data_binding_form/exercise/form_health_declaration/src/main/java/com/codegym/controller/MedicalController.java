package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService medicalService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("medicalDeclarationList", medicalService.findAll());
        return "home";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        model.addAttribute("createMedical", new MedicalDeclaration());
        model.addAttribute("birthdayList", medicalService.birthdayList());
        model.addAttribute("genderList", medicalService.genderList());
        model.addAttribute("countryList", medicalService.countryList());
        model.addAttribute("renderList", medicalService.renderList());
        model.addAttribute("starDayList", medicalService.starDayList());
        model.addAttribute("starMonthList", medicalService.starMonthList());
        model.addAttribute("starYearList", medicalService.starYearList());
        model.addAttribute("endDayList", medicalService.endDayList());
        model.addAttribute("endMonthList", medicalService.endMonthList());
        model.addAttribute("endYearList", medicalService.endYearList());
        return "create";
    }


    @PostMapping("/create")
    public String create(MedicalDeclaration medicalDeclaration) {
        medicalService.save(medicalDeclaration);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam String identity, Model model) {

        model.addAttribute("birthdayList", medicalService.birthdayList());
        model.addAttribute("genderList", medicalService.genderList());
        model.addAttribute("countryList", medicalService.countryList());
        model.addAttribute("renderList", medicalService.renderList());
        model.addAttribute("starDayList", medicalService.starDayList());
        model.addAttribute("starMonthList", medicalService.starMonthList());
        model.addAttribute("starYearList", medicalService.starYearList());
        model.addAttribute("endDayList", medicalService.endDayList());
        model.addAttribute("endMonthList", medicalService.endMonthList());
        model.addAttribute("endYearList", medicalService.endYearList());

        model.addAttribute("medicalDeclarationList", medicalService.findOne(identity));
        return "update";
    }

    @PostMapping("/update")
    public String update(MedicalDeclaration medicalDeclaration) {
        medicalService.update(medicalDeclaration.getIdentity(), medicalDeclaration);
        return "redirect:/";
    }
}
