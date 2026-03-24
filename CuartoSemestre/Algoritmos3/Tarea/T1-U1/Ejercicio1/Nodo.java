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

*****************************
ED NODO
*****************************
*/

public class Nodo {
	public String elemento;
	public Nodo siguiente = null;
	public Nodo anterior = null;
		
	public Nodo(String elemento){
		this.elemento = elemento;
	}
}