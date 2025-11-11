public class Ejercicio2 {
    public static void main(String[] args) {
        Graph mapa = new Graph();

        mapa.addEdge("Bogota", "Medellin");
        mapa.addEdge("Bogota", "Cali");
        mapa.addEdge("Medellin", "Barranquilla");
        mapa.addEdge("Cali", "Pasto");
        mapa.addEdge("Barranquilla", "Santa Marta");

        System.out.println("Recorrido BFS desde Bogota:");
        System.out.println(mapa.bfs("Bogota")); // Ejemplo: [Bogota, Medellin, Cali, Barranquilla, Pasto, Santa Marta]
    }
}

