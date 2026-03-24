/*
Ejercicio4_22 SalidaTabular
Escriba una aplicacion que utilice ciclos para imprimir

N       10*N    100*N   1000*N
1       10      100     1000
2       20      200     2000
3       30      300     3000
4       40      400     4000
5       50      500     5000
*/

public class SalidaTabular {
	public static void main ( String [] args ){
		int x;
		System.out.println("N\t10*N\t100*N\t1000*N");
		x=1;
		while (x<=5){
			System.out.println(x + "\t"+ (10*x) + "\t" + (100*x) + "\t" + (1000*x));
			x++;
		}
	}
}