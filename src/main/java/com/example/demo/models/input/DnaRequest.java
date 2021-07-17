package com.example.demo.models.input;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @author alberb
 *	Clase para mapear Dna en el body de una peticion
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DnaRequest {
	
	private String [] dna;

	/**
	 * @return the DNA
	 */
	public String[] getDna() {
		return dna;
	}

	/**
	 * @param dna
	 *            the dna to set
	 */
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	

}
