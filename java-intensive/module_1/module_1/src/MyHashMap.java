import java.util.*;

/**
 * Простая реализация HashMap с методами put, get и remove
 */
public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    private Node<K, V>[] table = new Node[DEFAULT_CAPACITY];
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    private static class Node<K, V> implements Entry<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private int hash(Object key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public V get(Object key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (key == null ? node.key == null : key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = table[index];

        // Если бакет пуст просто вставляем
        if (node == null) {
            table[index] = new Node<>(key, value, null);
            size++;
            resizeIfNeeded();
            return null;
        }

        // Ищем существующий ключ
        Node<K, V> prev = null;
        while (node != null) {
            if (key == null ? node.key == null : key.equals(node.key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            prev = node;
            node = node.next;
        }

        // Если ключ не найден добавляем в конец цепочки
        prev.next = new Node<>(key, value, null);
        size++;
        resizeIfNeeded();
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        while (node != null) {
            if (key == null ? node.key == null : key.equals(node.key)) {
                if (prev == null) {
                    table[index] = node.next; // Удаляем голову
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        Node<K, V>[] oldTable = table;
        table = new Node[capacity];
        size = 0;

        // Перехешируем все элементы
        for (Node<K, V> head : oldTable) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    private void resizeIfNeeded() {
        if (size > capacity * LOAD_FACTOR) {
            resize();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> head : table) {
            while (head != null) {
                if (value == null ? head.value == null : value.equals(head.value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Node<K, V> head : table) {
            while (head != null) {
                keys.add(head.key);
                head = head.next;
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (Node<K, V> head : table) {
            while (head != null) {
                values.add(head.value);
                head = head.next;
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Node<K, V> head : table) {
            while (head != null) {
                entries.add(new AbstractMap.SimpleImmutableEntry<>(head.key, head.value));
                head = head.next;
            }
        }
        return entries;
    }
}