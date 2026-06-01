/*

  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP6-U5
  
  Ejercicio4

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
---------------------------------------
*/

public class Ejercicio4 {
    public static void encontrarCicloMasCorto(Grafo g, int s) {
        int V = g.getV();
        int[] dist = new int[V];
        int[] padre = new int[V];
        boolean[] visitado = new boolean[V];
        
        int INF = 2000000000; // Simula infinito
        for(int i = 0; i < V; i++) {
            dist[i] = INF;
            padre[i] = -1;
        }

        // Inicializar con los adyacentes a 's' para buscar el ciclo de regreso
        Grafo.Arista actual = g.adyacencia[s];
        while(actual != null) {
            dist[actual.destino] = actual.peso;
            padre[actual.destino] = s;
            actual = actual.siguiente;
        }
        
        boolean cicloEncontrado = false;

        // Dijkstra en O(V^2) sin API
        for (int i = 0; i < V; i++) {
            int u = -1;
            int minDist = INF;
            for (int j = 0; j < V; j++) {
                if (!visitado[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1) break;
            if (u == s) {
                cicloEncontrado = true;
                break;
            }

            visitado[u] = true;

            Grafo.Arista arista = g.adyacencia[u];
            while (arista != null) {
                int v = arista.destino;
                if (dist[u] + arista.peso < dist[v]) {
                    dist[v] = dist[u] + arista.peso;
                    padre[v] = u;
                }
                arista = arista.siguiente;
            }
        }

        if (cicloEncontrado && dist[s] != INF) {
            System.out.println("Costo del ciclo más corto: " + dist[s]);
            // Reconstruir camino sin ArrayList
            int[] camino = new int[V + 1];
            int idx = 0;
            int curr = s;
            do {
                camino[idx++] = curr;
                curr = padre[curr];
            } while (curr != s && curr != -1);
            camino[idx++] = s;

            System.out.print("Ciclo: ");
            for (int i = idx - 1; i >= 0; i--) {
                System.out.print((char)(camino[i] + 'A') + (i == 0 ? "" : "-"));
            }
            System.out.println();
        } else {
            System.out.println("No existe ciclo en el grafo que contenga al vértice.");
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(5, true);
        g.agregarArista(0, 1, 2); g.agregarArista(1, 2, 1);
        g.agregarArista(1, 3, 5); g.agregarArista(2, 3, 3);
        g.agregarArista(2, 4, 7); g.agregarArista(3, 0, 8);
        g.agregarArista(3, 4, 6); g.agregarArista(4, 0, 4);
        encontrarCicloMasCorto(g, 3); // Para D (3)
    }
}