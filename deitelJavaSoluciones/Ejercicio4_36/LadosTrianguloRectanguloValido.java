/*
4.36 (Lados de un triángulo rectángulo)Escriba una aplicación que lea tres 
enteros distintos de cero, y luego determine e imprima si éstos podrían 
representar los lados de un triángulo rectángulo.
*/

import java.util.Scanner;
public class LadosTrianguloRectanguloValido {
	public static boolean trianguloValido (int a,int b,int c){
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
			if (a*a != b*b+c*c){
				if (b*b != c*c+a*a){
					if (c*c != a*a+b*b){
						System.out.println("No TRiangulo Rectangulo");
					}
					else System.out.println("Si rectangulo");
				}
				else System.out.println("Si rectangulo");
			}
			else System.out.println("Si rectangulo");
		}else {
			System.out.println("TRIANGULO INVALIDO");
		}
	}
}