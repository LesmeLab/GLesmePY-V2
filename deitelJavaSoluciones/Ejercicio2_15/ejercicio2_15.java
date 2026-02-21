/*
2.15 Escriba una aplicación que pida al usuario que escriba dos números, que obtenga los números 
del usuario e imprima la suma, producto, diferencia y cociente (división) de los números. 
*/

import java.util.Scanner;
public class ejercicio2_15 {
    public static void main (String args []){
        Scanner entrada = new Scanner (System.in);
        int n1,n2;
        System.out.println("Ingrese el primer numero: ");
        n1 = entrada.nextInt();

        System.out.println("Ingrese el segundo numero: ");
        n2 = entrada.nextInt();

        System.out.printf("Suma: %d%n", n1+n2);
        System.out.printf("Producto: %d%n", n1*n2);
        System.out.printf("Diferencia: %d%n", n1-n2);
        System.out.printf("Cociente: %d%n", n1/n2);

        entrada.close();
    }
}