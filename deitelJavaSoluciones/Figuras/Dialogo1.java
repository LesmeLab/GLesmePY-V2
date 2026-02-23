//Figura 3.12 ->Dialogo1
//Uso de JOptionPane para mostrar varias lineas en un cuadro de dialogo

import javax.swing.JOptionPane;
//javax contiene muchas clases que le ayudan a crear GUI

public class Dialogo1 {
	public static void main ( String args [] ){
		//muestra un dialogo con un mensaje
		JOptionPane.showMessageDialog(null,"Bienvenido a Java");
		//showMessageDialog (arg1,arg2)
		//arg1 es la posicion del cuadro, null para el centro de la pantalla
		//arg2 es el objeto String a mostrar en el cuadro de dialogo
		
		
		//la llamada a un metodo static se realiza mediante el uso del nombre de su clase, seguido de un punto y el nombre del metodo
		//NombreClase.nombreMetodo(argumentos)
	}
}