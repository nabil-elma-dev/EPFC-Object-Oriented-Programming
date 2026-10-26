
package main.java.labo05;

import java.util.LinkedList;
import java.util.List;

// Les Queue sont FIFO (First In First Out - Premier entré, premier sorti).
// Comme une file d'attente à une caisse de supermarché.
public class MyQueue<E> {
    private final List<E> li = new LinkedList<>();

    public boolean offer(E e) {
        return li.add(e);
    }

    public E poll() {
        return li.isEmpty() ?
            null
            : li.removeFirst();
    }

    public E peek() {
        return li.isEmpty() ?
                null
                : li.getFirst();
    }

    public boolean isEmpty() {
        return li.isEmpty();
    }

    public int size() {
        return li.size();
    }

}
