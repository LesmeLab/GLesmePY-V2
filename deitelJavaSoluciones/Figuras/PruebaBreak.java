//Figura 5.13 PruebaBreak
// La instruccion break para salir de una instruccion for

public class PruebaBreak{
	public static void main (String [] args){
		int cuenta; 
		//variable de control tambien se usa cuando termina el ciclo
		
		for (cuenta = 1; cuenta <= 10; cuenta++){
			if ( cuenta == 5 ){
				break; //termina el ciclo si cuenta es 5
			}
			
			System.out.printf("%d ", cuenta);
		}
		
		System.out.printf("%nSalio del ciclo en cuenta = %d%n", cuenta);
	}
}// fin de la clase PruebaBreak