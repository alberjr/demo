package com.example.demo.models.output;

/**
 * @author adbarros
 * Clase para mapear la respuesta de las estadisticas
 */
public class StatMutant {
	
	private long countMutantDna;
	private long countHumanDna;		
	private double ratio;
	/**
	 * @return the countMutantDna
	 */
	public long getCountMutantDna() {
		return countMutantDna;
	}
	/**
	 * @param countMutantDna the countMutantDna to set
	 */
	public void setCountMutantDna(long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	/**
	 * @return the countHumanDna
	 */
	public long getCountHumanDna() {
		return countHumanDna;
	}
	/**
	 * @param countHumanDna the countHumanDna to set
	 */
	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	/**
	 * @return the ratio
	 */
	public double getRatio() {
		return ratio;
	}
	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	

}
