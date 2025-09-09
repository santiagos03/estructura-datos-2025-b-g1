import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        ListaSimple cola = new ListaSimple();

        // Simulación: encolar (insertar fin) y atender (eliminar inicio)
        cola.insertarFin(101);
        cola.insertarFin(102);
        cola.insertarFin(103);

        System.out.println("Cola inicial:");
        cola.mostrar();

        System.out.println("Atendiendo: " + cola.eliminarInicio());
        System.out.println("Cola luego de atender:");
        cola.mostrar();

        // Interacción con el usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese id para encolar (0 para salir):");
        int id;
        while ((id = sc.nextInt()) != 0) {
            cola.insertarFin(id);
            cola.mostrar();
        }
        sc.close();
    }
}
