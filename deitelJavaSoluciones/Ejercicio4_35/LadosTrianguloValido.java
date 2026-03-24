/*
Ejercicio4_35 LadosTriangulo
Escriba una aplicación que lea tres valores distintos de cero introducidos
por el usuario, y que determine e imprima si podrían representar los lados 
de un triángulo.

OBS. Debera cumplir que
"La suma de las longitudes cualesquiera siempre debe ser mayor a la longitud
del tercer lado"
*/

import java.util.Scanner;
public class LadosTrianguloValido {
	public static boolean trianguloValido (int a, int b, int c){
		if (a>0){
			if (b>0){
				if (c>0){
					if (a+b>c){
						if (b+c>a){
							if (c+a>b){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	
	public static void main ( String [] args ){
		int a,b,c;
		Scanner entrada = new Scanner (System.in);
		a = entrada.nextInt();
		b = entrada.nextInt();
		c = entrada.nextInt();
		
		if (trianguloValido(a,b,c)){
			System.out.println("Triangulo Valido");
		}else{
			System.out.println("Triangulo Invalido");
		}
	}
}