//Figura 5.12 PruebaPolizaAuto
//Demostracion de objetos String en la instruccion switch

public class PruebaPolizaAuto{
	public static void main (String [] args){
		//crea dos objetos PolizaAuto
		PolizaAuto poliza1 = 
			new PolizaAuto(1111111, "Toyota Camry", "NJ");
		
		PolizaAuto poliza2 =
			new PolizaAuto(2222222, "Ford Fusion", "ME");
			
		//muestra en pantalla si cada poliza esta en un estado sin culpa
		polizaEnEstadoSinCulpa(poliza1);
		polizaEnEstadoSinCulpa(poliza2);
	}
	
	//metodo que muestra en pantalla si una PolizaAuto
	//se encuentra en un estado con seguro de auto sin culpa
	public static void polizaEnEstadoSinCulpa(PolizaAuto poliza){
		System.out.println("La poliza de auto: ");
		System.out.printf(
			"Cuenta #: %d; Auto: %s; Estado %s %s un estado sin culpa%n%n",
			poliza.obtenerNumeroCuenta(), poliza.obtenerMarcaYModelo(),
			poliza.obtenerEstado(),
			(poliza.esEstadoSinCulpa() ? "esta en": "no esta en"));
		
	}
}