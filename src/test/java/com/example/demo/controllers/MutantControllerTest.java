package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.models.input.DnaRequest;
import com.example.demo.models.output.StatMutant;
import com.example.demo.services.MutantService;
/**
 * 
 * @author alberb
 *	
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class MutantControllerTest {

	@Mock
	private MutantService mutantService;
	

	@InjectMocks
	private MutantController mutantController;
	
	ResponseEntity<Object> respOk=new ResponseEntity<>(HttpStatus.OK);
	ResponseEntity<Object> respForbidden=new ResponseEntity<>(HttpStatus.FORBIDDEN);
	
	@Test
	public void validIsMutantOk() {
		//Test isMutant cuando es mutante
		DnaRequest input= new DnaRequest ();
		String [] dna= {"AAAA","AAAA","AAAA","AAAA"};
		input.setDna(dna);
		when(mutantService.isMutant(input.getDna())).thenReturn(true);
		ResponseEntity<Object> resp=mutantController.isMutant(input);
		assertNotNull(resp);
		assertEquals(HttpStatus.OK,resp.getStatusCode());
		
	}
	
	@Test
	public void validIsMutantForbidden() {
		//Test isMutant cuando no es mutante
		DnaRequest input= new DnaRequest ();
		String [] dna= {"AAAA","AAAA","AAAA"};
		input.setDna(dna);
		when(mutantService.isMutant(input.getDna())).thenReturn(false);
		ResponseEntity<Object> resp=mutantController.isMutant(input);
		assertNotNull(resp);
		assertEquals(HttpStatus.FORBIDDEN,resp.getStatusCode());
		
	}
	
	@Test
	public void validIsMutantInternalErr() {
		//Test isMutant cuando sucede un error
		DnaRequest input= new DnaRequest ();
		String [] dna= {"AAAA","AAAA","AAAA"};
		input.setDna(dna);
		when(mutantService.isMutant(input.getDna())).thenThrow();
		ResponseEntity<Object> resp=mutantController.isMutant(input);
		assertNotNull(resp);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,resp.getStatusCode());
		
	}
	
	@Test
	public void validStats() {
		//Test stats 
		StatMutant stat= new StatMutant();
		stat.setCountHumanDna(1);
		stat.setCountMutantDna(2);
		stat.setRatio(0.5);
		when(mutantService.stats()).thenReturn(stat);
		StatMutant resp=mutantController.stats();
		assertNotNull(resp);
		assertEquals(stat.getCountHumanDna(),resp.getCountHumanDna());
		assertEquals(stat.getCountMutantDna(),resp.getCountMutantDna());
		assertEquals(stat.getRatio(),resp.getRatio());
		
	}
}
