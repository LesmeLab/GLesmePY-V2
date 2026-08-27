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

public class HistorialEdicion {
    private PilaES<Comando> pilaDeshacer;
    private PilaES<Comando> pilaRehacer;

    public HistorialEdicion() {
        this.pilaDeshacer = new PilaES<>();
        this.pilaRehacer = new PilaES<>();
    }

    public void ejecutar(Comando c) {
        c.ejecutar();
        pilaDeshacer.apilar(c);
        pilaRehacer.vaciar(); // Invalida rehacer
    }

    public boolean deshacer() {
        if (pilaDeshacer.estavacia()) {
            return false;
        }
        Comando c = pilaDeshacer.desapilar();
        c.deshacer();
        pilaRehacer.apilar(c);
        return true;
    }

    public boolean rehacer() {
        if (pilaRehacer.estavacia()) {
            return false;
        }
        Comando c = pilaRehacer.desapilar();
        c.ejecutar();
        pilaDeshacer.apilar(c);
        return true;
    }

    public int sizeDeshacer() {
        return pilaDeshacer.size();
    }

    public int sizeRehacer() {
        return pilaRehacer.size();
    }
}