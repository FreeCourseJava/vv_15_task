package homework;

import java.util.Iterator;
import java.util.List;

public class BinaryDictionary<KEY, VALUE> implements Dictionary<KEY, VALUE>, Filterable<VALUE>, Iterable<VALUE> {
    DictNode<KEY, VALUE> root;

    @Override
    public VALUE get(KEY key) {
        DictNode<KEY, VALUE> branch = root;
        do {
            if (branch.key.hashCode() == key.hashCode() && branch.key.equals(key)) {
                return branch.value;
            }
            else{
                if (key.hashCode() >= branch.key.hashCode()) {
                    branch = branch.right;
                } else {
                    branch = branch.left;
                }
            }
        } while (branch != null);

        return null;
    }

    @Override
    public void put(KEY key, VALUE value) {
        DictNode<KEY, VALUE> newNode = new DictNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            DictNode<KEY, VALUE> branch = root;

            do {
                if (key.hashCode() == branch.key.hashCode() && branch.key.equals(key)) {
                    System.err.println("Key-value pair<" + key + "," + value + "> can't be added, there is another value with the same key");
                    return;
                } else if (key.hashCode() >= branch.key.hashCode()) {
                    if (branch.right == null) {
                        branch.right = newNode;
                        newNode.parent = branch;
                        return;
                    } else {
                        branch = branch.right;
                    }
                } else {
                    if (branch.left == null) {
                        branch.left = newNode;
                        newNode.parent = branch;
                        return;
                    } else branch = branch.left;
                }
            } while (true);
        }

    }

    @Override
    public List<VALUE> filter(ValueFilter<VALUE> valueValueFilter) {
        return null;
    }

    @Override
    public Iterator<VALUE> iterator() {
        return new Iterator<VALUE>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public VALUE next() {
                return null;
            }
        };
    }
}
