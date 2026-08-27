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

public class PilaES<E> {
    
    private static class Nodo<E> {
        private E dato;
        private Nodo<E> siguiente;

        public Nodo(E dato, Nodo<E> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private Nodo<E> topeNodo;
    private int cantidad;

    public PilaES() {
        this.topeNodo = null;
        this.cantidad = 0;
    }

    public void apilar(E elem) {
        topeNodo = new Nodo<>(elem, topeNodo);
        cantidad++;
    }

    public E desapilar() {
        if (estavacia()) {
            throw new PosicionInvalidaException("No se puede desapilar de una pila vacía.");
        }
        E dato = topeNodo.dato;
        topeNodo = topeNodo.siguiente;
        cantidad--;
        return dato;
    }

    public E tope() {
        if (estavacia()) {
            throw new PosicionInvalidaException("La pila está vacía.");
        }
        return topeNodo.dato;
    }

    public boolean estavacia() {
        return cantidad == 0;
    }

    public int size() {
        return cantidad;
    }

    public void vaciar() {
        this.topeNodo = null;
        this.cantidad = 0;
    }
}