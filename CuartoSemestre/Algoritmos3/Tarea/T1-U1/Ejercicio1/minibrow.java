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
*/
import java.util.Scanner;

public class minibrow {
	static public ListaEnlazada lista = new ListaEnlazada(); //Creacion de ED Lista
	static public Nodo actual = null;						 //Creacion de ED Nodo
	
	//comando U <url> que introduce una url.
	public static void comandoU (String s1){ 
		if (actual == null){ //Si no hay ninguna url, se agrega a la lista y se establece como actual
			lista.insertarInicio(s1);
			actual = lista.ultimo();
		}
		if (actual!=null && !lista.estaEnLaLista(s1)){ //Si ya hay al menos una url y esta no es duplicada se agrega a la lista y se establece como actual
			lista.insertarInicio(s1);
			actual = lista.ultimo();
		}
	} 
	
	//comando A, anterior retrocede a la url anterior si la hay, sino IGNORADO
	public static void comandoA (){
		if (actual.siguiente == null){
			System.out.println("IGNORADO");
		} else {
			actual = actual.siguiente;
		}
	}
	
	//comando S, siguiente avanza a la url siguiente si la hay, sino IGNORADO
	public static void comandoS (){
		if (actual.anterior == null){
			System.out.println("IGNORADO");
		}else {
			actual = actual.anterior;
		}
	}
	
	//comando L, imprime una lista de todas las url
	public static void comandoL (){
		System.out.println("-------------------");
		lista.imprimir(actual);
		System.out.println("-------------------");
	}
	
	//retorna la url actual
	public static Nodo obtenerNodoActual (){
		return actual;
	}
	
	
	public static void main (String [] args){
		if (args.length == 0){
			System.out.println("No ha ingresado la url como argumento\nURL por defecto: https://google.com.py\n");
			comandoU("https://google.com.py");
		}else {
			comandoU(args[0]); //Se ingresa a la url del argumento[0]
		}
		System.out.println("Simulador de Navegador\n");
		Scanner entrada = new Scanner (System.in); //Creacion de clase Scanner para obtencion de datos
		boolean salir = true; //bandera para while
		
		//Aqui ira en partes[0] el comando y en partes[1] ira la url, de partes[2 a Infinito] se desprecia su contenido.  
		String [] partes;
		
		//c es la abreviatura de comando
		String c;
		
		while (salir){
			System.out.print("Ingrese comando (A,S,U,L,Q) (URL actual = "+obtenerNodoActual().elemento+" ) :");
			c = entrada.nextLine();
			partes= c.split(" ");
			if (partes.length==0){ //Se verifica el caso en que no se metio ningun dato en la variable c.
				partes[0] = "a"; //Valor no valido, para reinicio de solicitud
			}
			if (partes[0].equals("A")){
				comandoA();
			} else 
			if (partes[0].equals("S")){
				comandoS();
			} else 
			if (partes[0].equals("U")){ // Si al poner el comando U <url> no se pone la url simplemente no pasa nada
				if (partes.length >1){
					comandoU(partes[1]);
				}
				
			} else
			if (partes[0].equals("L")){
				comandoL();
			} else
			if (partes[0].equals("Q")){
				salir = false;
			}else {
				System.out.println("Ingrese solo comandos validos\n");
			}
			
		}
	}
}

/*
 El método split de la clase String que descompone un objeto String en los tokens que 
lo componen. Los tokens se separan unos de otros mediante delimitadores, que por lo general son carac
teres de espacio en blanco tales como espacios, tabuladores, nuevas líneas y retornos de carro.
Fragmento Deitel-Java-10E
*/