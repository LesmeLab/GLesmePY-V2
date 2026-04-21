import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PruebaCirculosConcentricos {
	public static void main (String [] args){
		CirculosConcentricos panel = new CirculosConcentricos();
		
		JFrame aplicacion = new JFrame();
		
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacion.add(panel);
		aplicacion.setSize(300,300);
		aplicacion.setVisible(true);
	}
}