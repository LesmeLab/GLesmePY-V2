/*
Figura 11_3 DivisionEntreCeroConManejoDeExcepciones
Manejo de excepciones ArithmeticException e InputMismatchException
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionEntreCeroConManejoDeExcepciones{
	public static int cociente (int numerador, int denominador)throws ArithmeticException {
			return numerador/denominador; //posible division entre cero
	}
	
	public static void main (String [] args){
		Scanner entrada = new Scanner (System.in);
		boolean continuarCiclo = true;
		
		do {
			try { //lee dos numeros y calcula el cociente
				System.out.print("Numerador Entero ->");
				int numerador = entrada.nextInt();
				System.out.print("Denominador Entero ->");
				int denominador = entrada.nextInt();
				
				int resultado = cociente(numerador,denominador);
				System.out.printf("%nResultado: %d / %d = %d%n", 
									numerador,denominador,resultado);
				continuarCiclo = false;
			} catch (InputMismatchException inputMismatchException){
				System.err.printf("%nExcepcion: %s%n",inputMismatchException);
				entrada.nextLine(); //descarta entrada para que el usuario lo reintente
				System.out.println("Solo enteros. Intente de nuevo\n\n");
				
			} catch (ArithmeticException aritmeticException){
				System.err.printf("%nExcepcion: %s%n",aritmeticException);
				System.out.printf("Cero no puede ser denominador.Reintente%n%n");
	
			}
		} while(continuarCiclo);
	}
}