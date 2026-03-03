/*
Ejercicio de caso de Estudio de GUI y graficos
4.1. Al utilizar ciclos e instrucciones de control para dibujar lineas se
pueden lograr muchos design interesantes.

a) 
Cree el diseño que se muestra en la captura de pantalla izquierda de la figura
4.20. Este diseño dibuja líneas que parten desde la esquina superior izquierda
, y se despliegan hasta cubrir la mitad superior izquierda del panel. 
Un método es dividir la anchura y la altura en un número equivalente de pasos 
(nosotros descubrimos que 15 pasos es una buena cantidad). 
El primer punto final de una línea siempre estará en la esquina superior 
izquierda (0,0). El segundo punto final puede encontrarse partiendo desde la
esquina inferior izquierda, y avanzando un paso vertical hacia arriba, y uno 
horizontal hacia la derecha. Dibuje una línea entre los dos puntos finales. 
Continúe avanzando un paso hacia arriba y a la derecha, para encontrar cada 
punto final sucesivo. La figura deberá escalarse de manera apropiada 
conforme usted cambie el tamaño de la ventana.
*/

import javax.swing.JFrame;

public class Ejercicio4_1_a {
	public static void main (String [] args){
		PanelDibujo panel = new PanelDibujo();
		
		JFrame aplicacion = new JFrame ();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(500,500);
		aplicacion.setVisible(true);
	}
}