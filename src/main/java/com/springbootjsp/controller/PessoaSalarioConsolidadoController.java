package com.springbootjsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootjsp.model.PessoaSalarioConsolidado;
import com.springbootjsp.service.PessoaSalarioConsolidadoService;

@Controller
public class PessoaSalarioConsolidadoController {

    @Autowired
    private PessoaSalarioConsolidadoService pessoaSalarioConsolidadoService;

    @GetMapping("/listagem")
    public String listarPessoas(Model model) {
        List<PessoaSalarioConsolidado> info = pessoaSalarioConsolidadoService.obterTodasPessoasSalarioConsolidado();
        model.addAttribute("informations", info);
        return "listagemPessoas";
    }
}

