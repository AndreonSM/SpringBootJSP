package com.springbootjsp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjsp.model.Cargo;
import com.springbootjsp.model.CargoVencimentos;
import com.springbootjsp.model.Pessoa;
import com.springbootjsp.model.PessoaSalarioConsolidado;
import com.springbootjsp.model.Vencimentos;
import com.springbootjsp.repository.CargoVencimentosRepository;
import com.springbootjsp.repository.PessoaRepository;
import com.springbootjsp.repository.VencimentosRepository;
import com.springbootjsp.repository.PessoaSalarioConsolidadoRepository;

@Service
public class SalarioService {

    @Autowired
    private CargoVencimentosRepository cargoVencimentosRepository;

    @Autowired
    private VencimentosRepository vencimentosRepository;
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaSalarioConsolidadoRepository pessoaSalarioConsolidadoRepository;

    @Autowired
    private CargoService cargoService;
    
    

    public List<Integer> findVencimentoIdsByCargoId(Integer cargoId) {
        List<CargoVencimentos> cargoVencimentos = cargoVencimentosRepository.findByCargoId(cargoId);
        
        List<Integer> vencimentoIds = cargoVencimentos.stream()
                                                      .map(CargoVencimentos::getVencimentoId)
                                                      .collect(Collectors.toList());
        
        return vencimentoIds;
    }

    public List<Vencimentos> buscarDetalhesVencimentos(List<Integer> vencimentoIds) {
        return vencimentosRepository.findByIdIn(vencimentoIds);
    }
    
    public List<Pessoa> buscarDetalhesPessoas() {
        List<Pessoa> detalhesPessoas = pessoaRepository.findAll();
        return detalhesPessoas;
    }
    
    public double calcularSalarioParaPessoa(Pessoa pessoa) {
    	
    	double salario = 0.0;
        
        if (pessoa.getCargoId() == null) {
            return salario;
        }
        
        List<Integer> vencimentoIds = findVencimentoIdsByCargoId(pessoa.getCargoId());

        List<Vencimentos> detalhesVencimentos = buscarDetalhesVencimentos(vencimentoIds);
  
        for (Vencimentos vencimento : detalhesVencimentos) {
            if ("CREDITO".equals(vencimento.getTipo())) {
                salario += vencimento.getValor();
            } else if ("DEBITO".equals(vencimento.getTipo())) {
                salario -= vencimento.getValor();
            }
        }
        return salario;
    }
    
    public void atualizarSalariosConsolidadosParaTodasPessoas() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        for (Pessoa pessoa : todasPessoas) {
        	Cargo cargo = cargoService.obterCargoPorId(pessoa.getCargoId());
        	
            double salario = calcularSalarioParaPessoa(pessoa);
            PessoaSalarioConsolidado pessoaSalarioConsolidado = new PessoaSalarioConsolidado();
            pessoaSalarioConsolidado.setNomePessoa(pessoa.getNome());
            pessoaSalarioConsolidado.setSalario(salario);
            pessoaSalarioConsolidado.setNomeCargo(cargo.getNome());
            pessoaSalarioConsolidadoRepository.save(pessoaSalarioConsolidado);
        }
    }
    
    public void inserirRegistroConsolidado(PessoaSalarioConsolidado registro) {
        Integer nextId = pessoaSalarioConsolidadoRepository.findNextAvailableId();
        if (nextId == null) {
            nextId = (int) 1L;
        }
        registro.setPessoaId(nextId);
        pessoaSalarioConsolidadoRepository.save(registro);
    }
}
