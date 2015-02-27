package edu.uniandes.ecos;

import edu.uniandes.ecos.logica.Calc;
import junit.framework.TestCase;

/**
 * Casos de prueba para la clase Calc, destinada a los cáclulos matemáticos.
 * @author Oscar Javier Moreno Rey
 */
public class CalcTest extends TestCase {

	/**
	 * 
	 */
	public void testCalculateGammaOne(){
		Calc calculator = new Calc();
		assertEquals(1.0, calculator.calculateGamma(1));
	}
	
	/**
	 * 
	 */
   public void testCalculateGammaMid(){
	   double x = 1.0/2;
	   Calc calculator = new Calc();
		assertEquals(Math.sqrt(Math.PI), calculator.calculateGamma(x));
	}
   
   /**
	 * 
	 */
  public void testCalculateGammaMidNine(){
	   double x = 9.0/2;
	   Calc calculator = new Calc();
		assertEquals(11.631728396567448, calculator.calculateGamma(x));
	}
  
   
   /**
    * 
    */
   public void testCalculateGammaOther(){
	   Calc calculator = new Calc();
		assertEquals(calculator.calculateFactorial(6 -1), calculator.calculateGamma(6));
	}
   
   /**
    * 
    */
   public void testCalculateTFunction(){
	   Calc calculator = new Calc();
	   assertEquals(0.38543693984483196, calculator.calculateTFunction(0.11, 9));
   }
   
   /**
    * 
    */
   public void testComputeSimpsonRule(){
	   Calc calculator = new Calc();
	   assertEquals(0.3500589042865573, calculator.computeSimpsonRule(1.1, 9, 10));
   }
   
   /**
    * 
    */
   public void testIterateWithSimpson(){
	   Calc calculator = new Calc();
	   assertEquals(0.35005863689720107, calculator.iterateWithSimpson(1.1, 9, 10, 0.00001, 2));
   }
}
