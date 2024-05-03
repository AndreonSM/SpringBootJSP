package com.springbootjsp.model;

import java.sql.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String email;
    private String cep;
    private String endereco;
    private String pais;
    private String usuario;
    private String telefone;
    private Date dataNascimento;
    
    private Integer cargoId;
    
    public Pessoa() {
    }
    
    public Pessoa(Long id, String nome, String usuario, String email, Integer cargo_id) {
    	this.id = id;
    	this.nome = nome;
    	this.usuario = usuario;
    	this.email = email;
    	this.setCargoId(cargo_id);	
    }
    
	public Pessoa(Long id, String nome, String cidade, String email, String cep, String endereco, String pais,
			String usuario, String telefone, Date dataNascimento, Integer cargo_id) {
		//super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.pais = pais;
		this.usuario = usuario;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
    	this.setCargoId(cargo_id);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargo_id) {
		this.cargoId = cargo_id;
	}
}