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
                       Model model) {
        model.addAttribute("blogList", blogService.findByName(author,pageable));
        model.addAttribute("author",author);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());

        return "blog/create";
    }

    @GetMapping("/create1")
    public String create1(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());

        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Cập nhập Blog thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/remove";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "Xóa Blog thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 5, sort = "date_create", direction = Sort.Direction.DESC)
//                                   Pageable pageable, @RequestParam(value = "search", defaultValue = "")
//                                   String search, Model model) {
//
//        model.addAttribute("blogs", blogService.searchByAuthor(search, pageable));
//        model.addAttribute("categorys", categoryService.findAll());
//        model.addAttribute("search", search);
//
//        return "/blog/listdto";
//    }

}
