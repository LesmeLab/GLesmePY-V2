/*
Figura 4.18 - PanelDibujo
Uso de drawLine para conectar las esquinas de un panel
*/

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		//super es
		int anchura = getWidth();
		int altura = getHeight();
		
		//dibuja una linea de la esquina sup izq a la esquina inf der
		g.drawLine(0,0,anchura,altura);
		
		//dibuja una linea de la esquina inf izq a la esquina sup der
		g.drawLine(0,altura,anchura,0);
		
	}
}