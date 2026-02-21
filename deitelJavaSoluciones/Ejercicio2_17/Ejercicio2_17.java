/*
2.17 (Aritmética: menor y mayor). Escriba una aplicación que reciba tres enteros del usuario y muestre la suma, 
promedio, producto, menor y mayor de esos números.
[nota: el cálculo del promedio en este ejercicio debe dar como resultado una representación entera del promedio. Por lo tanto, 
si la suma de los valores es 7, el promedio debe ser 2, no 2.3333...].
*/

import java.util.Scanner;

public class Ejercicio2_17 {
	public static void main (String args []){
		Scanner entrada = new Scanner (System.in);
		int x,y,z;
		System.out.print("X->");
		x = entrada.nextInt();
		System.out.print("Y->");
		y = entrada.nextInt();
		System.out.print("Z->");
		z = entrada.nextInt();
		
		System.out.printf("Suma -> %d%n",x+y+z);
		System.out.printf("Promedio-> %d%n",(x+y+z)/3);
		System.out.printf("Producto -> %d%n", x*y*z);
		
		//Mayor
		if (x>y){
			if (y>z){
				System.out.printf("Mayor ->%d%n",x);
			}else if (x>z){
				System.out.printf("Mayor ->%d%n",x);
			}else {
				System.out.printf("Mayor ->%d%n",z);
			}
		} else if (y>z){
			System.out.printf("Mayor ->%d%n",y);
		}else{
			System.out.printf("Mayor ->%d%n",z);
		}
		
		//Menor
		if (x>y){
			if (y>z){
				System.out.printf("Menor ->%d%n",z);
			}else{
				System.out.printf("Menor ->%d%n",y);
			}
		}else{
			if (x<z){
				System.out.printf("Menor ->%d%n",x);
			}else{
				System.out.printf("Menor ->%d%n",z);
			}
		}
	}
}