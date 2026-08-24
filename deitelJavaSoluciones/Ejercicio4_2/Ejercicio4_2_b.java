/*
Ejercicio 4.2. 
 La figura 4.21 muestra dos diseños adicionales, creados mediante el uso de
ciclos while y de drawLine. 
b)  
Modifique su respuesta en la parte (a) para reflejar el diseño en las cuatro esquinas, como se muestra en 
la captura de pantalla derecha de la figura 4.21.
*/

import javax.swing.JFrame;

public class Ejercicio4_2_b {
	public static void main (String [] args){
		PanelDibujo_b panel = new PanelDibujo_b();
		
		JFrame aplicacion = new JFrame ();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(500,500);
		aplicacion.setVisible(true);
	}
}