/**
 * Árbol Binario básico con recorridos DFS.
 */
public class ArbolBinario {
    static class Nodo { int valor; Nodo izq, der; Nodo(int v){valor=v;} }
    Nodo raiz;

    public void insertar(int v){ raiz = insertarRec(raiz, v); }
    private Nodo insertarRec(Nodo n, int v){
        if(n==null) return new Nodo(v);
        if(v < n.valor) n.izq = insertarRec(n.izq, v); else n.der = insertarRec(n.der, v);
        return n;
    }

    public void preorden(Nodo n){ if(n==null) return; System.out.print(n.valor+" "); preorden(n.izq); preorden(n.der);}
    public void inorden(Nodo n){ if(n==null) return; inorden(n.izq); System.out.print(n.valor+" "); inorden(n.der);}
    public void postorden(Nodo n){ if(n==null) return; postorden(n.izq); postorden(n.der); System.out.print(n.valor+" ");}

    public static void main(String[] args){
        ArbolBinario t=new ArbolBinario();
        int[] vals={8,3,10,1,6,14,4,7,13};
        for(int v: vals) t.insertar(v);
        System.out.print("Preorden: "); t.preorden(t.raiz); System.out.println();
        System.out.print("Inorden: "); t.inorden(t.raiz); System.out.println();
        System.out.print("Postorden: "); t.postorden(t.raiz); System.out.println();
    }
}
