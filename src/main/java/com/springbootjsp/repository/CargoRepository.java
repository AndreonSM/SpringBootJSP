package com.springbootjsp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjsp.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	Optional<Cargo> findById(Integer id);
}