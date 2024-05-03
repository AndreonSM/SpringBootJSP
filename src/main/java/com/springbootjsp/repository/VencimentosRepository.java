package com.springbootjsp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjsp.model.Vencimentos;

@Repository
public interface VencimentosRepository extends JpaRepository<Vencimentos, Integer> {
	Optional<Vencimentos> findById(Integer id);
	List<Vencimentos> findByIdIn(List<Integer> vencimentoIds);
}