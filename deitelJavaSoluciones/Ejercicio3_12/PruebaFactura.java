/*
Ejercicio 3.12 - Parte2
PruebaFactura

Aqui se demostraran las capacidades de la clase Factura
*/

public class PruebaFactura {
	public static void main (String args []){
		Factura f1 = new Factura ("AA32","Lapiz",1,4500.0);
		Factura f2 = new Factura ();
		
		System.out.printf("Monto de f1 - >%.2f%n%n",f1.obtenerMontoFactura());
		
		f2.imprimirFactura();
	}
}