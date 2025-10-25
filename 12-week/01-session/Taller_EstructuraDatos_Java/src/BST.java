/**
 * Binary Search Tree estándar.
 */
public class BST {
    static class Nodo { int v; Nodo izq, der; Nodo(int v){this.v=v;} }
    Nodo raiz;

    public void insertar(int v){ raiz = ins(raiz, v); }
    private Nodo ins(Nodo n, int v){
        if(n==null) return new Nodo(v);
        if(v<n.v) n.izq = ins(n.izq, v); else if(v>n.v) n.der = ins(n.der, v);
        return n;
    }

    public boolean buscar(int v){ return bus(raiz, v) != null; }
    private Nodo bus(Nodo n, int v){
        if(n==null || n.v==v) return n;
        return v < n.v ? bus(n.izq, v) : bus(n.der, v);
    }

    public void eliminar(int v){ raiz = del(raiz, v); }
    private Nodo del(Nodo n, int v){
        if(n==null) return null;
        if(v<n.v) n.izq = del(n.izq, v);
        else if(v>n.v) n.der = del(n.der, v);
        else { // encontrado
            if(n.izq==null) return n.der;
            if(n.der==null) return n.izq;
            // dos hijos: reemplazar por el mínimo del subárbol derecho
            Nodo m = n.der; while(m.izq!=null) m = m.izq;
            n.v = m.v; n.der = del(n.der, m.v);
        }
        return n;
    }

    public static void main(String[] args){
        BST t=new BST();
        int[] vals={50,30,70,20,40,60,80};
        for(int v: vals) t.insertar(v);
        System.out.println("Buscar 60: "+t.buscar(60));
        t.eliminar(70);
        System.out.println("Buscar 70: "+t.buscar(70));
    }
}
