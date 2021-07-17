package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Dna;

/**
 * 
 * @author adbarros
 * Repositorio para la tabla dnas
 */
@Repository
public interface DnaRepository extends JpaRepository<Dna, Long>, JpaSpecificationExecutor<Dna> {
	// Contar dependiendo si es mutante o humano
	long countByMutant(Boolean mutant);

}
