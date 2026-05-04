/*
 *g37
 *Integrante:
   Gustavo Emanuel Lesme Ortega       CIC: 5249373   Sección: TR
   Gustavo Ibars  6535995 TR
  TP 4-U3
  Ejercicio 1
  
  Declaración de honor 
    • Yo Gustavo Emanuel Lesme Ortega
    • No he/hemos discutido el código fuente de mi/nuestra tarea con ningún otro grupo, solo con el Profesor o el AER.
    • No he/hemos usado código obtenido de otro estudiante o de cualquier otra fuente no autorizada, modificada o no modificada.
    • Cualquier código o documentación utilizada en mi/nuestro programa obtenido de fuentes, tales como libros o notas de curso, 
	   han sido claramente indicada en mi/nuestra tarea.

 * ATENCIÓN: 
 * Plataforma IA utilizada: Gemini (https://gemini.google.com)
 * Modelo: Gemini 3.1 Pro
 * Prompt utilizado: El texto completo del trabajo práctico (TP4-U3.pdf) pidiendo una modificacion a una solución dada por 
	el usuario sin API de colecciones de Java.
 * Cambios introducidos: Código estructurado en un solo archivo para compilar desde consola, con generación de CSV para análisis externo.
 *
 **********COMENTARIOS***********
 *Comentarios en archivo graficos.pdf
 ********************************
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {
        int[] R_values = {31, 37, 32, 64};
        int numFranjas = 1000;
        
        // Matrices de frecuencias: [indice_R][franja]
        int[][] frecEsquemaSalto = new int[R_values.length][numFranjas];
        int[][] frecEsquemaTodos = new int[R_values.length][numFranjas];

        try (BufferedReader br = new BufferedReader(new FileReader("la.dic"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Considerar solo la palabra descartando desde el caracter "/" 
                String word = line.split("/")[0];
                
                for (int i = 0; i < R_values.length; i++) {
                    int R = R_values[i];
                    
                    // 1. Esquema 2^k - 1 (saltando caracteres) 
                    long hash_value_salto = 0;
                    for (int k = 1; k < word.length(); k *= 2) {
                        hash_value_salto = hash_value_salto * R + word.charAt(k - 1);
                    }
                    int franjaSalto = Math.abs((int) (hash_value_salto % numFranjas));
                    frecEsquemaSalto[i][franjaSalto]++;
                    
                    // 2. Esquema con todos los caracteres 
                    long hash_value_todos = 0;
                    for (int j = 0; j < word.length(); j++) {
                        hash_value_todos = hash_value_todos * R + word.charAt(j);
                    }
                    int franjaTodos = Math.abs((int) (hash_value_todos % numFranjas));
                    frecEsquemaTodos[i][franjaTodos]++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo la.dic. Asegurese de que este en el mismo directorio.");
            return;
        }

        // Generar archivo de datos CSV para graficar [cite: 15]
        try (FileWriter writer = new FileWriter("frecuencias_ej1.csv")) {
            writer.write("Franja,R31_Salto,R31_Todos,R37_Salto,R37_Todos,R32_Salto,R32_Todos,R64_Salto,R64_Todos\n");
            for (int f = 0; f < numFranjas; f++) {
                writer.write(f + ",");
                writer.write(frecEsquemaSalto[0][f] + "," + frecEsquemaTodos[0][f] + ",");
                writer.write(frecEsquemaSalto[1][f] + "," + frecEsquemaTodos[1][f] + ",");
                writer.write(frecEsquemaSalto[2][f] + "," + frecEsquemaTodos[2][f] + ",");
                writer.write(frecEsquemaSalto[3][f] + "," + frecEsquemaTodos[3][f] + "\n");
            }
            System.out.println("Archivo 'frecuencias_ej1.csv' generado exitosamente. Importelo en Excel para graficar.");
        } catch (IOException e) {
            System.out.println("Error escribiendo resultados.");
        }
    }
}