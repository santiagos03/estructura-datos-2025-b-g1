public class Ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lc = new ListaCircular();
        lc.insertarFin(10);
        lc.insertarFin(20);
        lc.insertarFin(30);
        lc.insertarEnPosicion(5, 1); // insertar 5 en medio

        lc.mostrar(10); // mostrar hasta 10 elementos
        System.out.println("Eliminar pos 2: " + lc.eliminarEnPosicion(2));
        lc.mostrar(10);
    }
}
