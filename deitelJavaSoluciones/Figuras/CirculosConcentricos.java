/*
Ejercicio 5.1.
	Dibuje 12 círculos concéntricos en el centro de un objetoJPanel (figura 5.29). 
	El círculo más interno debe tener un radio de 10 píxeles, y cada círculo sucesivo 
	debe contar con un radio 10 píxeles mayor que el anterior. 
	Empiece por buscar el centro del objeto JPanel. 
	Para obtener la esquina superior izquierda de un círculo, 
	avance un radio hacia arriba y un radio a la izquierda, 
	partiendo del centro. 
	La anchura y la altura del rectángulo delimitador es el diámetro del 
	círculo (el doble del radio).
*/

import java.awt.Graphics;
import javax.swing.JPanel;



public class CirculosConcentricos extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (int i = 0; i <10; i++){
			g.drawOval(i*25,i*25,600-2*i*25,600-2*i*25);
		}
	}
	
}

/*
drawOval(i*25,i*25,600-2*i*25,600-2*i*25)
el 2 viene por que se resta lo que se quito de arriba y lo de abajo. 
Similar para izquierda y derecha.
*/