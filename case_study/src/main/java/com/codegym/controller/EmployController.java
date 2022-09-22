package com.codegym.controller;

import com.codegym.dto.employee.EmployeeDto;
import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;

    @GetMapping("/employee")
    public String customerList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("employeeList", employeeService.findAll2(pageable));
        return "employee/index";
    }

    @GetMapping("/employee/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        return "employee/create";
    }

    @PostMapping("/employee/save")
    public String save(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Thêm mới nhân viên thành công !");
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employeeDto", employeeService.findById(id));
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/employee/update")
    public String update(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "/employee/edit";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirect.addFlashAttribute("success", "Cập nhập nhân viên thành công!");
        return "redirect:/employee";
    }

//    @GetMapping("/employee/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("employee", employeeService.findById(id));
//        model.addAttribute("positionList", positionService.findAll());
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        return "/employee/delete";
//    }

//    @PostMapping("/employee/delete")
//    public String delete(@RequestParam int id, RedirectAttributes redirect) {
//        employeeService.removeVer2(id);
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/employee";
//    }
}
