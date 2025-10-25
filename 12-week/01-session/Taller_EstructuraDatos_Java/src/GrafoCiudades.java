import java.util.*;

/**
 * Grafo con lista de adyacencia: permite BFS y Dijkstra para rutas más cortas.
 */
public class GrafoCiudades {
    static class Arista { String to; int w; Arista(String t,int w){to=t;this.w=w;} }
    private final Map<String, List<Arista>> g = new HashMap<>();

    public void agregarCiudad(String c){ g.putIfAbsent(c, new ArrayList<>()); }
    public void agregarRuta(String a, String b, int distancia){ agregarCiudad(a); agregarCiudad(b); g.get(a).add(new Arista(b, distancia)); g.get(b).add(new Arista(a, distancia)); }

    /** Camino más corto para grafo NO ponderado */
    public List<String> bfs(String origen, String destino){
        Map<String,String> prev = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.add(origen); vis.add(origen);
        while(!q.isEmpty()){
            String u=q.poll();
            if(u.equals(destino)) break;
            for(Arista e: g.getOrDefault(u, List.of())){
                if(!vis.contains(e.to)) { vis.add(e.to); prev.put(e.to,u); q.add(e.to);} }
        }
        return reconstruir(prev, origen, destino);
    }

    /** Dijkstra para grafo ponderado con pesos no negativos */
    public List<String> dijkstra(String origen, String destino){
        Map<String,Integer> dist = new HashMap<>();
        Map<String,String> prev = new HashMap<>();
        for(String v: g.keySet()) dist.put(v, Integer.MAX_VALUE);
        dist.put(origen, 0);
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(origen);
        while(!pq.isEmpty()){
            String u = pq.poll();
            if(u.equals(destino)) break;
            for(Arista e: g.getOrDefault(u, List.of())){
                int nd = dist.get(u)==Integer.MAX_VALUE?Integer.MAX_VALUE:dist.get(u)+e.w;
                if(nd < dist.getOrDefault(e.to, Integer.MAX_VALUE)){
                    dist.put(e.to, nd); prev.put(e.to, u); pq.remove(e.to); pq.add(e.to);
                }
            }
        }
        return reconstruir(prev, origen, destino);
    }

    private List<String> reconstruir(Map<String,String> prev, String o, String d){
        LinkedList<String> camino = new LinkedList<>();
        for(String at=d; at!=null; at=prev.get(at)) camino.addFirst(at);
        if(!camino.isEmpty() && camino.getFirst().equals(o)) return camino; else return List.of();
    }

    public static void main(String[] args){
        GrafoCiudades g = new GrafoCiudades();
        g.agregarRuta("A", "B", 5);
        g.agregarRuta("B", "C", 2);
        g.agregarRuta("A", "C", 10);
        g.agregarRuta("C", "D", 1);
        System.out.println("BFS A->D: "+ g.bfs("A","D"));
        System.out.println("Dijkstra A->D: "+ g.dijkstra("A","D"));
    }
}
