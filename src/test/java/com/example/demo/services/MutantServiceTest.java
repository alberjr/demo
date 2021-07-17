package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import com.example.demo.models.Dna;
import com.example.demo.models.output.StatMutant;
import com.example.demo.repositories.DnaRepository;

/**
 * @author alberb
 *
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class MutantServiceTest {
	
	// Mock DnaRepository
	@Mock
	private DnaRepository dnaRepository;
	

	// Mock MutantService
	@InjectMocks
	private MutantService mutantService;
	
	//Casos de Dna por recorrido
	// Dna Humano
	private String [] dnaHuman= {"GTGCTA","CAGTGC","TTATGT","AGAAGG","TCCCTA","TCACTG"};
	//Dna con secuencias en verticar y Horizontal
	private String [] dnaMutantHoVe= {"GTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	//Dna con secuencias en Diagonales principales
	private String [] dnaMutantDiagPrin= {"ATGCTA","CATTGC","TTATGT","AGAATG","TCCCTA","TCACTG"};
	//Dna con secuencias en Diagonales secundarias
	private String [] dnaMutantDiagSec= {"ACTGCA","ATCCAT","GTCATG","ACAACA","TTGCGC","GGAGAC"};
	// respuesta si es humano
	private boolean respHuman=false;
	// respuesta si es mutante
	private boolean respMutant= true;
	
	
	@Test
	public void validateIsMutantHuman() {
		//Test isMutant Dna Humano
		Dna dnaSave= new Dna();
		dnaSave.setId(1L);
		dnaSave.setDnaInfo(Arrays.toString(dnaHuman));
		dnaSave.setMutant(false);
		dnaSave.setCreateDate(LocalDateTime.now());
		when(dnaRepository.save(any(Dna.class))).thenReturn(dnaSave);
		boolean resp=mutantService.isMutant(dnaHuman);
		assertNotNull(resp);
		assertEquals(respHuman,resp);
		
	}
	
	@Test
	public void validateIsMutantHoVe() {
		//Test isMutant Dna con secuencias en verticar y Horizontal
		Dna dnaSave= new Dna();
		dnaSave.setId(1L);
		dnaSave.setDnaInfo(Arrays.toString(dnaMutantHoVe));
		dnaSave.setMutant(false);
		dnaSave.setCreateDate(LocalDateTime.now());
		when(dnaRepository.save(any(Dna.class))).thenReturn(dnaSave);
		boolean resp=mutantService.isMutant(dnaMutantHoVe);
		assertNotNull(resp);
		assertEquals(respMutant,resp);
		
	}
	
	@Test
	public void validateIsMutantDiagPrin() {
		//Test isMutant Dna con secuencias en Diagonales principales
		Dna dnaSave= new Dna();
		dnaSave.setId(1L);
		dnaSave.setDnaInfo(Arrays.toString(dnaMutantDiagPrin));
		dnaSave.setMutant(false);
		dnaSave.setCreateDate(LocalDateTime.now());
		when(dnaRepository.save(any(Dna.class))).thenReturn(dnaSave);
		boolean resp=mutantService.isMutant(dnaMutantDiagPrin);
		assertNotNull(resp);
		assertEquals(respMutant,resp);
		
	}
	
	@Test
	public void validateIsMutantDiagSec() {
		//Test isMutant Dna con secuencias en Diagonales secundarias
		Dna dnaSave= new Dna();
		dnaSave.setId(1L);
		dnaSave.setDnaInfo(Arrays.toString(dnaMutantDiagSec));
		dnaSave.setMutant(false);
		dnaSave.setCreateDate(LocalDateTime.now());
		when(dnaRepository.save(any(Dna.class))).thenReturn(dnaSave);
		boolean resp=mutantService.isMutant(dnaMutantDiagSec);
		assertNotNull(resp);
		assertEquals(respMutant,resp);
		
	}
	
	@Test
	public void validateStatsOk() {
		// Test stats sin divicion por 0
		Long numL=1L;
		double numB=1;
		when(dnaRepository.countByMutant(any(Boolean.class))).thenReturn(numL);
		StatMutant resp=mutantService.stats();
		assertNotNull(resp);
		assertEquals(numL,resp.getCountHumanDna());
		assertEquals(numL,resp.getCountMutantDna());
		assertEquals(numB,resp.getRatio());
		
	}
	
	@Test
	public void validateStatsDiv0() {
		// Test stats con divicion por 0
		Long numL=0L;
		double numB=0;
		when(dnaRepository.countByMutant(any(Boolean.class))).thenReturn(numL);
		StatMutant resp=mutantService.stats();
		assertNotNull(resp);
		assertEquals(numL,resp.getCountHumanDna());
		assertEquals(numL,resp.getCountMutantDna());
		assertEquals(numB,resp.getRatio());
		
	}


}
