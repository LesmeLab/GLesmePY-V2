//Figura 5.14 PruebaContinue
//Instruccion continue para terminar una iteracion de una instruccion for

public class PruebaContinue{
	public static void main(String [] args){
		for (int cuenta = 1; cuenta <= 10; cuenta++){
			if (cuenta == 5){
				continue;
				//continue hace que se omita toda la instruccion de 
				//este paso del for
			}
			
			System.out.printf("%d ", cuenta);
		}
		
		System.out.println("%nSe uso continue para omitir imprimir 5%n");
	}//fin de main
}//fin de clase PruebaContinue