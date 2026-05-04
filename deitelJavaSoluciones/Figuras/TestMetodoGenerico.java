//Figura 20.3 TestMetodoGenerico
//Impresion de arreglo de elementos usando un metodo generico printArray

public class TestMetodoGenerico{
	public static void main (String[] args){
		//Creacion de arreglos Integer, Double y Character
		Integer[] integerArray = {1, 2, 3, 4, 5 , 6};
		Double[] doubleArray = {1.1, 2.0, 3.3, 4.4, 5.5, 6.6, 7.7};
		Character[] characterArray = {'H', 'O', 'L', 'A'};
		
		System.out.println("Arreglo integerArray contiene:");
		printArray(integerArray);
		
		System.out.println("Arreglo doubleArray contiene:");
		printArray(doubleArray);
		
		System.out.println("Arreglo characterArray contiene:");
		printArray(characterArray);
	}
	
	//metodo generico printArray
	//todo metodo generico tiene <T> en la seccion de tipo de parametro, antes de lo que retorna
	public static <T> void printArray(T[] inputArray){
		for(T element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	/*TAMBIEN SE PUEDE USAR OBJECT
	public static void printArray(Object[] inputArray){
		for(Object element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	*/
}