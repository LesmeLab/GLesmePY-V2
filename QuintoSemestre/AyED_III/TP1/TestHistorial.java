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


public class TestHistorial {
    public static void main(String[] args) throws Exception {
        BufferGap<Character> buffer = new BufferGap<>();
        
        // Estado inicial Ejercicio 1 (fila get(4)): HoX|la
        buffer.insertar('H');
        buffer.insertar('o');
        buffer.insertar('l');
        buffer.insertar('a');
        buffer.moverCursor(-2);
        buffer.insertar('X');
        buffer.get(4);

        HistorialEdicion historial = new HistorialEdicion();

        System.out.println("TRAZA EJERCICIO 2:");
        System.out.printf("%-2s | %-20s | %-10s | %-5s | %-5s%n", "#", "Operación", "Contenido", "desh.", "reh.");
        System.out.println("---------------------------------------------------------");

        // Paso 1
        historial.ejecutar(new ComandoInsertar(buffer, '!'));
        imprimirPaso(1, "Insertar('!')", buffer, historial);

        // Paso 2
        historial.ejecutar(new ComandoInsertar(buffer, '?'));
        imprimirPaso(2, "Insertar('?')", buffer, historial);

        // Paso 3
        boolean r3 = historial.deshacer();
        imprimirPaso(3, "deshacer() -> " + r3, buffer, historial);

        // Paso 4
        boolean r4 = historial.deshacer();
        imprimirPaso(4, "deshacer() -> " + r4, buffer, historial);

        // Paso 5
        boolean r5 = historial.rehacer();
        imprimirPaso(5, "rehacer() -> " + r5, buffer, historial);

        // Paso 6
        historial.ejecutar(new ComandoMoverCursor(buffer, -4));
        imprimirPaso(6, "MoverCursor(-4)", buffer, historial);

        // Paso 7
        boolean r7 = historial.rehacer();
        imprimirPaso(7, "rehacer() -> " + r7, buffer, historial);

        // Paso 8
        boolean r8 = historial.deshacer();
        imprimirPaso(8, "deshacer() -> " + r8, buffer, historial);

        // Paso 9
        historial.ejecutar(new ComandoBorrar(buffer));
        imprimirPaso(9, "Borrar()", buffer, historial);

        // Paso 10
        boolean r10 = historial.deshacer();
        imprimirPaso(10, "deshacer() -> " + r10, buffer, historial);

        // Paso 11
        boolean r11 = historial.deshacer();
        imprimirPaso(11, "deshacer() -> " + r11, buffer, historial);

        // Paso 12
        boolean r12 = historial.deshacer();
        imprimirPaso(12, "deshacer() -> " + r12, buffer, historial);
    }

    private static void imprimirPaso(int paso, String op, BufferGap<Character> b, HistorialEdicion h) {
        System.out.printf("%2d | %-20s | %-10s | %-5d | %-5d%n", paso, op, b.toString(), h.sizeDeshacer(), h.sizeRehacer());
    }
}