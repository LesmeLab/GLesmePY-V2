/*
Figura 4.19 - PruebaPanelDibujo
Crear un objeto JFrame para mostrar un objeto PanelDibujo
*/

import javax.swing.JFrame;

public class PruebaPanelDibujo {
	public static void main ( String [] args ){
		PanelDibujo panel = new PanelDibujo();
		
		JFrame aplicacion = new JFrame();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aplicacion.add(panel);
		aplicacion.setSize(250,250);
		aplicacion.setVisible(true);
	}
}