/**
 * Muestra la complejidad algorítmica de cada estructura del taller.
 */
public class Complejidad {
    public static void main(String[] args) {
        System.out.println("8. COMPLEJIDAD ALGORÍTMICA");
        System.out.println("Descripción: Se analiza la eficiencia de cada estructura con notación Big O.\n");
        System.out.println(String.format("%-20s %-20s", "Estructura", "Complejidad principal"));
        System.out.println("------------------------------------------------------");
        System.out.println(String.format("%-20s %-20s", "Pila", "O(1)"));
        System.out.println(String.format("%-20s %-20s", "Cola con prioridad", "O(log n)"));
        System.out.println(String.format("%-20s %-20s", "HashMap", "O(1) promedio"));
        System.out.println(String.format("%-20s %-20s", "Árbol Binario", "O(log n)"));
        System.out.println(String.format("%-20s %-20s", "AVL", "O(log n)"));
        System.out.println(String.format("%-20s %-20s", "BST", "O(log n)"));
        System.out.println(String.format("%-20s %-20s", "Grafo", "O(V + E)"));
    }
}
