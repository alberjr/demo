package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

/**
 * @author alberb
 *
 */
public class DnaTest {
	// Datos validar get and set
	private Long id = 1L;
	private String dnaInfo="[AAAA,BBBB,CCCC,DDDD]";
	private boolean mutant=true;
	private LocalDateTime createDate=LocalDateTime.now();
	

	@Test
	public void validSetGet() {	
		// Test get and set del modelo
		Dna object01 = new Dna();
		// act
		object01.setId(this.id);
		object01.setDnaInfo(this.dnaInfo);
		object01.setMutant(this.mutant);
		object01.setCreateDate(this.createDate);
		// assert
		assertNotNull(object01);
		assertEquals(this.id, object01.getId());
		assertEquals(this.dnaInfo, object01.getDnaInfo());
		assertEquals(this.mutant, object01.isMutant());
		assertEquals(this.createDate, object01.getCreateDate());
	}
}
