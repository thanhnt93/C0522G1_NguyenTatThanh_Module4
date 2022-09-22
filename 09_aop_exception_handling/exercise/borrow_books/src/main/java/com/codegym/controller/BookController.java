package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String home(@PageableDefault(value = 5) Pageable pageable, Model model) throws Exception {
        Page<Book> bookList = bookService.findAll(pageable);
        model.addAttribute("bookList", bookList);
        return "index";

    }

    @GetMapping("/{id}/givebookback")
    public String editGiveBookBack(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "givebookback";
    }

    @PostMapping("/update")
    public String giveBookBack(@PageableDefault(value = 5) Pageable pageable, Book book, Model model, RedirectAttributes redirectAttributes) throws Exception {
        bookService.save(book);
        Page<Book> bookList = bookService.findAll(pageable);
        model.addAttribute("bookList", bookList);
        redirectAttributes.addFlashAttribute("success", "Trả sách thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/borrow")
    public String editBorrows(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "borrow";
    }

    @PostMapping("/update1")
    public String borrowBook(@PageableDefault(value = 5) Pageable pageable, Book book, Model model, RedirectAttributes redirectAttributes) throws Exception {
        bookService.payBook(book);
        Page<Book> bookList = bookService.findAll(pageable);
        model.addAttribute("bookList", bookList);
        redirectAttributes.addFlashAttribute("success", "Mượn sách thành công!");
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String errors() {
        return "errors";
    }
}
