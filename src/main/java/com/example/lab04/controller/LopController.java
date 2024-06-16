package com.example.lab04.controller;

import com.example.lab04.entity.Lop;
import com.example.lab04.services.LopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/lop")
public class LopController {
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model) {
        List<Lop> dsLop = lopService.getAlllop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop) {
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @PostMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") Long id) {
        lopService.deleteLop(id);
        return "redirect:/lop"; //
    }


}