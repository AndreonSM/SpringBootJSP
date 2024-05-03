package com.springbootjsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjsp.model.Pessoa;
import com.springbootjsp.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }
    
    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    public Pessoa obterPessoaPorId(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        return optionalPessoa.orElse(null);
    }

    public void atualizarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}