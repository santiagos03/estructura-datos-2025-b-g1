import java.util.Scanner;

/**
 * Ejercicio 1: Diccionario simple usuario -> rol
 * Menú en consola: agregar, consultar, eliminar, listar, salir.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String,String> ht = new HashTable<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Diccionario usuario->rol ---");
            System.out.println("1) Agregar/Actualizar");
            System.out.println("2) Consultar");
            System.out.println("3) Eliminar");
            System.out.println("4) Listar (debug)");
            System.out.println("5) Salir");
            System.out.print("Elige opción: ");
            int op = Integer.parseInt(sc.nextLine());

            if (op == 1) {
                System.out.print("Usuario: ");
                String u = sc.nextLine();
                System.out.print("Rol: ");
                String r = sc.nextLine();
                ht.put(u, r);
                System.out.println("Guardado.");
            } else if (op == 2) {
                System.out.print("Usuario: ");
                String u = sc.nextLine();
                String rol = ht.get(u);
                System.out.println(rol == null ? "No existe" : "Rol: " + rol);
            } else if (op == 3) {
                System.out.print("Usuario: ");
                String u = sc.nextLine();
                String old = ht.remove(u);
                System.out.println(old == null ? "No existía" : "Eliminado rol=" + old);
            } else if (op == 4) {
                System.out.println("Tamaño: " + ht.size());
                System.out.println(ht.debugBuckets());
            } else break;
        }

        sc.close();
    }
}
