/**
 * Árbol AVL con inserción y detección de rotaciones (LL, RR, LR, RL).
 * Alturas y balance O(1) por nodo; inserción O(log n).
 */
public class AVLTree {
    static class Nodo { int v, h=1; Nodo izq, der; Nodo(int v){this.v=v;} }
    Nodo raiz;

    private int h(Nodo n){ return n==null?0:n.h; }
    private int bal(Nodo n){ return n==null?0:h(n.izq)-h(n.der); }
    private void act(Nodo n){ n.h = 1 + Math.max(h(n.izq), h(n.der)); }

    private Nodo rotDer(Nodo y){
        Nodo x = y.izq; Nodo T2 = x.der;
        x.der = y; y.izq = T2; act(y); act(x);
        System.out.println("Rotación RR (derecha) sobre " + y.v + " -> raíz subárbol " + x.v);
        return x;
    }
    private Nodo rotIzq(Nodo x){
        Nodo y = x.der; Nodo T2 = y.izq;
        y.izq = x; x.der = T2; act(x); act(y);
        System.out.println("Rotación LL (izquierda) sobre " + x.v + " -> raíz subárbol " + y.v);
        return y;
    }

    public void insertar(int v){ raiz = insertarRec(raiz, v); }
    private Nodo insertarRec(Nodo n, int v){
        if(n==null) return new Nodo(v);
        if(v < n.v) n.izq = insertarRec(n.izq, v); else if(v>n.v) n.der = insertarRec(n.der, v); else return n;
        act(n);
        int b = bal(n);
        // 4 casos
        if(b>1 && v < n.izq.v){ // LL -> rotación derecha
            System.out.println("Caso LL");
            return rotDer(n);
        }
        if(b<-1 && v > n.der.v){ // RR -> rotación izquierda
            System.out.println("Caso RR");
            return rotIzq(n);
        }
        if(b>1 && v > n.izq.v){ // LR
            System.out.println("Caso LR");
            n.izq = rotIzq(n.izq);
            return rotDer(n);
        }
        if(b<-1 && v < n.der.v){ // RL
            System.out.println("Caso RL");
            n.der = rotDer(n.der);
            return rotIzq(n);
        }
        return n;
    }

    public static void main(String[] args){
        AVLTree t = new AVLTree();
        int[] vals = {30, 20, 40, 10, 25, 22}; // fuerza un caso LR
        for(int v: vals) t.insertar(v);
    }
}
