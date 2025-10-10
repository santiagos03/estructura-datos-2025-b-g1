public class HashTable<K,V> {
    private Entry<K,V>[] buckets;
    private int capacity;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = Math.max(1, capacity);
        this.buckets = (Entry<K,V>[]) new Entry[this.capacity];
    }

    public HashTable() {
        this(16);
    }

    private int indexFor(K key) {
        int h = key.hashCode();
        return (h & 0x7fffffff) % capacity;
    }

    public V put(K key, V value) {
        if (key == null) throw new NullPointerException("Null keys not supported");
        int idx = indexFor(key);
        Entry<K,V> head = buckets[idx];
        for (Entry<K,V> cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                V old = cur.value;
                cur.value = value;
                return old;
            }
        }
        buckets[idx] = new Entry<>(key, value, head);
        size++;
        return null;
    }

    public V get(K key) {
        if (key == null) return null;
        int idx = indexFor(key);
        for (Entry<K,V> cur = buckets[idx]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) return cur.value;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) return null;
        int idx = indexFor(key);
        Entry<K,V> cur = buckets[idx];
        Entry<K,V> prev = null;
        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) buckets[idx] = cur.next;
                else prev.next = cur.next;
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Método de utilidad para pruebas: muestra el estado interno
    public String debugBuckets() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(i).append(":");
            Entry<K,V> cur = buckets[i];
            while (cur != null) {
                sb.append(" -> (").append(cur.key).append(",").append(cur.value).append(")");
                cur = cur.next;
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}