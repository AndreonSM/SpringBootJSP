package com.springbootjsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa_salario_consolidado")
public class PessoaSalarioConsolidado {
	
	@Id
	@Column(name = "pessoa_id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pessoaId;
	
	@Column(name = "nome_pessoa")
    private String nomePessoa;
	
	@Column(name = "nome_cargo")
    private String nomeCargo;
	
    private double salario;

    public PessoaSalarioConsolidado() {
    }

    public PessoaSalarioConsolidado(int pessoa_id, String nome_pessoa, String nome_cargo, double salario) {
        this.pessoaId = pessoa_id;
        this.nomePessoa = nome_pessoa;
        this.nomeCargo = nome_cargo;
        this.salario = salario;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoa_id) {
        this.pessoaId = pessoa_id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nome_pessoa) {
        this.nomePessoa = nome_pessoa;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nome_cargo) {
        this.nomeCargo = nome_cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
