package com.springbootjsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootjsp.model.Vencimentos;
import com.springbootjsp.repository.VencimentosRepository;

@Controller
public class VencimentosController {

    @Autowired
    private VencimentosRepository vencimentosRepository;

    @GetMapping("/vencimentos")
    public String listarVencimentos(Model model) {
        List<Vencimentos> vencimentos = vencimentosRepository.findAll();
        model.addAttribute("vencimentos", vencimentos);
        return "vencimentos";
    }
}
