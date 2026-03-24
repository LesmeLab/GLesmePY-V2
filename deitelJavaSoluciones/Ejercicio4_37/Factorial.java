/*

4.37 (Factorial) El factorial de un entero nno negativo se escribe como n! 
(se pronuncia factorial den) y se define de la siguiente manera:
n! = n ∙ (n– 1) ∙ (n– 2) ∙ ...  ∙ 1 (para valores de nmayores o iguales a 1)
y 
n! = 1 (para n = 0)
Por ejemplo, 5! = 5 ∙ 4 ∙ 3 ∙ 2 ∙ 1, que es 120.
a) Escriba una aplicación que lea un entero no negativo, y calcule e 
imprima su factorial.
b) Escriba una aplicación que estime el valor de la constante matemática e,
utilizando la siguiente fórmula. 
Deje que el usuario introduzca el número de términos a calcular.
e (euler) = 1+ 1/1! + 1/2! + ...
c)Escriba una aplicación que calcule el valor de e^x, utilizando la siguiente
fórmula. Deje que el usuario introduzca el número de términos a calcular

e^x = 1 + x/1! + (x^2)/2! + (x^3)/3! + ...
*/

import java.util.Scanner;
public class Factorial {
	public static double factorial (double x){
		double valor = 1;
		while (x>0){
			valor = valor*x;
			x--;
		}
		return valor;
	}
	
	public static double euler (){
		double valor = 1.0; 
		int x = 1;
		while (x<15){
			valor = valor + 1/factorial(x);
			x++;
			
		}
		return valor;
	}
	
	public static double potencia (double a, int b){
		int x = 1;
		double valor=1;
		if (b==0){
			if (a!=0){
				return 1;
			}
		}
		while (x<=b){
			valor =valor*a;
			x++;
		}
		return valor;
	}
	public static double eElevadoAx (int x){
		double eulerNum = euler();
		double valor = 1.0;
		int y = 1;
		while (y<20){
			valor = valor + potencia(x,y)/factorial(y);
			y++;
			
		}
		return valor;
	}
	
	public static void main (String [] args){
		System.out.printf("5!->%.0f%n",factorial(5));
		System.out.printf("euler->%.5f%n",euler());
		System.out.printf("3^5->%.0f%n",potencia(3,5));
		System.out.printf("e^2->%.6f%n",eElevadoAx(2));
		System.out.printf("9^112->%.0f%n",potencia(9,112));
		//COMPLETAMENTE FUNCIONAL, REQUIERE EXCEPCIONES
	}
}