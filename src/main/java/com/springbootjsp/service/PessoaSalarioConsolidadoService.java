package com.springbootjsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjsp.model.PessoaSalarioConsolidado;
import com.springbootjsp.repository.PessoaSalarioConsolidadoRepository;

@Service
public class PessoaSalarioConsolidadoService {

    @Autowired
    private PessoaSalarioConsolidadoRepository pessoaSalarioConsolidadoRepository;

    public List<PessoaSalarioConsolidado> obterTodasPessoasSalarioConsolidado() {
        return pessoaSalarioConsolidadoRepository.findAll();
    }
}
