/*
2.24 (Enteros menor y mayor). Escriba una aplicación que lea cinco enteros y que determine e imprima los enteros 
mayor y menor en el grupo. 
*/

import java.util.Scanner;

public class Ejercicio2_24 {
	public static void main ( String args [] ){
		Scanner entrada = new Scanner ( System.in );
		int a,b,c,d,e,menor,mayor;
		
		System.out.print("N->");
		a = entrada.nextInt();
		
		System.out.print("N->");
		b = entrada.nextInt();
		
		System.out.print("N->");
		c = entrada.nextInt();
		
		System.out.print("N->");
		d = entrada.nextInt();
		
		System.out.print("N->");
		e = entrada.nextInt();
		
		menor = a;
		mayor = a;
		if (b<menor){
			menor=b;
		}
		if (b>mayor){
			mayor = b;
		}
		
		if (c<menor){
			menor=c;
		}
		if (c>mayor){
			mayor = c;
		}
		
		if (d<menor){
			menor=d;
		}
		if (d>mayor){
			mayor = d;
		}
		
		if (e<menor){
			menor = e;
		}
		if (e>mayor){
			mayor = e;
		}
		
		System.out.printf("Menor->%d%n",menor);
		System.out.printf("Mayor->%d%n",mayor);
		System.out.printf("%d - %d - %d - %d - %d",a,b,c,d,e);
	}
}