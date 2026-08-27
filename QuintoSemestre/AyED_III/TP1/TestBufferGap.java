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

import java.util.Random;

public class TestBufferGap {
    public static void main(String[] args) throws Exception {
        System.out.println("=== 1. TRAZA FASE A Y FASE B ===");
        BufferGap<Character> buffer = new BufferGap<>();
        imprimirEstado("Inicial", buffer);

        buffer.insertar('H'); imprimirEstado("insertar('H')", buffer);
        buffer.insertar('o'); imprimirEstado("insertar('o')", buffer);
        buffer.insertar('l'); imprimirEstado("insertar('l')", buffer);
        buffer.insertar('a'); imprimirEstado("insertar('a')", buffer);

        buffer.moverCursor(-2); imprimirEstado("moverCursor(-2)", buffer);
        buffer.insertar('X'); imprimirEstado("insertar('X')", buffer);
        buffer.get(4); imprimirEstado("get(4)", buffer);
        buffer.borrar(); imprimirEstado("borrar()", buffer);

        System.out.println("\n=== 2. VERIFICACIÓN ITERADOR (100.000 ELEMENTOS) ===");
        BufferGap<Character> bGran = new BufferGap<>();
        Random rand = new Random(42);
        for (int i = 0; i < 100000; i++) {
            bGran.insertar((char) ('a' + (i % 26)));
        }
        int cont = 0;
        for (Character c : bGran) {
            cont++;
        }
        System.out.println("Elementos recorridos con for-each: " + cont + " (Esperado: 100000)");

        System.out.println("\n=== 3. COMPARATIVA DE DESPLAZAMIENTOS EN EL MEDIO ===");
        int[] tamaños = {100000, 200000, 1000000};
        System.out.printf("%-10s | %-22s | %-25s%n", "N", "Desplazamientos BufferGap", "Desplazamientos Arreglo Simple");
        System.out.println("----------------------------------------------------------------------");

        for (int n : tamaños) {
            BufferGap<Character> bg = new BufferGap<>();
            ArregloSimple<Character> as = new ArregloSimple<>(16);

            for (int i = 0; i < n; i++) {
                bg.insertar('a');
                as.insertar(i, 'a');
            }

            bg.moverCursor(-(n / 2));
            bg.reiniciarDesplazamientos();
            as.reiniciarDesplazamientos();

            for (int i = 0; i < 10000; i++) {
                bg.insertar('X');
                as.insertar(n / 2 + i, 'X');
            }

            System.out.printf("%-10d | %-22d | %-25d%n", n, bg.desplazamientos(), as.desplazamientos());
        }
    }

    private static void imprimirEstado(String op, BufferGap<Character> b) {
        System.out.printf("%-18s -> %-8s | Cap: %-2d | Despl: %d%n", op, b.toString(), b.capacidad(), b.desplazamientos());
    }
}