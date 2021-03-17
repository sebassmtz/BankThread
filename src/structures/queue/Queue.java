package structures.queue;

import structures.simpleList.Node;

import java.util.Comparator;
import java.util.Iterator;

public class Queue<T> {
    private Node<T> head;
    private Comparator<T> comparator;

    public Queue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void push(T data){
        if (head == null){
            head = new Node<>(data);
        }else {
            Node<T> aux = head;
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(new Node<>(data));
        }
    }

    public T poll(){
        if (head != null){
            T auxData = head.getData();
            head = head.getNext();
            return auxData;
        }
        return null;
    }

    public T peek(){
        if (head != null){
            return head.getData();
        }
        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean exist(T data){
        Node<T> auxNode = head;
        while (auxNode != null) {
            if (comparator.compare(auxNode.getData(),data) == 0){
                return true;
            }
            auxNode = auxNode.getNext();
        }
        return false;
    }

    public String show(){
        String result = "";
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            result += iterator.next()+"-";
        }
        return result == ""? "Empty":result;
    }

    public Iterator<T> iterator(){
        return new QueueIterator<>(head);
    }
}
