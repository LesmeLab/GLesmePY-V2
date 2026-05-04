//Fig 20.5 MaximumTest
//El metodo generico maximum retorna el mayor de los 3 objetos

public class MaximumTest{
	public static void main(String [] args){
		System.out.printf("Maximo entre %d , %d , %d es %d%n", 3,4,6, maximum(3,4,6));
		System.out.printf("Maximo entre %.1f , %.1f , %.1f es %.1f%n",
							6.6, 2.4, 6.9, maximum(6.6, 2.4, 6.9));
		System.out.printf("Maximo entre %s , %s , %s es %s%n",
							"pera", "manzana", "naranja", maximum("pera","manzana","naranja"));
	}
	
	//determina el mayor de los 3 Comparable objects
	public static <T extends Comparable <T>> T maximum(T x, T y, T z){
		T max = x; //asumiendo que x es el mayor
		
		if (y.compareTo(max) > 0){
			max = y;
		}
		
		if (z.compareTo(max) > 0){
			max = z;
		}
		
		return max;
	}
	
	//Otra forma, pero esta es una unsafe operation
	/*public static Comparable maximum (Comparable x, Comparable y, Comparable z){
		Comparable max = x; //asumiendo que x es el mayor
		
		if (y.compareTo(max) > 0){
			max = y;
		}
		
		if (z.compareTo(max) > 0){
			max = z;
		}
		
		return max;
	}*/
}