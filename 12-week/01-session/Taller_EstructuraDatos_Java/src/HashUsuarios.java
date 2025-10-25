import java.util.*;

/**
 * Mantiene usuarios únicos por ID usando HashMap.
 * Operaciones principales O(1) promedio.
 */
public class HashUsuarios {
    public static class Usuario {
        public final String id; // cédula/ID único
        public String nombre;
        public Usuario(String id, String nombre) { this.id = id; this.nombre = nombre; }
        @Override public String toString() { return id + ": " + nombre; }
    }

    private final Map<String, Usuario> porId = new HashMap<>();

    public boolean agregar(Usuario u) {
        if (porId.containsKey(u.id)) return false; // ya existe
        porId.put(u.id, u);
        return true;
    }

    public Usuario obtener(String id) { return porId.get(id); }
    public boolean eliminar(String id) { return porId.remove(id) != null; }

    public static void main(String[] args) {
        HashUsuarios repo = new HashUsuarios();
        System.out.println(repo.agregar(new Usuario("101", "Ana"))); // true
        System.out.println(repo.agregar(new Usuario("101", "Otra"))); // false
        System.out.println(repo.obtener("101"));
    }
}
