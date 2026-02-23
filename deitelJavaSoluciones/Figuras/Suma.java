/*
3.1 Modifique el programa de suma que aparece en la figura 2.7 para usar la entrada y salida en un cuadro de 
diálogo con los métodos de la claseJOptionPane. Como el métodoshowInputDialogdevuelve un objeto String, 
debe convertir el objetoStringque introduce el usuario a unint para usarlo en los cálculos. El método parseInt
es un métodostatic de la claseInteger (del paquetejava.lang) que recibe un argumento String que represen
ta a un entero y devuelve el valor comoint. Si el objetoStringno contiene un entero válido, el programa terminará 
con un error.
*/

//Figura2.7 Suma
//Programa que recibe dos numeros y muestra la suma

//import java.util.Scanner;
import javax.swing.JOptionPane;

public class Suma {
	public static void main ( String args [] ){
		//Scanner entrada = new Scanner (System.in);
		String n1,n2;
		Integer numero1, numero2, suma;
		
		//System.out.print("Escriba el primer entero->");
		//numero1 = entrada.nextInt();
		n1 = JOptionPane.showInputDialog("Escriba el primer entero ");
		
		//System.out.print("Escriba el segundo entero->");
		//numero2 = entrada.nextInt();
		n2 = JOptionPane.showInputDialog("Escriba el segundo entero ");
		
		numero1 = Integer.parseInt(n1);
		numero2 = Integer.parseInt(n2);
		
		//Integer.parseInt(String s1), convierte el string s1 en un Integer siempre q se pueda
		
		suma = numero1+numero2;
		//System.out.printf("La suma es %d%n",suma);
		
		String mensaje = String.format("La suma es %d",suma);
		
		JOptionPane.showMessageDialog(null, mensaje);
	}
}