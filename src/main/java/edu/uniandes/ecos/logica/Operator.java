package edu.uniandes.ecos.logica;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase encargada de manipular los datos que llegan del usuario y los que se
 * devuelven procesados.
 * @author Oscar Javier Moreno Rey
 */
public class Operator {

	/*
	 * Listado de datos para operar
	 */
	private double varx;
	private int dof;
	private int segments;
		
	/**
	 * Inicialización de los valores para realizar los cálculos.
* 	 * @param varX Límite superior para evaluar la integral.
	 * @param dof Grados de libertad
	 *  @param segments Número de divisiones a realizar para sumar el área.
	 */
	public void setData(double varx, int dof, int segments){
		this.varx = varx;
		this.dof = dof;
		this.segments = segments;
	}
	
	/**
	 * Da una estructura al dato obtenido despues de calcular la integral. 
	 * @return Dato calculado con un identificador para ser mostrado al usuario.
	 */
	public HashMap<String, Double> calcIntegral(){
		HashMap<String, Double> relSize = new HashMap<String, Double>();
		Calc calc = new Calc();
		double integral = calc.iterateWithSimpson(this.varx,  this.dof, this.segments, 0.00001, 3);
		relSize.put("Integral (p) = ",  integral);
		
		return relSize;
	}
	
}
