/*
Ejercicio 4.2. 
 La figura 4.21 muestra dos diseños adicionales, creados mediante el uso de
ciclos while y de drawLine.
b)  
Modifique su respuesta en la parte (a) para reflejar el diseño en las 
cuatro esquinas, como se muestra en la captura de pantalla derecha de 
la figura 4.21.
*/

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo_b extends JPanel {
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		int anchura = getWidth();
		int altura = getHeight();
		
		//inf izq
		int x = 0;
		while (x<altura){
			g.drawLine(0,x,x,altura);
			x+=15;
		}
		
		//sup izq
		x = 0;
		while (x<altura){
			g.drawLine(x,0,0,altura-x);
			x+=15;
		}
		
		//sup der
		x = 0;
		while (x<altura){
			g.drawLine(x,0,anchura,x);
			x+=15;
		}
		
		//inf der
		x = 0;
		while (x<altura){
			g.drawLine(x,altura,anchura,altura-x);
			x+=15;
		}
		
		//
	}
}