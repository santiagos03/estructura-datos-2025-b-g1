import java.util.*;

/**
 * Cola de atención con prioridades (menor número = mayor prioridad).
 * Complejidad: insertar y extraer O(log n) con PriorityQueue.
 */
public class ColaPrioridad {
    public static class Cliente {
        public final String nombre;
        public final int prioridad; // 0 = crítico, 1 = alto, 2 = medio, etc.
        public Cliente(String nombre, int prioridad) { this.nombre = nombre; this.prioridad = prioridad; }
        @Override public String toString() { return nombre + "(p=" + prioridad + ")"; }
    }

    public static void main(String[] args) {
        PriorityQueue<Cliente> cola = new PriorityQueue<>(Comparator.comparingInt(c -> c.prioridad));
        cola.add(new Cliente("Ana", 2));
        cola.add(new Cliente("Luis", 1));
        cola.add(new Cliente("Carla", 0));
        cola.add(new Cliente("Diego", 3));
        while (!cola.isEmpty()) System.out.println("Atendido: " + cola.poll());
    }
}
