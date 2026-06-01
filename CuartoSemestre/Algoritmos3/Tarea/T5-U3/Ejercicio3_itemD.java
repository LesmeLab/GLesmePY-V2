/*
  g37
  Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
  TP5-U3
  
  Ejercicio3_itemD

  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.
*/

/*
EJERCICIO 3,ITEM D

Ventaja sobre el ítem a): 
	La versión en SL preasigna vectores fijos de tamaño 1500 (vector [1500] numerico) para 
		almacenar temporalmente los elementos. Esto es sumamente ineficiente a nivel de 
		memoria y propenso a errores de ejecución (desbordamiento) si la distribución de 
		los dígitos agrupa más de 1500 elementos en una sola cubeta. 
		En contraste, la versión implementada con Counting Sort computa previamente las 
		frecuencias de los dígitos, lo que permite determinar y asignar exactamente la 
		cantidad de posiciones necesarias en el arreglo de salida (output), sin requerir 
		espacio extra innecesario y sin estar limitada por constantes de tamaño estáticas.
*/

public class Ejercicio3_itemD {
    public static void radixSortConCounting(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(arr, exp);
        }
    }

    private static void countingSortPorDigito(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; 

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            output[count[digito] - 1] = arr[i];
            count[digito]--;
 
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}