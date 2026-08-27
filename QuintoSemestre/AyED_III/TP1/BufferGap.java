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

import java.util.Iterator;

public class BufferGap<E> implements Iterable<E> {
    private static final int TAM_INICIAL = 16;
    private E[] datos;
    private int inicioHueco;
    private int finHueco;
    private long desplazamientos;

    @SuppressWarnings("unchecked")
    public BufferGap() {
        this.datos = (E[]) new Object[TAM_INICIAL];
        this.inicioHueco = 0;
        this.finHueco = TAM_INICIAL;
        this.desplazamientos = 0;
    }

    public void insertar(E obj) {
        if (inicioHueco == finHueco) {
            crecer();
        }
        datos[inicioHueco] = obj;
        inicioHueco++;
    }

    public E borrar() throws BufferVacioException {
        if (inicioHueco == 0) {
            throw new BufferVacioException("No se puede borrar: el cursor está en el inicio.");
        }
        inicioHueco--;
        E borrado = datos[inicioHueco];
        datos[inicioHueco] = null;
        return borrado;
    }

    public void moverCursor(int delta) {
        int nuevaPos = inicioHueco + delta;
        if (nuevaPos < 0 || nuevaPos > size()) {
            throw new PosicionInvalidaException("Posición fuera de rango: " + nuevaPos);
        }

        while (inicioHueco > nuevaPos) {
            inicioHueco--;
            finHueco--;
            datos[finHueco] = datos[inicioHueco];
            datos[inicioHueco] = null;
            desplazamientos++;
        }

        while (inicioHueco < nuevaPos) {
            datos[inicioHueco] = datos[finHueco];
            datos[finHueco] = null;
            inicioHueco++;
            finHueco++;
            desplazamientos++;
        }
    }

    public int posicionCursor() {
        return inicioHueco;
    }

    public int finHueco() {
        return finHueco;
    }

    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new PosicionInvalidaException("Índice fuera de rango: " + index);
        }
        return (index < inicioHueco) ? datos[index] : datos[index + (finHueco - inicioHueco)];
    }

    public E set(E obj, int index) {
        if (index < 0 || index >= size()) {
            throw new PosicionInvalidaException("Índice fuera de rango: " + index);
        }
        int idxFisico = (index < inicioHueco) ? index : index + (finHueco - inicioHueco);
        E anterior = datos[idxFisico];
        datos[idxFisico] = obj;
        return anterior;
    }

    public int size() {
        return datos.length - (finHueco - inicioHueco);
    }

    public int capacidad() {
        return datos.length;
    }

    public long desplazamientos() {
        return desplazamientos;
    }

    public void reiniciarDesplazamientos() {
        this.desplazamientos = 0;
    }

    /*
     * JUSTIFICACIÓN DE DISEÑO EN DUPLICACIÓN DE CAPACIDAD:
     * Al duplicar, el nuevo espacio libre se asigna inmediatamente en la posición del cursor (finHueco actual).
     * Esto maximiza la eficiencia ya que la mayoría de las inserciones ocurren de forma consecutiva
     * en la posición actual de edición, evitando mover los elementos de la derecha en futuras inserciones.
     */
    @SuppressWarnings("unchecked")
    private void crecer() {
        int nuevaCapacidad = datos.length * 2;
        E[] nuevosDatos = (E[]) new Object[nuevaCapacidad];

        for (int i = 0; i < inicioHueco; i++) {
            nuevosDatos[i] = datos[i];
            desplazamientos++;
        }

        int elementosDerecha = datos.length - finHueco;
        int nuevoFinHueco = nuevaCapacidad - elementosDerecha;

        for (int i = 0; i < elementosDerecha; i++) {
            nuevosDatos[nuevoFinHueco + i] = datos[finHueco + i];
            desplazamientos++;
        }

        this.datos = nuevosDatos;
        this.finHueco = nuevoFinHueco;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursorLogico = 0;

            @Override
            public boolean hasNext() {
                return cursorLogico < size();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new PosicionInvalidaException("No hay más elementos.");
                }
                E elem = get(cursorLogico);
                cursorLogico++;
                return elem;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            if (i == inicioHueco) {
                sb.append("|");
            }
            sb.append(get(i));
        }
        if (inicioHueco == size()) {
            sb.append("|");
        }
        return sb.toString();
    }
}