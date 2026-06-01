/*

  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP6-U5
  
  Ejercicio7

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
---------------------------------------
*/

public class Ejercicio7 {
    
    // Cola personalizada usando arreglo
    static class MiCola {
        int[] arr;
        int head = 0, tail = 0;
        public MiCola(int size) { arr = new int[size]; }
        public void enqueue(int v) { arr[tail++] = v; }
        public int dequeue() { return arr[head++]; }
        public boolean isEmpty() { return head == tail; }
    }

    static class IntList {
        int[] data = new int[100];
        int size = 0;
        void add(int v) { data[size++] = v; }
    }

    public static void analizarBipartito(Grafo g) {
        int V = g.getV();
        int[] colores = new int[V];
        for(int i=0; i<V; i++) colores[i] = -1;
        
        IntList V1 = new IntList();
        IntList V2 = new IntList();
        boolean esBipartito = true;

        for (int i = 0; i < V; i++) {
            if (colores[i] == -1) {
                MiCola q = new MiCola(V);
                q.enqueue(i);
                colores[i] = 0;
                V1.add(i);

                while (!q.isEmpty()) {
                    int u = q.dequeue();
                    Grafo.Arista arista = g.adyacencia[u];
                    
                    while (arista != null) {
                        int v = arista.destino;
                        if (colores[v] == -1) {
                            colores[v] = 1 - colores[u];
                            if (colores[v] == 0) V1.add(v);
                            else V2.add(v);
                            q.enqueue(v);
                        } else if (colores[v] == colores[u]) {
                            esBipartito = false;
                        }
                        arista = arista.siguiente;
                    }
                }
            }
        }

        if (esBipartito) {
            System.out.println("El grafo es Bipartito.");
            System.out.print("V1: ");
            for(int i=0; i<V1.size; i++) System.out.print(V1.data[i] + " ");
            System.out.print("\nV2: ");
            for(int i=0; i<V2.size; i++) System.out.print(V2.data[i] + " ");
            System.out.println();
            
            // Verificar si es completo
            int aristasTotales = 0;
            for(int i = 0; i < V; i++) {
                Grafo.Arista a = g.adyacencia[i];
                while(a != null) {
                    aristasTotales++;
                    a = a.siguiente;
                }
            }
            if (!g.isDirigido()) aristasTotales /= 2;
            
            if (aristasTotales == V1.size * V2.size) {
                System.out.println("Además, es un grafo Bipartito COMPLETO.");
            } else {
                System.out.println("Es bipartito, pero NO es completo.");
            }
        } else {
            System.out.println("El grafo NO es bipartito.");
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(4, false);
        g.agregarArista(0, 2, 1);
        g.agregarArista(0, 3, 1);
        g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 1);
        analizarBipartito(g);
    }
}