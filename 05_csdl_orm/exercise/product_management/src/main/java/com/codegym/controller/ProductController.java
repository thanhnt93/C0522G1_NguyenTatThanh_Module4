package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
//@GetMapping("/edit/{id}")
//public String showFormUpdate(@PathVariable int id, Model model) {
//    model.addAttribute("product", productService.findById(id));
//    return "edit";
//}
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @PostMapping ("/search")
    public String search(@RequestParam String name , Model model){
        model.addAttribute("productList",productService.findByName(name));
        return "index";
    }
}
