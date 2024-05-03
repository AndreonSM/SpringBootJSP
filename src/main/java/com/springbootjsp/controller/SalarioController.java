package com.springbootjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootjsp.service.SalarioService;

@Controller
@RequestMapping("/salarios")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @PostMapping("/atualizar-consolidados")
    public ResponseEntity<String> atualizarSalariosConsolidadosParaTodasPessoas() {
        salarioService.atualizarSalariosConsolidadosParaTodasPessoas();
        return ResponseEntity.ok("Os salários de todos foram atualizados com sucesso!!");
        
    }
}
