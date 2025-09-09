public class Ejercicio3 {
    public static void main(String[] args){
        ListaSimple lista = new ListaSimple();
        lista.insertarFin(10);
        lista.insertarFin(20);
        lista.insertarFin(30);
        System.out.println("Antes:"); lista.mostrar();
        Integer eliminado = lista.eliminarEnPosicion(1);
        System.out.println("Eliminado: " + eliminado);
        lista.mostrar();
        Integer e2 = lista.eliminarEnPosicion(10); // caso inválido
        System.out.println("Intento eliminar posición inválida devuelve: " + e2);
    }
}
