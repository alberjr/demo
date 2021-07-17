package com.example.demo.util;

/**
 * 
 * @author adbarros
 * Clase para utilidades de operaciones
 */
public class OperationUtil {
	
	//Funcion que indica el caracter del dna en la fila y columna indicada
    public static char getValue(String[] dna, int posFila, int posCol) {
        return dna[posFila].charAt(posCol);
    }
	

}
