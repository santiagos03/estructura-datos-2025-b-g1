import java.util.*;

// Pequeño grafo para DFS (solo para este ejercicio)
class SimpleGraphDFS {
    private final Map<String, List<String>> adj = new HashMap<>();

    public void addEdge(String u, String v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public List<String> dfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adj.containsKey(start)) return order;
        Set<String> vis = new HashSet<>();
        dfsRec(start, vis, order);
        return order;
    }

    private void dfsRec(String u, Set<String> vis, List<String> order) {
        vis.add(u);
        order.add(u);
        for (String v : adj.getOrDefault(u, Collections.emptyList())) {
            if (!vis.contains(v)) dfsRec(v, vis, order);
        }
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        // Mismo grafo para ambos recorridos
        String[][] edges = {
            {"A","B"}, {"A","C"}, {"B","D"}, {"C","E"}, {"B","F"}
        };

        // BFS con la clase Graph del taller
        Graph gBFS = new Graph();
        // DFS con grafo local
        SimpleGraphDFS gDFS = new SimpleGraphDFS();

        for (String[] e : edges) {
            gBFS.addEdge(e[0], e[1]);
            gDFS.addEdge(e[0], e[1]);
        }

        System.out.println("BFS desde A:");
        System.out.println(gBFS.bfs("A")); // Ejemplo: [A, B, C, D, F, E] (puede variar según inserción)

        System.out.println("DFS desde A:");
        System.out.println(gDFS.dfs("A")); // Ejemplo: [A, B, D, F, C, E] (orden de profundidad)
    }
}