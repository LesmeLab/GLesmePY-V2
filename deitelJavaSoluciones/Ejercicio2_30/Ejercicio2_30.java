/*
2.30 (Separación de los dígitos en un entero (( )oEscriba una aplicación que reciba del usuario un número compues
to por cinco dígitos, que separe ese número en sus dígitos individuales y los imprima, cada uno separado de los demás 
por tres espacios. Por ejemplo, si el usuario escribe el número42339, el programa debe imprimir
4   2   3   3   9
*/

import java.util.Scanner;

public class Ejercicio2_30 {
	public static void main ( String args [] ){
		Scanner entrada = new Scanner ( System.in );
		int x;
		x = entrada.nextInt();
		
		System.out.printf("%d 	%d 	%d 	%d 	%d",(x/10000),
						((x%10000)/1000),
						(((x%10000)%1000)/100),
						((((x%10000)%1000)%100)/10),
						((((x%10000)%1000)%100)%10));
	}
}
