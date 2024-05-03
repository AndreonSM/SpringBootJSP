package com.springbootjsp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo_vencimentos")
public class CargoVencimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cargoId;
    private int vencimentoId;
    
    public CargoVencimentos() {
    }
    
	public CargoVencimentos(int id, int cargo_id, int vencimento_id) {
		//super();
		this.id = id;
		this.cargoId = cargo_id;
		this.vencimentoId = vencimento_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCargoId() {
	    return cargoId;
	}

	public void setCargoId(int cargoId) {
	    this.cargoId = cargoId;
	}

	public int getVencimentoId() {
	    return vencimentoId;
	}

	public void setVencimentoId(int vencimentoId) {
	    this.vencimentoId = vencimentoId;
	}

	
}