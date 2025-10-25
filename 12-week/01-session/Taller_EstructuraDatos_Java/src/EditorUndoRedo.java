import java.util.Stack;

/**
 * Simula un editor de texto con operaciones Deshacer/Rehacer usando dos pilas.
 * Operaciones: escribir(texto), borrar(n), undo(), redo(), getTexto().
 * Complejidad: push/pop O(1) amortizado.
 */
public class EditorUndoRedo {
    private final StringBuilder texto = new StringBuilder();
    private final Stack<Comando> pilaUndo = new Stack<>();
    private final Stack<Comando> pilaRedo = new Stack<>();

    // Interfaz comando para deshacer/rehacer
    private interface Comando { void undo(); void redo(); }

    public void escribir(String s) {
        int inicio = texto.length();
        texto.append(s);
        Comando c = new Comando() {
            @Override public void undo() { texto.delete(inicio, inicio + s.length()); }
            @Override public void redo() { texto.insert(inicio, s); }
        };
        registrar(c);
    }

    public void borrar(int n) {
        n = Math.min(n, texto.length());
        int desde = texto.length() - n;
        String borrado = texto.substring(desde);
        texto.delete(desde, texto.length());
        Comando c = new Comando() {
            @Override public void undo() { texto.append(borrado); }
            @Override public void redo() { texto.delete(texto.length() - borrado.length(), texto.length()); }
        };
        registrar(c);
    }

    private void registrar(Comando c) {
        pilaUndo.push(c);
        pilaRedo.clear();
    }

    public boolean undo() {
        if (pilaUndo.isEmpty()) return false;
        Comando c = pilaUndo.pop();
        c.undo();
        pilaRedo.push(c);
        return true;
    }

    public boolean redo() {
        if (pilaRedo.isEmpty()) return false;
        Comando c = pilaRedo.pop();
        c.redo();
        pilaUndo.push(c);
        return true;
    }

    public String getTexto() { return texto.toString(); }

    // Demo rápida
    public static void main(String[] args) {
        EditorUndoRedo ed = new EditorUndoRedo();
        ed.escribir("Hola");
        ed.escribir(" mundo");
        System.out.println(ed.getTexto()); // Hola mundo
        ed.borrar(6);
        System.out.println(ed.getTexto()); // Hola
        ed.undo();
        System.out.println(ed.getTexto()); // Hola mundo
        ed.undo(); ed.undo();
        System.out.println(ed.getTexto()); // ""
        ed.redo(); ed.redo();
        System.out.println(ed.getTexto()); // Hola mundo
    }
}
