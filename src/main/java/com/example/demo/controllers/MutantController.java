package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.input.DnaRequest;
import com.example.demo.models.output.StatMutant;
import com.example.demo.services.MutantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

/**
 * @author alberb
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "${spring.data.rest.context}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MutantController {
	// Se inicializa MutantService
	@Autowired
	private MutantService mutantService;
	

	/**
	 * Servicio Rest para validar mutante
	 * @return ResponseEntity<Object>
	 */
	@PostMapping(value = "/mutant", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> isMutant(
			@RequestBody(required = true) DnaRequest dnaRequest) {
		try {
			//Se valida si es mutante
			if(mutantService.isMutant(dnaRequest.getDna())) {
				//Es mutante se retorna ok
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				//No es mutante se retorna forbidden
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);				
			}
		} catch (Exception e) {	
			//Sucedio un error		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * Servicio Rest para retornar estadisticas
	 * @return StatMutant
	 */
	@GetMapping(value = "/stats")
	public @ResponseBody StatMutant stats() {
			StatMutant stats= mutantService.stats();
			return stats;
	}

}
