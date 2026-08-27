/*
 * Grupo: g_tq12-TP1
 * Integrante: Lesme Ortega, Gustavo Emanuel, 5249373, TQ
 * Declaración de Honor:
 *		Yo Gustavo Emanuel Lesme Ortega
 * 		No he/hemos discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
 * 		No he/hemos usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
 * 		Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, han sido claramente indicada en mi/nuestra tarea.
 *
 */

/*
 * BufferVacioException es una EXCEPCIÓN CHEQUEADA (extiende Exception) porque
 * borrar sobre un buffer vacío representa una condición previsible del uso normal
 * de una aplicación interactiva (por ejemplo, el usuario presiona Backspace al inicio
 * del archivo). El código cliente debe obligatoriamente anticiparla y gestionarla.
 */
public class BufferVacioException extends Exception {
    public BufferVacioException(String msj) {
        super(msj);
    }
}