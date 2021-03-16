package structures.stack;

import structures.simpleList.Node;

import java.util.Comparator;
import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node<T> top;
    private Comparator<T> comparator;

    public Stack(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void push(T data){
        Node<T> aux = top;
        top = new Node<>(data);
        top.setNext(aux);
    }

    public T pop(){
        if (!isEmpty()){
            T aux = top.getData();
            top = top.getNext();
            return aux;
        }
        return null;
    }

    public boolean exist(T data){
        StackIterator<T> iterator = new StackIterator<>(top);
        while (iterator.hasNext()) {
            if (comparator.compare(iterator.next(),data) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public String show(){
        String data = "";
        StackIterator<T> iterator = new StackIterator<>(top);
        while (iterator.hasNext()){
            data += iterator.next() +"-";
        }
        return data;
    }

    public T peek(){
        if (top != null){
            return top.getData();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(top);
    }
}
