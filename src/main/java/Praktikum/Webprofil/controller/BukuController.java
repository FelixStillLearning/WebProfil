package Praktikum.Webprofil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import Praktikum.Webprofil.model.Buku;
import Praktikum.Webprofil.service.BukuService;
import java.util.List;

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
    
    @GetMapping("/landing")
    public String landing(@RequestParam(required = false) String search, Model model) {
        List<Buku> bukuList;
        
        if (search != null && !search.isEmpty()) {
            // Jika ada parameter pencarian, gunakan method search dari service
            bukuList = bukuService.search(search);
        } else {
            // Jika tidak ada parameter pencarian, tampilkan semua buku
            bukuList = bukuService.findAll();
        }
        
        model.addAttribute("bukuList", bukuList);
        return "buku/landing";
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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("buku", bukuService.findById(id));
        return "buku/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Buku buku) {
        bukuService.save(buku);
        return "redirect:/buku";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bukuService.deleteById(id);
        return "redirect:/buku";
    }
    
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("buku", bukuService.findById(id));
        return "buku/view";
    }
    
}
