package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String home(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Music> musicList = musicService.findAll(pageable);
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("musicDto") MusicDto musicDto,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Thêm mới nhạc thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("musicDto", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        redirect.addFlashAttribute("success", "Cập nhập nhạc thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music product, RedirectAttributes redirect) {
        musicService.remove(product.getId());
        redirect.addFlashAttribute("success", "Xóa nhạc thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "name", defaultValue = "")
                                       String name, @PageableDefault(value = 5) Pageable pageable) {
        Page<Music> musics = musicService.search(name, pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("musicList", musics);
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
