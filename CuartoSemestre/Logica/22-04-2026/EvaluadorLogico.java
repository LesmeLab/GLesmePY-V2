import java.util.*;

public class EvaluadorLogico {

    // --- 1. DEFINICIÓN DE LOS NODOS DEL ÁRBOL (AST) ---
    abstract static class Nodo {
        int x, y; // Coordenadas para el diagrama 2D
        boolean valor; // Almacena el resultado evaluado de este nodo

        abstract boolean evaluar(Map<Character, Boolean> valores);
    }

    static class NodoVariable extends Nodo {
        char nombre;
        NodoVariable(char nombre) { this.nombre = nombre; }

        @Override
        boolean evaluar(Map<Character, Boolean> valores) {
            this.valor = valores.get(nombre);
            return this.valor;
        }
    }

    static class NodoNot extends Nodo {
        Nodo hijo;
        NodoNot(Nodo hijo) { this.hijo = hijo; }

        @Override
        boolean evaluar(Map<Character, Boolean> valores) {
            this.valor = !hijo.evaluar(valores);
            return this.valor;
        }
    }

    static class NodoBinario extends Nodo {
        Nodo izq, der;
        char operador;

        NodoBinario(Nodo izq, Nodo der, char operador) {
            this.izq = izq;
            this.der = der;
            this.operador = operador;
        }

        @Override
        boolean evaluar(Map<Character, Boolean> valores) {
            boolean valIzq = izq.evaluar(valores);
            boolean valDer = der.evaluar(valores);

            switch (operador) {
                case '&': this.valor = valIzq && valDer; break;
                case '|': this.valor = valIzq || valDer; break;
                case '>': this.valor = !valIzq || valDer; break;
                case '=': this.valor = valIzq == valDer; break;
            }
            return this.valor;
        }
    }

   // --- 2. PARSER: DOMINANCIA SEGÚN EL LIBRO DE SUPPES ---
    // Nota: A mayor dominancia lógica, MENOR prioridad algorítmica (pues se evalúa al final)
    private static int precedencia(char op) {
        if (op == '~') return 4;                  // Menor dominancia (se agrupa y evalúa primero)
        if (op == '&' || op == '|') return 3;     // Nivel intermedio (tienen igual fuerza entre sí)
        if (op == '>') return 2;                  // Condicional (domina a las anteriores)
        if (op == '=') return 1;                  // Bicondicional (Mayor dominancia absoluta)
        return 0;
    }

