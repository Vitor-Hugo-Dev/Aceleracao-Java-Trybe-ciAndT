import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        /**
         * exemplo para mostrar que o put do hashmap quando substitui um valor, ele
         * retorna o valor antigo no momento da substituição
         */
        var estudantes = new HashMap<String, String>();
        // metodo put(key, value) insere um valor no hashmap
        estudantes.put("x038702", "João");
        estudantes.put("x784244", "Maria");
        estudantes.put("x105852", "Joana");
        String valorAnterior = estudantes.put("x038702", "José"); // Mesma matricula usada no mapeamento com João
        System.out.println("Valor anterior de x038702: " + valorAnterior);
        System.out.println("Estudantes: " + estudantes);
        // metodo get(key) retorna o valor do mapeamento
        System.out.println(estudantes.get("x105852"));
        // metodo remove(key) remove o mapeamento
        estudantes.remove("x038702");
        System.out.println(estudantes);
    }
}
