/*
  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP 1-U1
  Ejercicio2

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he/hemos discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he/hemos usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.

OBS. Solo se ha utilizado el libro DEITEL, PAUL y DEITEL, HARVEY - Como programar en Java-Decima edición, para la busqueda de metodos
	 y libreria SecureRandom utiles para este ejercicio.
	 
NOTA. Respuesta a pregunta al pie de la clase ElementoMayoritario

OBS. El algoritmo del metodo elementoMayoritario fue extraido en parte e idea de https://www.enjoyalgorithms.com/blog/find-the-majority-element-in-an-array
	
*/


import java.security.SecureRandom;

public class ElementoMayoritario {
	static int pasos;
	
	public static <E> E encontrarMayoritario (E [] A) throws Exception{
		int contador = 0;
		pasos = 0;
		E elementoMayoritario = null;
		int i = 0;
		while ( i < A.length ){
			if (contador == 0 ){
				elementoMayoritario = A[i];
				pasos = pasos + 3;
			}
			if (A[i] != null && A[i].equals(elementoMayoritario)){
				contador++;
				pasos = pasos + 2;
			} else{
				contador--;
				pasos = pasos + 1;
			}
			pasos = pasos + 5;
			i++;
		}
		pasos = pasos + 6;
		contador = 0;
		i = 0;
		while (i < A.length){
			pasos = pasos + 3;
			if ( A[i].equals(elementoMayoritario)){
				contador++;
				pasos = pasos + 3;
			}
			if (contador > A.length/2){
				pasos = pasos + 4;
				return elementoMayoritario;
			}
			i++;
		}
		throw new Exception();
		
	}
		
	public static void main ( String [] args ){
		SecureRandom generador = new SecureRandom();
		int x = 100000;
		int y = 0;
		long tiempo = 0;
		System.out.println("N\t\tTiempo (en ms)\t\tCantidad de Pasos");
		System.out.println("-----------------------------------------");
		while (x <= 1000000){
			Integer [] A = new Integer [x];
			for ( int i = 0; i < A.length; i++){
				A[i] = 100000 + generador.nextInt(900001);
			}
			long tiempoInicio = System.currentTimeMillis();
			try{
				encontrarMayoritario(A);
			} catch (Exception e1){ //si hay excepcion significa que no hubo elementoMayoritario
				y++; //Cantidad de veces en las que no hay elementoMayoritario
			}
			long tiempoFin = System.currentTimeMillis();
			tiempo = tiempoFin - tiempoInicio;
			System.out.println(x + "\t\t" + tiempo + "\t\t" + pasos);
			x = x + 100000;
			
		}
		System.out.println("Hubieron "+y+" veces en las que no hubo elementoMayoritario");
	}
}

/*
************************************************
PREGUNTA: Existe una relacion entre el numero n, el tiempo que lleva la ejecucion
		   del algoritmo y la cantidad de pasos?

RESPUESTA: Si, abajo se adjunta una version preliminar inutilizable por su mala eficiencia,
			el numero n se vuelve critico al hacer while dentro de while, se nota empiricamente
			que si solo se usa un while es mas veloz.
****************************************************

	/*public static <E> E encontrarMayoritario (E [] A) throws Exception{ //
		int contador, x, y;
		pasos = 0;
		x = 0;
		while (x < A.length){
			y = 0;
			contador = 0;
			while (y < A.length){
				if ( A[x]!= null && A[y]!= null && A[x].equals(A[y]) ){
					contador++;
					pasos = pasos + 10;
				}
				if (contador > A.length/2){
					pasos = pasos + 5;
					return A[x];
				}
				y++;
				pasos = pasos + 3;
			}
			x++;
			pasos = pasos + 4;
		}
		pasos = pasos + 2;
		
		//Si no hay elementoMayoritario se lanza excepcion
		throw new Exception();
	}
*/