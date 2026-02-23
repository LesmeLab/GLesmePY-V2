/*
3.12 (La clase Factura)a Cree una clase llamada Factura que una ferretería podría utilizar para representar una 
factura para un artículo vendido en la tienda. Una Factura debe incluir cuatro piezas de información como variables 
de instancia: un número de pieza (tipoString), la descripción de la pieza (tipoString), la cantidad de artículos de ese 
tipo que se van a comprar (tipoint) y el precio por artículo (double). Su clase debe tener un constructor que iniciali
ce las cuatro variables de instancia. Proporcione un método establecery un método r obtener para cada variable de r
instancia. Además, proporcione un método llamadoobtenerMontoFactura, que calcule el monto de la factura (es 
decir, que multiplique la cantidad de artículos por el precio de cada uno) y después devuelva ese monto como un valor 
double. Si la cantidad no es positiva, debe establecerse en 0. Si el precio por artículo no es positivo, debe establecerse 
en0.0. Escriba una aplicación de prueba llamada PruebaFactura, que demuestre las capacidades de la clase Factura.
*/
import java.util.Scanner;
public class Factura {
	private String numeroPieza;
	private String descripcionPieza;
	private int cantidadArticulos;
	private double precioArticulo;
	
	public Factura (String numeroPieza,String descripcionPieza,
					int cantidadArticulos,double precioArticulo){
		this.numeroPieza = numeroPieza;
		this.descripcionPieza = descripcionPieza;
		this.cantidadArticulos = cantidadArticulos;
		this.precioArticulo = precioArticulo;
	}
	
	public Factura (){
		Scanner entrada = new Scanner(System.in);
		System.out.println("CREACION DE FACTURA");
		System.out.printf("%nIngrese el numero de Pieza ->");
		this.numeroPieza = entrada.nextLine();
		System.out.printf("%nIngrese descripcion de pieza ->");
		this.descripcionPieza = entrada.nextLine();
		System.out.printf("%nIngrese cantidad del articulo ->");
		this.cantidadArticulos = entrada.nextInt();
		System.out.printf("%nIngrese precio de articulo ->");
		this.precioArticulo = entrada.nextDouble();
		System.out.printf("%nFACTURA CREADA%n%n");
	}
	
	//establecer - obtener
	public void establecerNumeroPieza (String numeroPieza){
		this.numeroPieza = numeroPieza;
	}
	public String obtenerNumeroPieza (){
		return this.numeroPieza;
	}
	public void establecerDescripcionPieza (String descripcionPieza){
		this.descripcionPieza = descripcionPieza;
	}
	public String obtenerDescripcionPieza (){
		return this.descripcionPieza;
	}
	public void establecerCantidadArticulos (int cantidadArticulos){
		this.cantidadArticulos = cantidadArticulos;
	}
	public int obtenerCantidadArticulos (){
		return this.cantidadArticulos;
	}
	public void establecerPrecioArticulo (double precioArticulo){
		this.precioArticulo = precioArticulo;
	}
	public double obtenerPrecioArticulo (){
		return this.precioArticulo;
	}
	
	public double obtenerMontoFactura (){
		if (cantidadArticulos*precioArticulo < 0){
			return 0.0;
		}
		return cantidadArticulos*precioArticulo;
	}
	
	public void imprimirFactura(){
		System.out.println("----------Factura---------");
		System.out.printf("Numero de Pieza	->%s%n",obtenerNumeroPieza());
		System.out.printf("Descripcion		->%s%n",obtenerDescripcionPieza());
		System.out.printf("Cantidad			->%d%n",obtenerCantidadArticulos());
		System.out.printf("Precio x Articulo->%.2f%n",obtenerPrecioArticulo());
		System.out.printf("Monto de Factura ->%.2f%n%n",obtenerMontoFactura());
	}
	
}