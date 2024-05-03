package com.springbootjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springbootjsp.model.Cargo;
import com.springbootjsp.model.Pessoa;
import com.springbootjsp.repository.CargoRepository;
import com.springbootjsp.repository.PessoaRepository;
import com.springbootjsp.service.SalarioService;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private CargoRepository cargoRepository;
    
    @Autowired
    private SalarioService salarioService;
  
    @GetMapping("/pessoas/{id}")
    public String mostrarPessoa(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de pessoa inválido: " + id));
       
        model.addAttribute("pessoa", pessoa);
        
        if (pessoa.getCargoId() != null) {
            Cargo cargo = cargoRepository.findById(pessoa.getCargoId())
                .orElseThrow(() -> new IllegalArgumentException("ID de cargo inválido: " + pessoa.getCargoId()));
            model.addAttribute("cargo", cargo.getNome());
        } else {
            model.addAttribute("cargo", "Sem cargo");
        }
           
        double salarioConsolidado = salarioService.calcularSalarioParaPessoa(pessoa);
        model.addAttribute("salarioConsolidado", salarioConsolidado); 
        return "mostrarPessoa";
    }



}

