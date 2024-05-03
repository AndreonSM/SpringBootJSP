package com.springbootjsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vencimentos")
public class Vencimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private String descricao;
    private double valor;
    private String tipo;

    public Vencimentos() {
    }

    public Vencimentos(int id, String descricao, double valor, String tipo) {
		//super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
}