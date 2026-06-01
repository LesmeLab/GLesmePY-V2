import java.math.BigInteger;

public class FactorialTiempo {
    public static BigInteger factorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        BigInteger resultado = factorial(150);
        long fin = System.nanoTime();

        long tiempo = fin - inicio; // en nanosegundos
        System.out.println("Factorial(200): " + resultado);
        System.out.println("Tiempo de ejecución: " + tiempo + " ns");
        System.out.println("Tiempo en milisegundos: " + (tiempo / 1_000_000.0) + " ms");
    }
}
