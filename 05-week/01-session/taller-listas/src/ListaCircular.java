// ListaCircular.java
public class ListaCircular {
    private Nodo cabeza;
    private int tamaño;

    public ListaCircular() {
        cabeza = null;
        tamaño = 0;
    }

    public void insertarFin(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) actual = actual.siguiente;
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        tamaño++;
    }

    public boolean insertarEnPosicion(int valor, int pos) {
        if (pos < 0 || pos > tamaño) return false;
        if (pos == 0) {
            Nodo n = new Nodo(valor);
            if (cabeza == null) {
                cabeza = n;
                cabeza.siguiente = cabeza;
            } else {
                Nodo last = cabeza;
                while (last.siguiente != cabeza) last = last.siguiente;
                n.siguiente = cabeza;
                cabeza = n;
                last.siguiente = cabeza;
            }
            tamaño++;
            return true;
        }
        Nodo actual = cabeza;
        for (int i = 0; i < pos - 1; i++) actual = actual.siguiente;
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamaño++;
        return true;
    }

    public Integer eliminarEnPosicion(int pos) {
        if (cabeza == null || pos < 0 || pos >= tamaño) return null;
        if (pos == 0) {
            int val = cabeza.dato;
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                Nodo last = cabeza;
                while (last.siguiente != cabeza) last = last.siguiente;
                cabeza = cabeza.siguiente;
                last.siguiente = cabeza;
            }
            tamaño--;
            return val;
        }
        Nodo actual = cabeza;
        for (int i = 0; i < pos - 1; i++) actual = actual.siguiente;
        int val = actual.siguiente.dato;
        actual.siguiente = actual.siguiente.siguiente;
        tamaño--;
        return val;
    }

    public void mostrar(int nElementos) {
        if (cabeza == null) {
            System.out.println("[]");
            return;
        }
        Nodo actual = cabeza;
        System.out.print("[");
        for (int i = 0; i < Math.min(nElementos, tamaño); i++) {
            System.out.print(actual.dato);
            if (i != Math.min(nElementos, tamaño) - 1) System.out.print(", ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}
