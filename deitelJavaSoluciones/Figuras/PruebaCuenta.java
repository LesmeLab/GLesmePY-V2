/*
Figura 3.2> PruebaCuenta
Crear y manipular un objeto Cuenta
*/

import java.util.Scanner;

public class PruebaCuenta{
	public static void main ( String [] args ){
		//crea un objeto Scanner
		Scanner entrada = new Scanner (System.in);
		
		//crea un objeto Cuenta y lo asigna a miCuenta
		Cuenta miCuenta = new Cuenta();
		
		//muestra el valor inicial del nombre (null)
		System.out.printf("El nombre inicial es %s%n%n",miCuenta.obtenerNombre());
		//null es el valor predeterminado de las variables String
		
		
		//pide y lee
		System.out.println("Nombre->");
		String elNombre = entrada.nextLine();//Lee una linea de texto
		miCuenta.establecerNombre(elNombre); //Coloca el nombre en miCuenta
		System.out.println();
		
		
		//Muestra el nombre en miCuenta
		System.out.printf("El nombre en el objeto miCuenta es ->%s%n%n",
							miCuenta.obtenerNombre());//version menos segura
							
		System.out.println("Nombre en miCuenta->"+miCuenta.obtenerNombre());
		//version mas segura
		
		//crea dos objetos Cuenta
		Cuenta cuenta1 = new Cuenta ("Gustavo Lesme");
		Cuenta cuenta2 = new Cuenta ("Emanuel Ortega");
		
		//muestra el valor de cuenta1 y cuenta2
		System.out.println("Nombre de cuenta1 ->"+cuenta1.obtenerNombre());
		System.out.println("Nombre de cuenta2 ->"+cuenta2.obtenerNombre());
		
		Cuenta cuenta3 = new Cuenta ("Emanuel Lesme", 24.00);
		Cuenta cuenta4 = new Cuenta ("Gustavo Ortega", -2.1);
		
		System.out.print("Saldo de "+cuenta1.obtenerNombre());
		System.out.printf(" ->%f%n",cuenta1.obtenerSaldo());
		
		System.out.print("Saldo de "+cuenta3.obtenerNombre());
		System.out.printf(" ->%f%n",cuenta3.obtenerSaldo());
		
		System.out.print("Saldo de cuenta4 "+cuenta4.obtenerNombre());
		System.out.printf(" ->%f%n",cuenta4.obtenerSaldo());
		
		System.out.print("Monto a depositar en cuenta4->");
		double montoDeposito;
		montoDeposito = entrada.nextDouble();
		System.out.printf("%nSumando %.2f al saldo de cuenta4%n%n",montoDeposito);
		cuenta4.depositar(montoDeposito);
		
		System.out.print("Saldo de "+cuenta4.obtenerNombre());
		System.out.printf(" ->%f%n",cuenta4.obtenerSaldo());
		
	}
}