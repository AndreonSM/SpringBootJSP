package com.springbootjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.springbootjsp.model.Cargo;
import com.springbootjsp.model.Pessoa;
import com.springbootjsp.repository.CargoRepository;
import com.springbootjsp.repository.PessoaRepository;
import com.springbootjsp.service.SalarioService;
import com.springbootjsp.service.PessoaService;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private CargoRepository cargoRepository;
    
    @Autowired
    private SalarioService salarioService;
    
    @Autowired
    private PessoaService pessoaService;
  
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

    @GetMapping("/pessoas/criar")
    public String exibirFormularioCriar(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "formularioCriarPessoa";
    }

	@PostMapping("/pessoas/criar")
	public String criarPessoa(@ModelAttribute Pessoa pessoa, RedirectAttributes redirectAttributes) {
    	if (pessoa.getCargoId() < 1 || pessoa.getCargoId() > 5) {
        	redirectAttributes.addFlashAttribute("erro", "INVALID-CARGO-ID.");
        	return "redirect:/pessoas/criar";
    	}
    
    	Pessoa pessoaCriada = pessoaService.criarPessoa(pessoa);
    	Long idPessoaCriada = pessoaCriada.getId();
    	return "redirect:/pessoas/" + idPessoaCriada;
	}

    @GetMapping("/pessoas/editar/{id}")
    public String exibirFormularioEditar(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        model.addAttribute("pessoa", pessoa);
        return "formularioEditarPessoa";
    }

    @PostMapping("/pessoas/editar/{id}")
    public String editarPessoa(@PathVariable("id") Long id, @ModelAttribute Pessoa pessoa) {
        if (pessoa.getCargoId() < 1 || pessoa.getCargoId() > 5) {
        	return "redirect:/pessoas/editar/" + id + "?erro=INVALID-CARGO-ID.";
        }
        
        pessoa.setId(id);
        pessoaService.atualizarPessoa(pessoa);
        return "redirect:/pessoas/" + id;
    }

    @GetMapping("/pessoas/excluir/{id}")
    public String excluirPessoa(@PathVariable("id") Long id) {
        pessoaService.excluirPessoa(id);
        return "redirect:/pessoas/1";
    }

}

