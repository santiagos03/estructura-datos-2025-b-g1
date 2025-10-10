/**
 * Ejercicio 3: Colisiones controladas
 * Crea claves con hashCode forzado para el mismo índice y muestra encadenamiento.
 */
public class Ejercicio3 {
    static class BadKey {
        private final String id;
        private final int forcedHash;

        public BadKey(String id, int forcedHash) {
            this.id = id;
            this.forcedHash = forcedHash;
        }

        @Override
        public int hashCode() {
            return forcedHash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BadKey)) return false;
            BadKey b = (BadKey) o;
            return id.equals(b.id) && forcedHash == b.forcedHash;
        }

        @Override
        public String toString() {
            return id;
        }
    }

    public static void main(String[] args) {
        HashTable<BadKey,String> ht = new HashTable<>(4);
        ht.put(new BadKey("A", 3), "alpha");
        ht.put(new BadKey("B", 3), "beta");
        ht.put(new BadKey("C", 3), "gamma");

        System.out.println("Estado interno (mismo índice para A,B,C):");
        System.out.println(ht.debugBuckets());
    }
}

