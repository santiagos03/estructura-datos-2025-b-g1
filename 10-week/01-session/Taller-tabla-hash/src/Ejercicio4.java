/**
 * Ejercicio 4: Prueba de tamaño
 * Inserta N elementos y muestra la cantidad final.
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        int N = 1000;
        HashTable<Integer,Integer> ht = new HashTable<>(128);
        for (int i = 0; i < N; i++) ht.put(i, i * 10);

        System.out.println("Insertados: " + N);
        System.out.println("Reported size: " + ht.size());
    }
}

