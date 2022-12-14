package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;


    @GetMapping("")
    public String customerList(@PageableDefault(value = 5) Pageable pageable, Model model,
                               @RequestParam(defaultValue = "") String search) {
        model.addAttribute("customerList", customerService.findAll(pageable, search));
        model.addAttribute("search", search);
        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Th??m m???i kh??ch h??ng th??nh c??ng!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customerDto", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirect.addFlashAttribute("success", "C???p nh???p kh??ch h??ng th??nh c??ng!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        Customer customer = customerService.findById(id).get();
        List<Contract> contract = contractService.findByCustomerId(id);
        for (int i = 0; i < contract.size(); i++) {
            List<ContractDetail> contractDetailList = contractDetailService.getContractDetail(contract.get(i).getId());
            for (int j = 0; j < contractDetailList.size(); j++) {
                contractDetailService.remove(contractDetailList.get(j));
            }
            contractService.remove(contract.get(i).getId());
        }
        customerService.remove(id);
        redirect.addFlashAttribute("success", "X??a kh??ch h??ng th??nh c??ng !");
        return "redirect:/customer";
    }
}
