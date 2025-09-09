// ListaDoble.java
public class ListaDoble {
    // Nodo interno (private para que esté todo en un solo archivo)
    private static class NodoD {
        int dato;
        NodoD siguiente;
        NodoD anterior;
        NodoD(int d) {
            this.dato = d;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    private NodoD cabeza;
    private NodoD cola;
    private int tamanio;

    public ListaDoble() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tamanio() {
        return tamanio;
    }

    public void insertarInicio(int v) {
        NodoD n = new NodoD(v);
        if (estaVacia()) {
            cabeza = cola = n;
        } else {
            n.siguiente = cabeza;
            cabeza.anterior = n;
            cabeza = n;
        }
        tamanio++;
    }

    public void insertarFin(int v) {
        NodoD n = new NodoD(v);
        if (estaVacia()) {
            cabeza = cola = n;
        } else {
            cola.siguiente = n;
            n.anterior = cola;
            cola = n;
        }
        tamanio++;
    }

    // Inserta en posición pos (0..tamanio). Devuelve true si ok.
    public boolean insertarEnPosicion(int v, int pos) {
        if (pos < 0 || pos > tamanio) return false;
        if (pos == 0) { insertarInicio(v); return true; }
        if (pos == tamanio) { insertarFin(v); return true; }

        NodoD actual = cabeza;
        for (int i = 0; i < pos - 1; i++) actual = actual.siguiente;

        NodoD nuevo = new NodoD(v);
        nuevo.siguiente = actual.siguiente;
        nuevo.anterior = actual;
        actual.siguiente.anterior = nuevo;
        actual.siguiente = nuevo;
        tamanio++;
        return true;
    }

    public Integer eliminarInicio() {
        if (estaVacia()) return null;
        int val = cabeza.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        tamanio--;
        return val;
    }

    public Integer eliminarFin() {
        if (estaVacia()) return null;
        int val = cola.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
        tamanio--;
        return val;
    }

    // Elimina en posición pos (0..tamanio-1)
    public Integer eliminarEnPosicion(int pos) {
        if (estaVacia() || pos < 0 || pos >= tamanio) return null;
        if (pos == 0) return eliminarInicio();
        if (pos == tamanio - 1) return eliminarFin();

        NodoD actual = cabeza;
        for (int i = 0; i < pos; i++) actual = actual.siguiente;

        int val = actual.dato;
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
        tamanio--;
        return val;
    }

    public void mostrarForward() {
        NodoD a = cabeza;
        System.out.print("[");
        while (a != null) {
            System.out.print(a.dato);
            if (a.siguiente != null) System.out.print(", ");
            a = a.siguiente;
        }
        System.out.println("]");
    }

    public void mostrarBackward() {
        NodoD a = cola;
        System.out.print("[");
        while (a != null) {
            System.out.print(a.dato);
            if (a.anterior != null) System.out.print(", ");
            a = a.anterior;
        }
        System.out.println("]");
    }

    // main de prueba para ejecutar directamente ListaDoble
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();
        ld.insertarFin(1);
        ld.insertarFin(2);
        ld.insertarFin(3);

        System.out.print("Forward: ");
        ld.mostrarForward();
        System.out.print("Backward: ");
        ld.mostrarBackward();

        ld.insertarInicio(0);
        System.out.print("Después insertarInicio(0): ");
        ld.mostrarForward();

        ld.insertarEnPosicion(5, 2);
        System.out.print("Después insertarEnPosicion(5,2): ");
        ld.mostrarForward();

        System.out.println("Eliminar inicio: " + ld.eliminarInicio());
        System.out.println("Eliminar fin: " + ld.eliminarFin());
        System.out.print("Final: ");
        ld.mostrarForward();
    }
}
