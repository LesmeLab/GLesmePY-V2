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

public class ComandoBorrar implements Comando {
    private BufferGap<Character> buffer;
    private Character caracterBorrado;

    public ComandoBorrar(BufferGap<Character> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void ejecutar() {
        try {
            this.caracterBorrado = buffer.borrar();
        } catch (BufferVacioException e) {
            this.caracterBorrado = null;
        }
    }

    @Override
    public void deshacer() {
        if (caracterBorrado != null) {
            buffer.insertar(caracterBorrado);
        }
    }

    @Override
    public String descripcion() {
        return "Borrar()";
    }
}