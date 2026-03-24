//Figura 5.6 Interes
//Calculo del interes compuesto con for
/*
Una persona invierte $1,000.00 en una cuenta de ahorro que produce el 5% de interés. 
Suponiendo que todo el interés se deposita en la cuenta, calcule e imprima el monto 
de dinero en la cuenta al fi nal de cada año, 
durante 10 años. Use la siguiente fórmula para determinar los montos:
a=p*(1 +r)^n
en donde
p es el monto que se invirtió originalmente (es decir, el inicial)
r es la tasa de interés anual (por ejemplo, use 0.05 para el 5%) r
n es el número de años
a es la cantidad depositada al final del a n-ésimo año
*/

public class Interes {
	public static void main(String [] args){
		double monto;
		double principal = 1000.0;
		double tasa = 0.05;
		
		//muestre los encabezados
		System.out.printf("%s%20s%n", "Year", "Monto en Deposito");
		
		//calcula el monto en deposito para cada uno de diez anhos
		for (int year = 1; year <= 10; ++year){
			monto = principal * Math.pow(1.0 + tasa, year);
			
			System.out.printf("%4d%,20.2f%n", year, monto);
			//el %,20.2f imprimira con separador de miles usando ,
		}
	}
}