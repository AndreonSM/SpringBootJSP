package com.springbootjsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootjsp.model.PessoaSalarioConsolidado;

@Repository
public interface PessoaSalarioConsolidadoRepository extends JpaRepository<PessoaSalarioConsolidado, Integer>{
	@Modifying
	@Transactional
	@Query("UPDATE PessoaSalarioConsolidado p SET p.salario = :salario WHERE p.pessoaId = :pessoaId")
	void atualizarSalario(@Param("pessoaId") Long pessoaId, @Param("salario") double salario);

	@Query(value = "SELECT COALESCE(MAX(id) + 1, 1) FROM pessoa_salario_consolidado", nativeQuery = true)
    Integer findNextAvailableId();
}