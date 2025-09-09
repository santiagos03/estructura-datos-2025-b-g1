// ListaSimple.java
public class ListaSimple {
    private Nodo cabeza;
    private int tamaño;

    public ListaSimple() {
        cabeza = null;
        tamaño = 0;
    }

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    public void insertarFin(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public boolean insertarEnPosicion(int valor, int pos) {
        if (pos < 0 || pos > tamaño) return false;
        if (pos == 0) {
            insertarInicio(valor);
            return true;
        }
        Nodo nuevo = new Nodo(valor);
        Nodo actual = cabeza;
        for (int i = 0; i < pos - 1; i++) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamaño++;
        return true;
    }

    public Integer eliminarInicio() {
        if (cabeza == null) return null;
        int val = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamaño--;
        return val;
    }

    public Integer eliminarFin() {
        if (cabeza == null) return null;
        if (cabeza.siguiente == null) {
            int val = cabeza.dato;
            cabeza = null;
            tamaño--;
            return val;
        }
        Nodo actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        int val = actual.siguiente.dato;
        actual.siguiente = null;
        tamaño--;
        return val;
    }

    public Integer eliminarEnPosicion(int pos) {
        if (pos < 0 || pos >= tamaño || cabeza == null) return null;
        if (pos == 0) return eliminarInicio();
        Nodo actual = cabeza;
        for (int i = 0; i < pos - 1; i++) actual = actual.siguiente;
        int val = actual.siguiente.dato;
        actual.siguiente = actual.siguiente.siguiente;
        tamaño--;
        return val;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("[");
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) System.out.print(", ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}