    public static Nodo construirArbol(String expresion) {
        expresion = expresion.replaceAll("\\s+", "");
        Stack<Nodo> nodos = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isLetter(c)) {
                nodos.push(new NodoVariable(c));
            } else if (c == '(') {
                operadores.push(c);
            } else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    procesarOperador(nodos, operadores.pop());
                }
                operadores.pop(); 
            } else { 
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    if (c == '~' && operadores.peek() == '~') break;
                    procesarOperador(nodos, operadores.pop());
                }
                operadores.push(c);
            }
        }

        while (!operadores.isEmpty()) {
            procesarOperador(nodos, operadores.pop());
        }

        return nodos.pop(); 
    }

    private static void procesarOperador(Stack<Nodo> nodos, char op) {
        if (op == '~') {
            nodos.push(new NodoNot(nodos.pop()));
        } else {
            Nodo der = nodos.pop();
            Nodo izq = nodos.pop();
            nodos.push(new NodoBinario(izq, der, op));
        }
    }

    // --- 3. MOTOR GRÁFICO (MATRIZ 2D) ---
    
    static int currentX = 0;
    static final int SPACING = 6; // Separación horizontal entre nodos

    // Calcula la coordenada X usando recorrido In-Order
    static void asignarX(Nodo n) {
        if (n == null) return;
        if (n instanceof NodoBinario) {
            asignarX(((NodoBinario)n).izq);
            n.x = currentX;
            currentX += SPACING;
            asignarX(((NodoBinario)n).der);
        } else if (n instanceof NodoNot) {
            n.x = currentX;
            currentX += SPACING;
            asignarX(((NodoNot)n).hijo);
        } else { // Variable
            n.x = currentX;
            currentX += SPACING;
        }
    }

    // Calcula la coordenada Y (profundidad invertida)
    static void asignarY(Nodo n) {
        if (n == null) return;
        if (n instanceof NodoBinario) {
            NodoBinario nb = (NodoBinario) n;
            asignarY(nb.izq);
            asignarY(nb.der);
            n.y = Math.max(nb.izq.y, nb.der.y) + 1;
        } else if (n instanceof NodoNot) {
            NodoNot nn = (NodoNot) n;
            asignarY(nn.hijo);
            n.y = nn.hijo.y + 1;
        } else {
            n.y = 0; // Las hojas están arriba (Y=0)
        }
    }

    // Recolecta todos los nodos en una lista plana
    static List<Nodo> obtenerTodos(Nodo raiz) {
        List<Nodo> lista = new ArrayList<>();
        if (raiz == null) return lista;
        lista.add(raiz);
        if (raiz instanceof NodoBinario) {
            lista.addAll(obtenerTodos(((NodoBinario)raiz).izq));
            lista.addAll(obtenerTodos(((NodoBinario)raiz).der));
        } else if (raiz instanceof NodoNot) {
            lista.addAll(obtenerTodos(((NodoNot)raiz).hijo));
        }
        return lista;
    }

    // Genera e imprime el diagrama visual
    static void generarDiagrama(Nodo raiz) {
        currentX = 0;
        asignarX(raiz);
        asignarY(raiz);

        int maxX = 0, maxY = 0;
        List<Nodo> todos = obtenerTodos(raiz);
        for (Nodo n : todos) {
            if (n.x > maxX) maxX = n.x;
            if (n.y > maxY) maxY = n.y;
        }

        // Crear grilla 2D
        int filas = maxY * 3 + 1; // 3 filas por nivel para dar espacio a las líneas
        int cols = maxX + 1;
        char[][] grid = new char[filas][cols];
        for (int i = 0; i < filas; i++) {
            Arrays.fill(grid[i], ' ');
        }

        // Posicionar valores V/F y trazar líneas
        for (Nodo n : todos) {
            int r = n.y * 3;
            int c = n.x;
            grid[r][c] = n.valor ? 'V' : 'F';

            if (n instanceof NodoBinario) {
                NodoBinario nb = (NodoBinario) n;
                dibujarLinea(grid, nb.izq.x, nb.izq.y * 3, c, r, '\\');
                dibujarLinea(grid, nb.der.x, nb.der.y * 3, c, r, '/');
            } else if (n instanceof NodoNot) {
                NodoNot nn = (NodoNot) n;
                dibujarLinea(grid, nn.hijo.x, nn.hijo.y * 3, c, r, '|');
            }
        }

        // Imprimir la grilla
        for (int i = 0; i < filas; i++) {
            // No imprimir líneas completamente vacías para que se vea más compacto
            String linea = new String(grid[i]);
            if (!linea.trim().isEmpty()) {
                System.out.println(linea);
            }
        }
    }

    // Dibuja la línea diagonal interpolando posiciones en la matriz
    static void dibujarLinea(char[][] grid, int cx, int cr, int px, int pr, char charLinea) {
        for (int i = cr + 1; i < pr; i++) {
            float progreso = (float)(i - cr) / (pr - cr);
            int c = cx + Math.round(progreso * (px - cx));
            grid[i][c] = charLinea;
        }
    }

    // --- 4. MÉTODO PRINCIPAL ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EVALUADOR DE PREMISAS LÓGICAS ===");
        System.out.print("Ingresa la premisa lógica (ej: (p & q) > r): ");
        String premisa = scanner.nextLine();

        Set<Character> variables = new TreeSet<>();
        for (char c : premisa.toCharArray()) {
            if (Character.isLetter(c)) variables.add(c);
        }

        Map<Character, Boolean> valores = new HashMap<>();
        System.out.println("\nAsigna el valor para cada proposición (escribe V o F):");
        for (char var : variables) {
            System.out.print(var + " = ");
            String input = scanner.nextLine().trim().toUpperCase();
            valores.put(var, input.equals("V") || input.equals("VERDADERO"));
        }

        try {
            Nodo raiz = construirArbol(premisa);
            boolean resultadoFinal = raiz.evaluar(valores);

            System.out.println("\n--- DIAGRAMA DE EVALUACIÓN ---");
            generarDiagrama(raiz);
            System.out.println("\n------------------------------");
            System.out.println("RESULTADO FINAL: " + (resultadoFinal ? "VERDADERO (V)" : "FALSO (F)"));
            
        } catch (Exception e) {
            System.out.println("Error al procesar. Verifica la sintaxis de la premisa.");
        }

        scanner.close();
    }
}
/*
(V & V) > F
 *   *    *
  \ /     *
   V      F
   \     /
    \   /
	 \ /
      F
*/