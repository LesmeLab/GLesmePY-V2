/*

  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP6-U5
  
  Ejercicio5

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
---------------------------------------
*/

public class Ejercicio5 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        // Matriz de prueba (Hardcodeada para evitar usar java.io/Scanner)
        char[][] grid = {
            {'.', '.', '#', '#'},
            {'#', '.', '#', '.'},
            {'#', '#', '#', '.'}
        };
        resolverMatriz(grid);
    }

    public static void resolverMatriz(char[][] grid) {
        int filas = grid.length;
        if (filas == 0) return;
        int cols = grid[0].length;
        
        boolean[][] visitado = new boolean[filas][cols];
        
        // Estructura para guardar resultados (tipo ArrayList custom)
        int[] areas = new int[filas * cols]; 
        int totalAreas = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '.' && !visitado[i][j]) {
                    areas[totalAreas++] = dfs(grid, visitado, i, j, filas, cols);
                }
            }
        }

        System.out.println(totalAreas);
        for (int i = 0; i < totalAreas; i++) {
            System.out.println(areas[i]);
        }
    }

    private static int dfs(char[][] grid, boolean[][] visitado, int x, int y, int filas, int cols) {
        visitado[x][y] = true;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < filas && ny >= 0 && ny < cols && grid[nx][ny] == '.' && !visitado[nx][ny]) {
                area += dfs(grid, visitado, nx, ny, filas, cols);
            }
        }
        return area;
    }
}