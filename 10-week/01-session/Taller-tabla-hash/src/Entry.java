/**
 * Entry.java
 * Nodo simple para la lista de colisiones (encadenamiento).
 */
public class Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;

    Entry(K key, V value, Entry<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
