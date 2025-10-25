import java.util.*;

/**
 * Pequeño integrador: navegamos por un grafo y mantenemos historial de pasos con pila.
 */
public class ProyectoIntegrador {
    static class Grafo {
        Map<String, List<String>> adj = new HashMap<>();
        void add(String a, String b){ adj.putIfAbsent(a, new ArrayList<>()); adj.putIfAbsent(b, new ArrayList<>()); adj.get(a).add(b); adj.get(b).add(a);}    }

    public static void main(String[] args){
        Grafo g = new Grafo();
        g.add("Casa","Parque"); g.add("Parque","Tienda"); g.add("Tienda","Escuela");
        Stack<String> historial = new Stack<>();
        String pos = "Casa"; historial.push(pos);
        pos = mover(g, pos, "Parque", historial);
        pos = mover(g, pos, "Tienda", historial);
        pos = mover(g, pos, "Escuela", historial);
        System.out.println("Posición actual: "+pos+" | Historial: "+historial);
        // Deshacer últimos 2 movimientos
        undo(historial); undo(historial); pos = historial.peek();
        System.out.println("Tras deshacer: pos="+pos+" | Historial: "+historial);
    }

    static String mover(Grafo g, String desde, String hacia, Stack<String> hist){
        if(g.adj.getOrDefault(desde, List.of()).contains(hacia)){
            hist.push(hacia); return hacia;
        }
        throw new IllegalArgumentException("No existe ruta de "+desde+" a "+hacia);
    }

    static void undo(Stack<String> hist){ if(hist.size()>1) hist.pop(); }
}
