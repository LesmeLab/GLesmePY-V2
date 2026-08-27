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


public class ArregloSimple<E> {
    private E[] datos;
    private int size;
    private long desplazamientos;

    @SuppressWarnings("unchecked")
    public ArregloSimple(int cap) {
        this.datos = (E[]) new Object[cap];
        this.size = 0;
        this.desplazamientos = 0;
    }

    public void insertar(int pos, E elem) {
        if (size == datos.length) {
            crecer();
        }
        for (int i = size; i > pos; i--) {
            datos[i] = datos[i - 1];
            desplazamientos++;
        }
        datos[pos] = elem;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void crecer() {
        E[] nuevos = (E[]) new Object[datos.length * 2];
        for (int i = 0; i < datos.length; i++) {
            nuevos[i] = datos[i];
            desplazamientos++;
        }
        datos = nuevos;
    }

    public long desplazamientos() {
        return desplazamientos;
    }

    public void reiniciarDesplazamientos() {
        desplazamientos = 0;
    }
}