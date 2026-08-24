
public class PruebaEstudiante{
	public static void main(String[] args){
		Estudiante cuenta1 = new Estudiante("J.G", 93.5);
		Estudiante cuenta2 = new Estudiante("J.B", 72.75);
		
		System.out.printf("Calificacion de %s es %s%n", cuenta1.obtenerNombre(), cuenta1.obtenerCalificacionEstudiante());
		System.out.printf("Calificacion de %s es %s%n", cuenta2.obtenerNombre(), cuenta2.obtenerCalificacionEstudiante());
	}
}