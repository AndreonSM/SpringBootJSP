package com.springbootjsp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.springbootjsp.model.Pessoa;
import com.springbootjsp.repository.PessoaRepository;
//import com.springbootjsp.service.PessoaService;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    

    @Test
    public void testCriarPessoa() {
        // Configurando
        Pessoa pessoa = new Pessoa(100000L, "Fulano", "usuario", "fulano@email.com", 4);
        Pessoa pessoaCriada = new Pessoa(1L, "Fulano", "usuario", "fulano@email.com", 3);

        when(pessoaRepository.save(pessoa)).thenReturn(pessoaCriada);

        // Testando
        Pessoa result = pessoaService.criarPessoa(pessoa);

        // Assert
        assertEquals(pessoaCriada, result);
    }
    
    @Test
    public void testListarPessoas() {
        Pessoa pessoa1 = new Pessoa(100000L, "Fulano", "usuario", "fulano@email.com", 4);
        Pessoa pessoa2 = new Pessoa(100001L, "Ciclano", "usuario2", "ciclano@email.com", 5);
        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> result = pessoaService.listarPessoas();

        assertEquals(2, result.size());
        assertEquals("Fulano", result.get(0).getNome());
        assertEquals("Ciclano", result.get(1).getNome());
    }
    /*
    @Test
    public void testEditarPessoa() {
        Pessoa pessoa = new Pessoa(100000L, "Fulano", "usuario", "fulano@email.com", 4);
        Pessoa pessoaEditada = new Pessoa(100001L, "Ciclano", "usuario2", "ciclano@email.com", 5);

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(pessoa)).thenReturn(pessoaEditada);

        pessoa.setNome("Ciclano");
        Pessoa result = pessoaService.atualizarPessoa(pessoa);

        assertEquals(pessoaEditada, result);
    }
    */
    
}
