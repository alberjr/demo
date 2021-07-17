package com.example.demo.models.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * @author alberb
 *
 */

public class StatMutantTest {
	// Datos validar get and set
	private long countMutantDna=1L;
	private long countHumanDna=1L;		
	private double ratio=0;
	

	@Test
	public void validSetGet() {	
		// Test get and set del modelo
		
		StatMutant object01 = new StatMutant();
		// act
		object01.setCountHumanDna(this.countHumanDna);
		object01.setCountMutantDna(this.countMutantDna);
		object01.setRatio(this.ratio);
		// assert
		assertNotNull(object01);
		assertEquals(this.countHumanDna, object01.getCountHumanDna());
		assertEquals(this.countMutantDna, object01.getCountMutantDna());
		assertEquals(this.ratio, object01.getRatio());
	}
	
}
