/*
Figura 4.15 - Incremento
Operadores de preincremento y postincremento
*/

public class Incremento {
	public static void main ( String [] args ){
		int c;
		System.out.println("preincremento ++c");
		System.out.println("postincremento c++");
		
		c=5;
		System.out.printf("c antes del preincremento : %d%n",c);
		System.out.printf("c durante el preincremento: %d%n",++c);
		System.out.printf("c despues el preincremento: %d%n%n",c);
		
		c=5;
		System.out.printf("c antes del postincremento : %d%n",c);
		System.out.printf("c durante el postincremento :%d%n",c++);
		System.out.printf("c despues del postincremento : %d%n%n",c);
	}
}