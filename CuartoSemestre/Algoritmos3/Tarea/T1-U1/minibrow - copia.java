/*

*/
import java.util.Scanner;
public class minibrow {
	static public ListaEnlazada lista = new ListaEnlazada();
	static public Nodo actual = null;
	
	public static void comandoU (String s1){
		if (actual == null){
			lista.insertarInicio(s1);
			actual = lista.ultimo();
		}
		if (actual!=null && !lista.estaEnLaLista(s1)){
			lista.insertarInicio(s1);
			actual = lista.ultimo();
		}
	} 
	
	public static void comandoA (){
		if (actual.siguiente == null){
			System.out.println("IGNORADO");
		} else {
			actual = actual.siguiente;
		}
	}
	
	public static void comandoS (){
		if (actual.anterior == null){
			System.out.println("IGNORADO");
		}else {
			actual = actual.anterior;
		}
	}
	
	public static void comandoL (){
		System.out.println("-------------------");
		lista.imprimir(actual);
		System.out.println("-------------------");
	}
	
	public static Nodo obtenerNodoActual (){
		return actual;
	}
	
	public static void main (String [] args){
		comandoU(args[0]);
		System.out.println("Simulador de Navegador\n" + args[0]);
		Scanner entrada = new Scanner (System.in);
		String c;
		String url;
		boolean salir = true;
		while (salir){
			System.out.print("Ingrese comando (A,S,U,L,Q) (URL actual = "+obtenerNodoActual().elemento+" ) :");
			c = entrada.nextLine();
			if (c.equals("A")){
				comandoA();
			} else 
			if (c.equals("S")){
				comandoS();
			} else 
			if (c.equals("U")){
				url = entrada.nextLine();
				comandoU(url);
			} else
			if (c.equals("L")){
				comandoL();
			} else
			if (c.equals("Q")){
				salir = false;
			}else {
				System.out.println("Ingrese solo comandos validos\n");
			}
			
		}
	}
	
	
}