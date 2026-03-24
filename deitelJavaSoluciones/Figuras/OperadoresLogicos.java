//Figura 5.19 OperadoresLogicos
//Los Operadores Logicos  + pruebas

public class OperadoresLogicos{
	public static void main (String [] args){
		//crea tabla de verdad para el operador && (AND CONDICIONAL)
		System.out.println("&& (AND CONDICIONAL)");
		System.out.println(" P \t Q \t | P && Q");
		System.out.println("-------------------------------");
		System.out.println(" V \t V \t | "+ (true && true));
		System.out.println(" V \t F \t | "+ (true && false));
		System.out.println(" F \t V \t | "+ (false && true));
		System.out.println(" F \t F \t | "+ (false && false));
		System.out.println();
		
		//crea tabla de verdad para el operador || (OR CONDICIONAL)
		System.out.println("|| (OR CONDICIONAL)");
		System.out.println(" P \t Q \t | P || Q");
		System.out.println("-------------------------------");
		System.out.println(" V \t V \t | "+ (true || true));
		System.out.println(" V \t F \t | "+ (true || false));
		System.out.println(" F \t V \t | "+ (false || true));
		System.out.println(" F \t F \t | "+ (false || false));
		System.out.println();
		
		//crea tabla de verdad para el operador & (AND logico booleano)
		System.out.println("& (AND logico booleano)");
		System.out.println(" P \t Q \t | P & Q");
		System.out.println("-------------------------------");
		System.out.println(" V \t V \t | "+ (true & true));
		System.out.println(" V \t F \t | "+ (true & false));
		System.out.println(" F \t V \t | "+ (false & true));
		System.out.println(" F \t F \t | "+ (false & false));
		System.out.println();
		
		//crea tabla de verdad para el operador && (OR inclusivo logico booleano)
		System.out.println("| (OR inclusivo logico booleano)");
		System.out.println(" P \t Q \t | P | Q");
		System.out.println("-------------------------------");
		System.out.println(" V \t V \t | "+ (true | true));
		System.out.println(" V \t F \t | "+ (true | false));
		System.out.println(" F \t V \t | "+ (false | true));
		System.out.println(" F \t F \t | "+ (false | false));
		System.out.println();
		
		//crea tabla de verdad para el operador ^ (OR exclusivo logico booleano)
		System.out.println("^ (OR exclusivo logico booleano)");
		System.out.println(" P \t Q \t | P ^ Q");
		System.out.println("-------------------------------");
		System.out.println(" V \t V \t | "+ (true ^ true));
		System.out.println(" V \t F \t | "+ (true ^ false));
		System.out.println(" F \t V \t | "+ (false ^ true));
		System.out.println(" F \t F \t | "+ (false ^ false));
		System.out.println();
		
		//crea tabla de verdad para el operador ! (negacion logica)
		System.out.println("! (negacion logica)");
		System.out.println(" P \t | !P");
		System.out.println("-------------------------------");
		System.out.println(" V \t | "+ !true);
		System.out.println(" F \t | "+ !false);
		System.out.println();
	}
}