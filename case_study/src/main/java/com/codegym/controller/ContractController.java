package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/contract")
    public String customerList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("contractList", contractService.findAll(pageable));
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("contractDetailList", contractDetailService.findAll());
        model.addAttribute("totalMoneyList", contractService.getTotalMoney());

        System.out.println(contractService.getTotalMoney());
        System.out.println(contractService.findAll(pageable));
        return "contract/index";
    }

    @GetMapping("/contract/create")
    public String create(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        return "contract/create";
    }

    @PostMapping("/contract/save")
    public String save(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Thêm mới hợp đồng thành công!");
        return "redirect:/contract";
    }
}
