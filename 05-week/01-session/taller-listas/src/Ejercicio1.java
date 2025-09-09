public class Ejercicio1 {
    public static void main(String[] args){
        ListaSimple lista = new ListaSimple();
        lista.insertarFin(5);
        lista.insertarFin(10);
        lista.insertarFin(15);
        System.out.println("Lista básica:");
        lista.mostrar(); // [5, 10, 15]
    }
}
