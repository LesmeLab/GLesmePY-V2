import java.util.Scanner;

public class Ejercicio2_18{
	public static void main  (String [] args){
		int k;
		Scanner entrada = new Scanner(System.in);
		k = entrada.nextInt();
		//Cuadrado de tamanho k
		//Anchura arriba
		for (int x = 0; x<=k; x++){
			System.out.print("*");
		}
		System.out.println();
		//Altura abajo
		for (int x=0; x<=k-2; x++){
			System.out.print("*");
			for (int y=0; y<k-1; y++){
				System.out.print(" ");
			}
			System.out.println("*");
		}
		//Anchura abajo
		for (int x = 0; x<=k; x++){
			System.out.print("*");
		}
		System.out.println();
		
		
		//Solo cuadrado porque no se requiere de mas solo para practicar
	}
}