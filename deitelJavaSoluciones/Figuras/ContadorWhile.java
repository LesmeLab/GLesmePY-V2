//Figura 5.1 ContadorWhile
//Repeticion controlada con contador, con la instruccion de repeticion while

public class ContadorWhile {
	public static void main (String [] args){
		int contador = 1;
		
		while (contador <= 10){
			System.out.printf("%d ",contador);
			contador++;
		}
		System.out.println();
	}
}