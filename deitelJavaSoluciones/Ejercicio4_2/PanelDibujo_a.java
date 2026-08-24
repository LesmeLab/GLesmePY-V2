/*
4.2. 
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

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo_a extends JPanel {
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		int anchura = getWidth();
		int altura = getHeight();
		
		int x = 0;
		while (x<altura){
			g.drawLine(0,x,x,altura);
			x+=15;
		}
	}
}