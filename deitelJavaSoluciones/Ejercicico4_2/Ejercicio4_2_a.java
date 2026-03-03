/*
/*
Ejercicio 4.2. 
 La figura 4.21 muestra dos diseños adicionales, creados mediante el uso de
ciclos while y de drawLine. 
a)  
Cree el diseño de la captura de pantalla izquierda de la figura 4.21. 
Empiece por dividir cada borde en un número equivalente de incrementos
(elegimos 15 de nuevo). La primera línea empieza en la esquina superior 
izquierda y termina un paso a la derecha, en el borde inferior. 
Para cada línea sucesiva, avance hacia abajo un incremento en el borde 
izquierdo, y un incremento a la derecha en el borde inferior.
Continúe dibujando líneas hasta llegar a la esquina inferior derecha. 
La figura deberá escalarse a medida que usted cambie el tamaño de la ventana,
de manera que los puntos finales siempre toquen los bordes
*/

import javax.swing.JFrame;

public class Ejercicio4_2_a {
	public static void main (String [] args){
		PanelDibujo_a panel = new PanelDibujo_a();
		
		JFrame aplicacion = new JFrame ();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(500,500);
		aplicacion.setVisible(true);
	}
}