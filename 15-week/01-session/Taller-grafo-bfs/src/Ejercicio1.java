public class Ejercicio1 {
    public static void main(String[] args) {
        Graph red = new Graph();

        red.addVertex("Ana");
        red.addVertex("Luis");
        red.addVertex("Sofia");
        red.addVertex("Carlos");
        red.addVertex("Marta");

        red.addEdge("Ana", "Luis");
        red.addEdge("Ana", "Sofia");
        red.addEdge("Luis", "Carlos");
        red.addEdge("Sofia", "Marta");

        System.out.println("Recorrido BFS desde Ana:");
        System.out.println(red.bfs("Ana")); // Ejemplo: [Ana, Luis, Sofia, Carlos, Marta]
    }
}