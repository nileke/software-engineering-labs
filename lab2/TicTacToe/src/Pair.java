/**
 * Created by Nils on 2017-09-30.
 */

public class Pair<K,V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Pair() {}

    void setKey(K key) {
        this.key = key;
    }

    void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
