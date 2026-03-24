/*
Figura 11.5 UsoDeExcepciones.java
El mecanismo de manejo de excepciones try...catch...finally
*/

public class UsoDeExcepciones {
	public static void main (String [] args){
		try {
			lanzaExcepcion();
		} catch (Exception excepcion){
			System.err.println("La excepcion se manejo en main");
		}
		noLanzaExcepcion();
	}
	
	public static void lanzaExcepcion() throws Exception {
		try {
			System.out.println("Metodo lanzaExcepcion");
			throw new Exception(); //genera la excepcion
		} catch (Exception excepcion){ // atrapa la excepcion lanzadaen try
			System.err.println("La excepcion se manejo en el metodo lanzaExcepcion");
			throw excepcion;
		}finally {
			System.err.println("Se ejecuto finally en lanzaExcepcion");
		}
	}
	
	public static void noLanzaExcepcion(){
		try {
			System.out.println("Metodo noLanzaExcepcion");
			throw new Exception();
		} catch (Exception excepcion){
			System.err.println(excepcion);
		} finally{
			System.err.println("Se ejecuto Finally en noLanzaExcepcion");
		}
		System.out.println("Fin del metodo noLanzaExcepcion");
	}
}