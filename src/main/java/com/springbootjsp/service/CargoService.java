package com.springbootjsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjsp.model.Cargo;
import com.springbootjsp.repository.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo obterCargoPorId(Integer cargoId) {
        if (cargoId != null) {
            return cargoRepository.findById(cargoId).orElse(null);
        } else {
            return new Cargo(0, "Sem Cargo");
        }
    }
}
