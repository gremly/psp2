package edu.uniandes.ecos.logica;

import java.util.HashMap;
import java.util.LinkedList;

public class Operator {

	/*
	 * Listado de datos para operar
	 */
	private double varx;
	private int dof;
	private int segments;
		
	public void setData(double varx, int dof, int segments){
		this.varx = varx;
		this.dof = dof;
		this.segments = segments;
	}
	
	/**
	 * Calcula los rangos relativos de tamaño dado un listado de
	 * datos históricos usando desviación estándar.
	 * @return HashMap contiene los rangos calculados donde la llave es el nombre del
	 * rango y la clave su valor calculado..
	 */
	public HashMap<String, Double> calcIntegral(){
		HashMap<String, Double> relSize = new HashMap<String, Double>();
		Calc calc = new Calc();
		
		double integral = calc.iterateWithSimpson(this.varx,  this.dof, this.segments, 0.00001, 3);
		relSize.put("Integral (p) = ",  integral);
		
		return relSize;
	}
	
}
