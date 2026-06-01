/*

  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP6-U5
  
  Ejercicio4-ED AUXILIAR

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
---------------------------------------
*/
public class Grafo {
    // Nodo para la lista enlazada (sin usar LinkedList de la API)
    public static class Arista {
        int destino;
        int peso;
        Arista siguiente;
        
        public Arista(int destino, int peso, Arista siguiente) { 
            this.destino = destino; 
            this.peso = peso; 
            this.siguiente = siguiente; 
        }
    }

    private int V;
    private int E;
    private boolean dirigido;
    public Arista[] adyacencia; // Arreglo de listas enlazadas

    public Grafo(int V, boolean dirigido) {
        this.V = V;
        this.dirigido = dirigido;
        this.E = 0;
        this.adyacencia = new Arista[V]; // Inicializa en null
    }

    public void agregarArista(int u, int v, int peso) {
        // Insertar al inicio de la lista enlazada
        adyacencia[u] = new Arista(v, peso, adyacencia[u]);
        E++;
        if (!dirigido) {
            adyacencia[v] = new Arista(u, peso, adyacencia[v]);
        }
    }

    public int getV() { return V; }
    public boolean isDirigido() { return dirigido; }
}