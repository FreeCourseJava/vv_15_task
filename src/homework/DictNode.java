package homework;

public class DictNode<K, V> {
    K key;
    V value;

    DictNode<K, V> right;
    DictNode<K, V> left;
    DictNode<K, V> parent;


    public DictNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "\t\t<" + this.key + "> : " + this.value + "\n";
    }
}

