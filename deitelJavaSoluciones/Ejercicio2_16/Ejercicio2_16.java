/*
2.16 (Comparación de enteros). Escriba una aplicación que pida al usuario que escriba dos enteros, que obtenga 
los números del usuario y muestre el número más grande, seguido de las palabras “es más grande”. Si los números son 
iguales, imprima el mensaje “Estos números son iguales”.

*/

import java.util.Scanner;
public class Ejercicio2_16 {
	public static void main (String args []){
		Scanner entrada = new Scanner (System.in);
		int n1,n2;
		System.out.println("Ingrese el numero A ->");
		n1 = entrada.nextInt();
		
		System.out.println("Ingrese el numero B ->");
		n2 = entrada.nextInt();
		
		if (n1>n2){
			System.out.printf("%d es mas grande que %d%n",n1,n2);
		}else if (n1 == n2){
			System.out.println("Son iguales");
		}else{
			System.out.printf("%d es mas grande que %d%n",n2,n1);
		}
	}
}