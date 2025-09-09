public class Ejercicio4 {
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();

        // Insertamos algunos elementos
        ld.insertarFin(1);
        ld.insertarFin(2);
        ld.insertarFin(3);

        System.out.println("Recorrido hacia adelante:");
        ld.mostrarForward();

        System.out.println("Recorrido hacia atrás:");
        ld.mostrarBackward();

        // Probamos eliminación en ambos extremos
        System.out.println("Eliminar inicio: " + ld.eliminarInicio());
        System.out.println("Eliminar fin: " + ld.eliminarFin());

        System.out.println("Lista después de las eliminaciones:");
        ld.mostrarForward();
    }
}
