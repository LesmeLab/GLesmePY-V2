/*
  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP 1-U1
  Ejercicio1

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he/hemos discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he/hemos usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.

OBS. Solo se ha utilizado el libro DEITEL, PAUL y DEITEL, HARVEY - Como programar en Java-Decima edición, para la busqueda de metodos
	utiles para este ejercicio.
	
NOTA. No se ha requerido de EXCEPCIONES

*************************************
ED LISTA
*************************************
*/

public class ListaEnlazada {
	
	static private Nodo cabeza = null;
	static private int longitud = 0;
	static private Nodo cola = null;
	
	
	public static void insertarInicio ( String s1 ){
		Nodo temporal = new Nodo (s1);
		if (cabeza == null){
			cabeza = temporal;
			cola = cabeza;
		} else {
			cabeza.anterior = temporal;
			temporal.siguiente = cabeza;
			cabeza = temporal;
		}
		longitud++;
	}
	
	public static Nodo index (String s1){
		Nodo actual = cabeza;
		int x = 0;
		while (x<longitud && actual!=null){
			if (s1.equals(actual.elemento)){
				return actual;
			}
			x++;
			actual=actual.siguiente;
		}
		return null;
	}
	
	public static boolean estaEnLaLista (String s1){
		if (index(s1)== null){
			return false;
		}
		else return true;
	}
	
	public static void imprimir (Nodo a1){
		Nodo actual = cabeza;
		int x = 0;
		while (x<longitud && actual!=null){
			if (actual == a1){
				System.out.println(actual.elemento + "<---");
			}else {
				System.out.println(actual.elemento);
			}
			x++;
			actual=actual.siguiente;
		}
		
	}
	
	public static Nodo ultimo(){
		return cabeza;
	}
	
}