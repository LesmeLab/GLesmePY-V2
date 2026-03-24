//Figura 5.27 Figuras
//Como dibujar una cascada de figuras con base en la eleccion del usuario

import java.awt.Graphics;
import javax.swing.JPanel;

public class Figuras extends JPanel{
	private int opcion; //opcion del usuario acerca del cual figura dibujar
	
	public Figuras(int opcionUsuario){
		opcion = opcionUsuario;
	}
	
	//dibuja una cascada de figuras, empezando desde la esquina superior izquierda
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (int i = 0; i < 10; i++){
			//elige la figura con base en la opcion del usuario
			switch(opcion){
				case 1: //dibuja rectangulos
					g.drawRect(10+i*10, 10+i*10, 50+i*10, 50+i*10);
					break;
					
				case 2: //dibuja ovalos
					g.drawOval(10+i*10, 10+i*10, 50+i*10, 50+i*10);
					break;
			}
		}
	}
}

/*
g.drawRect(x_esquinaSuperiorIzq,y_esquinaSuperiorIzq,anchura,altura)

g.drawOval(x_esquinaSuperiorIzq,y_esquinaSuperiorIzq,anchura,altura)
crea un rectangulo imaginario llamado rectangulo delimitador, y dentro de ese
rectangulo se crea un ovalo que toca los puntos medios de los cuatro lados.
*/