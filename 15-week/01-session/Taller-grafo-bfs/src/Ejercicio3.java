public class Ejercicio3 {
    public static void main(String[] args) {
        Graph g = new Graph();

        // Componente 1
        g.addEdge("A", "B");
        g.addEdge("A", "C");

        // Componente 2
        g.addEdge("X", "Y");

        System.out.println("Recorrido BFS desde A (componente 1):");
        System.out.println(g.bfs("A")); // Ejemplo: [A, B, C]

        System.out.println("Recorrido BFS desde X (componente 2):");
        System.out.println(g.bfs("X")); // Ejemplo: [X, Y]
    }
}

