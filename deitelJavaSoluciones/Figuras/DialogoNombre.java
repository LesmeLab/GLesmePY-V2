//Figura 3.13 -> DialogoNombre
//Entrada basica con un cuadro de dialogo

import javax.swing.JOptionPane;

public class DialogoNombre {
	public static void main ( String args [] ){
		//pide el nombre su nombre
		String nombre = JOptionPane.showInputDialog("Cual es su nombre?");
		
		//crea el mensaje
		String mensaje = String.format("Bienvenido, %s, a la programacion en Java",nombre);
		//.format devuelve un objeto String
		
		//muestra el mensaje para dar la bienvenida al usuario por su nombre
		JOptionPane.showMessageDialog(null, mensaje);
	}
}