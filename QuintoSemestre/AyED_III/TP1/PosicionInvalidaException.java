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
 * PosicionInvalidaException es una EXCEPCIÓN NO CHEQUEADA (extiende RuntimeException)
 * porque un acceso fuera de límites representa un fallo de programación (bug) en el
 * código cliente. No debe ser capturada operativamente, sino corregida en el desarrollo.
 */
public class PosicionInvalidaException extends RuntimeException {
    public PosicionInvalidaException(String msj) {
        super(msj);
    }
}