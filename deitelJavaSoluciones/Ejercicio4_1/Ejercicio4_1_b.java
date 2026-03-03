/*
Ejercicio de caso de Estudio de GUI y graficos
4.1. Al utilizar ciclos e instrucciones de control para dibujar lineas se
pueden lograr muchos design interesantes.
b)Modifique su respuesta en la parte (a) para hacer que las líneas se 
desplieguen a partir de las cuatro esquinas, como se muestra en la captura 
de pantalla derecha de la figura 4.20. Las líneas de esquinas
opuestas deberán intersecarse a lo largo de la parte media.

*/



import javax.swing.JFrame;

public class Ejercicio4_1_b {
	public static void main (String [] args){
		PanelDibujo2 panel = new PanelDibujo2();
		
		JFrame aplicacion = new JFrame ();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(500,500);
		aplicacion.setVisible(true);
	}
}