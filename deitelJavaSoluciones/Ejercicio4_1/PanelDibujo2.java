/*
Ejercicio de caso de Estudio de GUI y graficos
4.1. Al utilizar ciclos e instrucciones de control para dibujar lineas se
pueden lograr muchos design interesantes.
b)Modifique su respuesta en la parte (a) para hacer que las líneas se 
desplieguen a partir de las cuatro esquinas, como se muestra en la captura 
de pantalla derecha de la figura 4.20. Las líneas de esquinas
opuestas deberán intersecarse a lo largo de la parte media.

*/
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo2 extends JPanel{
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		int anchura = getWidth();
		int altura = getHeight();
		
		//sup izq
		int x = 0;
		while (altura-x > 0){
			g.drawLine(0,0,x,-x+altura);
			x=x+15;
			//x=x+15*(altura/100);
		}
		
		//inf der
		x = 0;
		while (altura-x > 0){
			g.drawLine(anchura,altura,x,-x+altura);
			x+=15;
			//x=x+15*(altura/100);
		}
		
		//sup der
		x = 0;
		while (altura-x > 0){
			g.drawLine(anchura,0,altura-x,-x+altura);
			x+=15;
			//x=x+15*(altura/100);
		}
		
		//inf izq
		x = 0;
		while (altura-x > 0){
			g.drawLine(0,altura,altura-x,-x+altura);
			x+=15;
			//x=x+15*(altura/100);
		}
	}
	
	//Se adjunta imagen Adjunto2 
}