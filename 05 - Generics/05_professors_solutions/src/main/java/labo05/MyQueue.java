package labo05;

import java.util.LinkedList;
import java.util.List;

// Les Queue sont FIFO (First In First Out - Premier entré, premier sorti).
// Comme une file d'attente à une caisse de supermarché.
public class MyQueue<E> {
    private final List<E> list = new LinkedList<>();

    public boolean offer(E e) {
        return list.add(e);
    }

    public E poll() {
        if (!isEmpty()) {
            return list.remove(0);
        }
        return null;
    }

    public E peek() {
        if (!isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
