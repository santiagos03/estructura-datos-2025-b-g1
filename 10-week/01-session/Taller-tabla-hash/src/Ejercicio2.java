import java.util.Scanner;

/**
 * Ejercicio 2: Contador de palabras
 * Lee una línea de texto y cuenta ocurrencias usando HashTable<String,Integer>
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String,Integer> ht = new HashTable<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un texto (una línea):");
        String line = sc.nextLine();
        String[] words = line.split("\\s+");

        for (String w : words) {
            if (w.isEmpty()) continue;
            Integer cur = ht.get(w);
            if (cur == null) ht.put(w, 1);
            else ht.put(w, cur + 1);
        }

        System.out.println("Conteo:");
        for (String w : words) {
            if (w.isEmpty()) continue;
            Integer c = ht.get(w);
            if (c != null) {
                System.out.println(w + " -> " + c);
                ht.remove(w); // evitar imprimir repetidos
            }
        }
        sc.close();
    }
}
