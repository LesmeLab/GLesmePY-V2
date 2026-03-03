/*
Ejercicio 4.17 - Kilometraje de Gasolina

4.17 (Kilometraje de gasolina)Los conductores se preocupan por el kilometraje
de sus automóviles. Un conductor ha llevado el registro de varios 
reabastecimientos de combustible, registrando los kilómetros conducidos y 
los litros usados en cada tanque lleno. Desarrolle una aplicación en Java
que reciba como entrada los kilómetros conducidos y los litros usados 
(ambos como enteros) por cada viaje. El programa debe calcular y mostrar los
kilómetros por litro obtenidos en cada viaje, y debe imprimir el total de
kilómetros por litro obtenidos en todos los viajes hasta este punto. 
Todos los cálculos del promedio deben producir resultados en números de punto
flotante. 
Use la clase Scannery la repetición controlada por centinela para obtener 
los datos del usuario.
*/

import java.util.Scanner;
public class Ejercicio4_17 {
	public static void main (String [] args){
		int x = 0;
		int suma = 0;
		int kmConducido, litrosUsados;
		Scanner entrada = new Scanner (System.in);
		System.out.printf("%nKm Conducidos ->");
		kmConducido = entrada.nextInt();
		System.out.printf("%nLitros Usados ->");
		litrosUsados = entrada.nextInt();
		System.out.printf("%nKilometros x Litro ->%d",)
		while (x == 0){
			kmXlitro = entrada.nextInt();
		}
	}
}