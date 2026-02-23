/*
Figura 3.1> Cuenta
Clase cuenta que contiene una variable de instancia llamada nombre
y metodos para establecer y obtener su valor
*/

public class Cuenta {
	private String nombre;		//variable de instancia
	private double saldo;
	
	//metodo para establecer el nombre en el objeto
	public void establecerNombre ( String nombre ){
		this.nombre = nombre;
	}
	
	//metodo para obtener el nombre del objeto
	public String obtenerNombre (){
		return nombre; 			//devuelve el valor de nombre a quien invoco
	}
	
	public Cuenta ( String nombre ){
		this.nombre = nombre;
	}
	public Cuenta (){ //auxiliar, por si se pregunta sin argumento
		this.nombre = null;
		this.saldo = 0.0;
	}
	
	public Cuenta (String nombre, double saldo){
		this.nombre = nombre;
		
		if (saldo > 0.0){
			this.saldo = saldo;
		}
	}
	
	//metodo que deposita suma solo una cantidad valida al saldo
	public void depositar (double montoDeposito){
		if (montoDeposito > 0.0){
			saldo = saldo + montoDeposito;
		}
	}
	
	//metodo que devuelve el saldo de la cuenta
	public double obtenerSaldo(){
		return saldo;
	}
}