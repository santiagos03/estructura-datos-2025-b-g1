// Ejercicio2.java
public class Ejercicio2 {
    public static void main(String[] args) {
        // Creamos la lista simple
        ListaSimple lista = new ListaSimple();

        // Insertamos elementos
        lista.insertarFin(1);
        lista.insertarFin(2);
        lista.insertarFin(4);

        System.out.println("Lista inicial:");
        lista.mostrar(); // [1, 2, 4]

        // Insertamos en posición 2 (entre 2 y 4)
        lista.insertarEnPosicion(3, 2);

        System.out.println("Después de insertar 3 en la posición 2:");
        lista.mostrar(); // [1, 2, 3, 4]
    }
}
