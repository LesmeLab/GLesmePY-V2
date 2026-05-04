import java.util.*;

public class EvaluadorLogico {
    static class Nodo {
        char c; int pos; Boolean v;
        Nodo(char c, int pos, Boolean v) { this.c = c; this.pos = pos; this.v = v; }
    }

    public static void main(String[] args) {
		System.out.printf("\n*****************************************\nSon equivalencias de simbolos\n%s%s%s%s%s*****************************************\n",
                  "Negacion:  ¬   ~\n",
                  "Conjuncion: &\n",
                  "Disyuncion: |\n",
                  "Implicacion: >\n",
                  "Bicondicional: =\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la premisa (ej: P&Q|S o ~(P&Q)=(Q>P)):");
        String premisa = sc.nextLine().toUpperCase().replaceAll("\\s+", "");

        Map<Character, Boolean> vals = new HashMap<>();
        for (char ch : premisa.toCharArray()) {
            if (Character.isLetter(ch) && ch != 'V' && ch != 'F' && !vals.containsKey(ch)) {
                System.out.print("Valor para " + ch + " (V/F): ");
                vals.put(ch, sc.next().toUpperCase().startsWith("V"));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : premisa.toCharArray()) sb.append(c).append("   ");
        System.out.println("\n" + sb.toString().trim());

        List<Nodo> lista = new ArrayList<>();
        for (int i = 0; i < premisa.length(); i++) lista.add(new Nodo(premisa.charAt(i), i * 4, vals.get(premisa.charAt(i))));

        imprimirNivel(lista);

        while (lista.size() > 1) {
            boolean limpiado = true;
            while (limpiado) {
                limpiado = false;
                for (int i = 0; i < lista.size() - 2; i++) {
                    if (lista.get(i).c == '(' && lista.get(i+1).v != null && lista.get(i+2).c == ')') {
                        lista.remove(i+2); lista.remove(i);
                        limpiado = true; break;
                    }
                }
            }
            if (lista.size() == 1) break;

            int maxScore = -9999, depth = 0;
            List<Integer> candidatos = new ArrayList<>(); // Guardará empates
            
            for (int i = 0; i < lista.size(); i++) {
                char c = lista.get(i).c;
                if (c == '(') depth++;
                else if (c == ')') depth--;
                else if ("¬~&?|?>?=?".indexOf(c) != -1) {
                    boolean listo = false;
                    if (c == '~' || c == '¬') {
                        if (i + 1 < lista.size() && lista.get(i+1).v != null) listo = true;
                    } else {
                        if (i > 0 && i + 1 < lista.size() && lista.get(i-1).v != null && lista.get(i+1).v != null) listo = true;
                    }
                    
                    if (listo) {
                        int score = (depth * 10) - getPrec(c);
                        if (score > maxScore) { 
                            maxScore = score; 
                            candidatos.clear(); 
                            candidatos.add(i); 
                        } else if (score == maxScore) {
                            candidatos.add(i); // Se detecta un empate
                        }
                    }
                }
            }

            if (candidatos.isEmpty()) {
                System.out.println("\n[!] Error de sintaxis en la fórmula."); return;
            }

            // REGLA DE SUPPES: Si hay empate entre operadores binarios, es ambiguo
            if (candidatos.size() > 1) {
                char op1 = lista.get(candidatos.get(0)).c;
                char op2 = lista.get(candidatos.get(1)).c;
                if (getPrec(op1) > 1 && getPrec(op2) > 1) { // Si ambos son binarios (&, |, >, =)
                    System.out.println("\n[!] ERROR SEGÚN BIBLIOGRAFÍA (SUPPES):");
                    System.out.println("Expresión mal formada y ambigua. Operadores '" + op1 + "' y '" + op2 + "' compiten en el mismo nivel.");
                    System.out.println("Debes usar paréntesis para definir el orden. Ej: (P " + op1 + " Q) " + op2 + " S");
                    return;
                }
            }

            int bestIdx = candidatos.get(0);
            char op = lista.get(bestIdx).c;
            int posOriginal = lista.get(bestIdx).pos;
            
            if (op == '~' || op == '¬') {
                lista.set(bestIdx, new Nodo('R', posOriginal, !lista.get(bestIdx+1).v));
                lista.remove(bestIdx+1);
            } else {
                boolean v1 = lista.get(bestIdx-1).v, v2 = lista.get(bestIdx+1).v, res = false;
                if (op == '&' || op == '?') res = v1 && v2;
                else if (op == '|' || op == '?') res = v1 || v2;
                else if (op == '>' || op == '?') res = !v1 || v2;
                else if (op == '=' || op == '?') res = (v1 == v2);

                lista.set(bestIdx, new Nodo('R', posOriginal, res));
                lista.remove(bestIdx+1); lista.remove(bestIdx-1);
            }
            imprimirNivel(lista);
        }
        System.out.println("\nValor Final: " + (lista.get(0).v ? "Verdadero (V)" : "Falso (F)"));
    }

    static int getPrec(char c) {
        if (c == '~' || c == '¬') return 1; 
        if (c == '&' || c == '?' || c == '|' || c == '?') return 2;
        if (c == '>' || c == '?') return 3; 
        return 4; 
    }

    static void imprimirNivel(List<Nodo> lista) {
        StringBuilder sb = new StringBuilder();
        for (Nodo n : lista) {
            if (n.v != null) {
                while (sb.length() < n.pos) sb.append(" ");
                sb.append(n.v ? "V" : "F");
            }
        }
        if (sb.length() > 0) System.out.println(sb.toString());
    }
}