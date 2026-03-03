/*
Figura 4.8 - PromedioClase
Solucion al problema del promedio de la clase mediante la repeticion 
controlada por contador.
*/

import java.util.Scanner;

public class PromedioClase {
	public static void main ( String [] args ){
		Scanner entrada = new Scanner ( System.in );
		
		int total = 0;
		int contadorCalificaciones = 1;
		int calificacion;
		int promedio;
		
		while ( contadorCalificaciones <= 10 ){
			System.out.print("Calificacion ->");
			calificacion = entrada.nextInt();
			total = total + calificacion;
			contadorCalificaciones = contadorCalificaciones + 1;
		}
		
		promedio = total/10;
		
		System.out.printf( "El total de las calificaciones es %d%n",total );
		System.out.printf( "El promedio de calificaciones es %d%n", promedio);
	}
}