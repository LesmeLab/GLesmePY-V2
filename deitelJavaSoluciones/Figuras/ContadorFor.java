//Figura 5.2 ContadorFor
//Repeticion controlada con contador, con la instruccion de repeticion for

public class ContadorFor{
	public static void main (String [] args){
		//el encabezado de la instruccion for incluye la inicializacion
		//la condicion de continuacion de ciclo y el incremento
		for (int contador = 1; contador <= 10; contador++){
			System.out.printf("%d ", contador);
		}
		
		System.out.println();
	}
}