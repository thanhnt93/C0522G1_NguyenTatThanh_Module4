package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("/list")
//    public String home(@PageableDefault(value = 5) Pageable pageable, Model model) {
//        model.addAttribute("blogList", blogService.findAll(pageable));
//        return "index";
//    }
    @GetMapping("/list")
    public String home(@PageableDefault(value = 5, sort = "day", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(defaultValue = "") String author ,
                       Model model, RedirectAttributes redirect) {
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        model.addAttribute("blogList", blogService.findByName(author,pageable));
        model.addAttribute("author",author);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());

        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "remove";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }


}
