package Praktikum.Webprofil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import Praktikum.Webprofil.model.Buku;
import Praktikum.Webprofil.service.BukuService;

@Controller
@RequestMapping("/buku")    
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping
    public String List(Model model) {
        model.addAttribute("bukuList", bukuService.findAll());
        return "buku/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("buku", new Buku());
        return "buku/form";
    }

    @PostMapping
    public String save(@ModelAttribute Buku buku) {
        bukuService.save(buku);
        return "redirect:/buku";
    }


    
}
