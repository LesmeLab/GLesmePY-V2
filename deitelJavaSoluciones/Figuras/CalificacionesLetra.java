//Figura 5.9 - CalificacionesLetra
//La clase CalificacionesLetra usa la instruccion switch para contar las
//calificaciones de letra

import java.util.Scanner;

public class CalificacionesLetra{
	public static void main (String [] args){
		int total = 0;
		int contadorCalif = 0;
		int aCuenta = 0;
		int bCuenta = 0;
		int cCuenta = 0;
		int dCuenta = 0;
		int fCuenta = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n  %s%n  %s%n",
			"Introduzca las calificaciones en el rango de 0-100->",
			"Escriba el indicador de fin de archivo para terminar la entrada",
			"En UNIX/Linux/MacOSX escriba <Ctrl> d y oprima Intro",
			"En Windows Escriba <Ctrl> z y oprima Intro");
		
		while (entrada.hasNext()){
			int calificacion = entrada.nextInt();
			total += calificacion;
			++contadorCalif;
			
			switch (calificacion / 10){
				case 9: //calificacion entre 90
				case 10:// y 100
					++aCuenta;
					break; // sale del switch
					
				case 8: //calificacion entre 80-89
					++bCuenta;
					break;
					
				case 7: //calificacion entre 70-79
					++cCuenta;
					break;
					
				case 6: //calificacion entre 60-69
					++dCuenta;
					break;
					
				default: //calificacion menor que 60
					++fCuenta;
					break;
			}
		}
		
		System.out.printf("%nReporte de calificaciones: %n");
		
		if (contadorCalif != 0){
			double promedio = (double) total/contadorCalif;
			System.out.printf("El total de las %d calificaciones introducidas es %d%n",
					contadorCalif, total);
			System.out.printf("El promedio de la clase es %.2f%n", promedio);
			System.out.printf("%n%s%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n",
				"Numero de Estudiantes que recibieron cada calificacion :",
				"A->", aCuenta, "B->", bCuenta, "C->", cCuenta,
				"D->", dCuenta, "F->", fCuenta);
		} else{
			System.out.printf("NO SE INTRODUJERON CALIFICACIONES");
		}
	}
}