/*
Tarea 6 - Logica
Gustavo Lesme
*/

import java.util.Scanner;

public class calculoPrimo {
	/*public boolean esPrimo(int n, int k){
		if (k == 1){
			return true;
		}
		else{
			if (n%k == 0){
				return false;
			} else {
				return (true && esPrimo(n, k-2));
			}
		}
	}*/
	
	public boolean esPrimo(int n, int k){
		if (k == 1){
			return true;
		}
		else{
			if (n%k == 0){
				return false;
			} else {
				return (true && esPrimo(n, k-2));
			}
		}
	}
	
	public boolean primo (int n){
		if (n < 2){
			return false;
		}
		else if (n == 2){
			return true;
		}else{
			Double n1 = Math.sqrt(n);
			int n2 = n1.intValue();
			return esPrimo(n2,n2-2);
		}
	}
	
	public void imprimirPrimo(int n){
		if (primo(n)){
			System.out.printf("El numero %d es primo%n",n);
		} else{
			System.out.printf("El numero %d NO es primo%n",n);
		}
	}
	
	public static void main(String [] args){
		System.out.println("Si metes -1 dejara de preguntar numeros");
		Scanner entrada = new Scanner(System.in);
		int n, k=0;
		calculoPrimo p = new calculoPrimo();
		do{
			System.out.println("Ingrese numero -> ");
			n = entrada.nextInt();
			p.imprimirPrimo(n);
		}while (n != -1);
		/*
		for (int i=0;i<50;i++){
			if (p.primo(i)){
				System.out.printf("El numero %d es primo%n",i);
				k++;
			}
		}
		System.out.println("Hay "+k+" numeros primos de 2 hasta 6415231");
		/**/
	}
}
