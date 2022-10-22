package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryDictionary<KEY, VALUE> implements Dictionary<KEY, VALUE>, Filterable<VALUE>, Iterable<VALUE> {
    DictNode<KEY, VALUE> root;

    @Override
    public VALUE get(KEY key) {
        if (key != null) {
            DictNode<KEY, VALUE> branch = root;
            do {
                if (branch.key.hashCode() == key.hashCode() && branch.key.equals(key)) {
                    return branch.value;
                } else {
                    if (key.hashCode() >= branch.key.hashCode()) {
                        branch = branch.right;
                    } else {
                        branch = branch.left;
                    }
                }
            } while (branch != null);
        }

        return null;
    }

    @Override
    public void put(KEY key, VALUE value) {
        if (key != null) {
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
                            return;
                        } else {
                            branch = branch.right;
                        }
                    } else {
                        if (branch.left == null) {
                            branch.left = newNode;
                            return;
                        } else branch = branch.left;
                    }
                } while (true);
            }
        }

    }

    @Override
    public List<VALUE> filter(ValueFilter<VALUE> valueValueFilter) {
        List<VALUE> res = new ArrayList<>();
        for (VALUE value : this) {
            if (valueValueFilter.filter(value)) {
                res.add(value);
            }
        }
        return res;
    }

    @Override
    public Iterator<VALUE> iterator() {
        return new Iterator<>() {

            DictNode<KEY, VALUE> currentNode;
            final Stack<DictNode<KEY, VALUE>> nodes = new Stack<>();

            {
                if (root == null) {
                    currentNode = null;
                } else {
                    currentNode = root;
                }

            }

            @Override
            public boolean hasNext() {
                return (currentNode != null);
            }

            @Override
            public VALUE next() {
                if (currentNode != null) {
                    VALUE res = currentNode.value;
                    if (currentNode.right != null) {
                        nodes.push(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        nodes.push(currentNode.left);
                    }
                    if (!nodes.isEmpty()) {
                        currentNode = nodes.pop();
                    } else {
                        currentNode = null;
                    }
                    return res;
                }

                return null;
            }
        };
    }

    @Override
    public String toString() {
        String res = "";
        for (VALUE value : this) {
            res += value + "\n";
        }
        return res;
    }
}
