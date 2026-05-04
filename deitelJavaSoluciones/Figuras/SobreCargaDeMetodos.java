//Figura 20.1 SobreCargaDeMetodos
//Impresion de elementos Array usando sobrecarga de metodos

public class SobreCargaDeMetodos{
	public static void main (String [] args){
		//Creacion de arreglos Integer, Double y Character
		Integer[] integerArray = {1, 2, 3, 4, 5 , 6};
		Double[] doubleArray = {1.1, 2.0, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'O', 'L', 'A'};
		
		//Impresion usando el metodo sobrecargado printArray
		System.out.println("Arreglo integerArray contiene:");
		printArray(integerArray);
		
		System.out.println("Arreglo doubleArray contiene:");
		printArray(doubleArray);
		
		System.out.println("Arreglo characterArray contiene:");
		printArray(characterArray);
	}
	
	//metodo printArray para imprimir Arreglo Integer
	public static void printArray(Integer[] inputArray){
		//display array elements
		for(Integer element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	//metodo printArray para imprimir Arreglo Double
	public static void printArray(Double[] inputArray){
		//display array elements
		for (Double element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	//metodo printArray para imprimir Arreglo Character
	public static void printArray(Character[] inputArray){
		//display array elements
		for (Character element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
}