package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceContext;

@Controller

public class MusicController {
    @Autowired
    IMusicService musicService;

    @GetMapping("")
    public String showMusic(Model model) {
        model.addAttribute("musicList", musicService.findAll());
        return "music";
    }

    @GetMapping("/show-create")
    public String showCreate(Music music, Model model) {
        model.addAttribute("createMusic", new Music());
        return "create";
    }
    @PostMapping("create")
    public String create(Music music, Model model){
      musicService.save(music);
      return "redirect:/";
    }
    @GetMapping("/show-update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
      model.addAttribute("updateMusic",musicService.findOne(id));
        return "update";
    }
    @PostMapping("/show-update/update")
    public String update( Music music){
        musicService.update( music);
        return "redirect:/";
    }
//    @GetMapping("/delete/{id}")
//    private String delete(@PathVariable int id, Model model) {
//        model.addAttribute("music", musicService.findOne(id));
//        return "delete";
//    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        musicService.remove(id);
       // redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";}
}
