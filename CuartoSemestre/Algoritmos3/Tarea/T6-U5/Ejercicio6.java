/*

  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP6-U5
  
  Ejercicio6

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
---------------------------------------
*/

public class Ejercicio6 {
    // Clase interna para lista de enteros dinámica
    static class IntList {
        int[] data = new int[100];
        int size = 0;
        void add(int v) {
            if (size == data.length) {
                int[] newData = new int[data.length * 2];
                for(int i=0; i<size; i++) newData[i] = data[i];
                data = newData;
            }
            data[size++] = v;
        }
        boolean contains(int v) {
            for(int i=0; i<size; i++) if (data[i] == v) return true;
            return false;
        }
    }

    public static void buscarAtrapados(Grafo g, int inicio) {
        boolean[] visitado = new boolean[g.getV()];
        boolean[] enPila = new boolean[g.getV()];
        IntList islasAtrapadas = new IntList();
        
        try {
            dfs(g, inicio, visitado, enPila, islasAtrapadas);
            for(int i=0; i < islasAtrapadas.size; i++) {
                System.out.print(islasAtrapadas.data[i] + " ");
            }
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dfs(Grafo g, int u, boolean[] visitado, boolean[] enPila, IntList islasAtrapadas) {
        visitado[u] = true;
        enPila[u] = true;
        
        boolean esSumidero = true;
        Grafo.Arista actual = g.adyacencia[u];
        
        while (actual != null) {
            esSumidero = false;
            int v = actual.destino;
            if (!visitado[v]) {
                dfs(g, v, visitado, enPila, islasAtrapadas);
            } else if (enPila[v]) {
                throw new RuntimeException("Excepción: Se detectó un ciclo.");
            }
            actual = actual.siguiente;
        }
        
        if (esSumidero) {
            if (!islasAtrapadas.contains(u)) islasAtrapadas.add(u);
        }
        enPila[u] = false;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(5, true);
        g.agregarArista(1, 3, 1);
        g.agregarArista(1, 0, 1);
        g.agregarArista(2, 4, 1);
        g.agregarArista(0, 2, 1);
        buscarAtrapados(g, 1); 
    }
}