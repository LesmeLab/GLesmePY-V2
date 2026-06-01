/*
  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP5-U3
  
  Ejercicio3_itemB

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
*/

/*
EJERCICIO 3.B)
Implemente en Java un algoritmo RadixSort que pueda ordenar cadenas alfabéticas (base 26) basado el 
algoritmo de a).  
*/

public class Ejercicio3_itemB {
    public static void radixSortStrings(String[] arr) {
        int n = arr.length;
        if (n == 0) return;

        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].length() > maxLen) {
                maxLen = arr[i].length();
            }
        }

        
        String[][] colas = new String[27][n];

        for (int iter = maxLen - 1; iter >= 0; iter--) {
            int[] cont = new int[27]; 

            for (int i = 0; i < n; i++) {
                String s = arr[i];
                int digito;
                if (iter >= s.length()) {
                    digito = 0; 
                } else {
                    char c = s.charAt(iter);
                    
                    if (c >= 'A' && c <= 'Z') {
                        c = (char) (c + 32); 
                    }
                    digito = c - 'a' + 1; 
                }
                
                colas[digito][cont[digito]] = s;
                cont[digito]++;
            }

            int idx = 0;
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < cont[i]; j++) {
                    arr[idx++] = colas[i][j];
                }
            }
        }
    }
}