package structures.stack;

import structures.simpleList.Node;

import java.util.Iterator;

public class StackIterator<T> implements Iterator<T> {
    private Node<T> actual;

    public StackIterator(Node<T> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T data = actual.getData();
        actual = actual.getNext();
        return data;
    }
}
