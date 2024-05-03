package com.springbootjsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjsp.model.CargoVencimentos;

@Repository
public interface CargoVencimentosRepository extends JpaRepository<CargoVencimentos, Integer> {
	List<CargoVencimentos> findByCargoId(Integer cargoId);
}