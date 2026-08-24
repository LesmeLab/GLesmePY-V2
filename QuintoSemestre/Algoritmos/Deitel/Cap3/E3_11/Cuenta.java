//Clase Cuenta(Fig 3.8) mod
//Ejercicio 3.11
/*
Modificacion de figura 3.8, la modificacion sera proporcionar un metodo retirar, que retire dinero
de un objeto Cuenta. Asegurese de que el monto a retirar no exceda el saldo de Cuenta.
Si el monto a retirar pasa el saldo de Cuenta, el saldo no varia y 
se imprimira "El monto a retirar excede el saldo de la cuenta".

Se usara tambien una modificacion de PruebaCuenta

*/
public class Cuenta{
	private String nombre;
	private double saldo;
	
	public Cuenta(String nombre, double saldo){
		this.nombre = nombre;
		
		if (saldo > 0.0){
			this.saldo = saldo;
		}
	}
	
	public void depositar(double montoDeposito){
		if (montoDeposito > 0.0){
			saldo = saldo + montoDeposito;
		}
	}
	
	public double obtenerSaldo(){
		return saldo;
	}
	
	public void establecerNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public void retirar (double monto){
		if (monto <= saldo){
			saldo = saldo-monto;
		} else {
			System.out.println("El monto a retirar excede el saldo de la cuenta.");
		}
	}
}