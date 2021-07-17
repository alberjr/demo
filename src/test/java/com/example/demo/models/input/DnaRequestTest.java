package com.example.demo.models.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * @author alberb
 *
 */

public class DnaRequestTest {
	// Datos validar get and set
	private String [] dna= {"AAA","BBB","CCC"};
	

	@Test
	public void validSetGet() {		
		// Test get and set del modelo	
		DnaRequest object01 = new DnaRequest();
		// act
		object01.setDna(this.dna);
		// assert
		assertNotNull(object01);
		assertEquals(this.dna, object01.getDna());
	}

}
