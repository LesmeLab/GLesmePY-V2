import java.util.Scanner;

public class calculoPrimo {

	public boolean esPrimo(int n, int k){
		if (k == 1){
			return true;
		}
		else{
			if (n%k == 0){
				return false;
			} else {
				return (true && esPrimo(n, k-2));
			}
		}
	}
	
	public boolean primo (int n){
		if (n < 2){
			return false;
		}
		else if (n == 2){
			return true;
		}else if (n % 2 ==0 && n!=2){
			return false;
		}else{
			return esPrimo(n,n-2);
		}
	}
	
	public void imprimirPrimo(int n){
		if (primo(n)){
			System.out.printf("El numero %d es primo%n",n);
		} else{
			System.out.printf("El numero %d NO es primo%n",n);
		}
	}
	
	public String imprimirPrimo1(boolean p){
		if (p){
			return "S";
		}else{
			return "N";
		}
	}
	
	public void tiempoEjecucion(int n1,int n2, int n3, int n4, int n5){
		System.out.printf("    N\t      Primo? \t Tiempo de Ejecucion%n");
		long ini, fin, t1,t2,t3,t4,t5;
		boolean b1,b2,b3,b4,b5;
		ini = System.nanoTime();
		b1 = primo(n1);
		fin = System.nanoTime();
		t1 = fin - ini;
		
		ini = System.nanoTime();
		b2 = primo(n2);
		fin = System.nanoTime();
		t2 = fin - ini;
		
		ini = System.nanoTime();
		b3 = primo(n3);
		fin = System.nanoTime();
		t3 = fin - ini;
		
		ini = System.nanoTime();
		b4 = primo(n4);
		fin = System.nanoTime();
		t4 = fin - ini;
		
		ini = System.nanoTime();
		b5 = primo(n5);
		fin = System.nanoTime();
		t5 = fin - ini;
		
		System.out.printf("%d\t\t%s\t\t%d ns%n",n1,imprimirPrimo1(b1),t1);
		System.out.printf("%d\t\t%s\t\t%d ns%n",n2,imprimirPrimo1(b2),t2);
		System.out.printf("%d\t\t%s\t\t%d ns%n",n3,imprimirPrimo1(b3),t3);
		System.out.printf("%d\t\t%s\t\t%d ns%n",n4,imprimirPrimo1(b4),t4);
		System.out.printf("%d\t%s\t\t%d ns%n%n",n5,imprimirPrimo1(b5),t5);
	
	}
	
	public void tiempoEjecucion1(int n1,int n2, int n3, int n4, int n5){
		System.out.printf("    N\t      Primo? \t Tiempo de Ejecucion%n");
		long ini, fin, t1,t2,t3,t4,t5;
		boolean b1,b2,b3,b4,b5;
		ini = System.nanoTime();
		b1 = primo(n1);
		fin = System.nanoTime();
		t1 = fin - ini;
		
		ini = System.nanoTime();
		b2 = primo(n2);
		fin = System.nanoTime();
		t2 = fin - ini;

		
		
		System.out.printf("%d\t\t%s\t\t%d ns%n",n1,imprimirPrimo1(b1),t1);
		System.out.printf("%d\t\t%s\t\t%d ns%n",n2,imprimirPrimo1(b2),t2);
		System.out.printf("%d\t%s\t\t%d ns%n",n3,"Error",0);
		System.out.printf("%d\t%s\t\t%d ns%n",n4,"Error",0);
		System.out.printf("%d\t%s\t\t%d ns%n%n",n5,"Error",0);
		
	}

	public static void main(String [] args){
		calculoPrimo p = new calculoPrimo();
		//p.imprimirPrimo(10000000);
		p.primo(3400001);
		p.tiempoEjecucion(2327957,4524823,6415231,9842582,10000000);
		p.tiempoEjecucion1(6415231,9842582,2000123239, 1415398997,Integer.MAX_VALUE);
	}
}
