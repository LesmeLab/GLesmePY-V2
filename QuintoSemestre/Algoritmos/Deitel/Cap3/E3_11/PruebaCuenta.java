//Clase Cuenta(Fig 3.8) mod
//Ejercicio 3.11 y 3.15
/*
Modificacion de la clase PruebaCuenta (Fig 3.9)
*/

import java.util.Scanner;
public class PruebaCuenta{
	public static void mostrarCuenta (Cuenta c){
		System.out.println("**********************");
		System.out.printf("Cuenta%nNombre -> %s%nSaldo -> %.2f%n",c.obtenerNombre(),c.obtenerSaldo());
		System.out.println("**********************\n");
	}
	
	public static void main (String[] args){
		double montoDeposito;
		double montoRetiro;
		
		Cuenta cuenta1 = new Cuenta("Adela Chaparro", 12000.0);
		Cuenta cuenta2 = new Cuenta("Gustavo Lesme", 11500.1);
		
		mostrarCuenta(cuenta1);
		mostrarCuenta(cuenta2);
		/*
		//mostrar el saldo inicial de cada objeto
		System.out.printf("Saldo de %s:$%.2f%n",cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
		System.out.printf("Saldo de %s:$%.2f%n",cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
		*/
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("Escriba el monto a depositar en cuenta de %s",cuenta1.obtenerNombre());
		montoDeposito = entrada.nextDouble();
		System.out.printf("%nSumando +%.2f al saldo de la cuenta%n%n", montoDeposito);
		cuenta1.depositar(montoDeposito);
		
		mostrarCuenta(cuenta1);
		mostrarCuenta(cuenta2);
		/*
		System.out.printf("Saldo de %s:$%.2f%n",cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
		System.out.printf("Saldo de %s:$%.2f%n",cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
		*/
		
		
		//prueba de retirar
		System.out.printf("Escriba el monto a retirar en cuenta de %s",cuenta2.obtenerNombre());
		montoRetiro = entrada.nextDouble();
		if(montoRetiro<=cuenta2.obtenerSaldo()){
			System.out.printf("%nQuitando -%.2f al saldo de la cuenta%n%n", montoRetiro);
		}
		cuenta2.retirar(montoRetiro);
		
		mostrarCuenta(cuenta1);
		mostrarCuenta(cuenta2);
		/*
		System.out.printf("Saldo de %s:$%.2f%n",cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
		System.out.printf("Saldo de %s:$%.2f%n",cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
		*/
	}
}