
package main.java.labo05;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

// Les Stacks sont LIFO (Last In First Out - Dernier entré, premier sorti).
// Comme les assiettes au sommet d'une pile.    
public class MyStack<E> {
    private final List<E> li = new LinkedList<>();

    public E push(E item) {
        li.add(item);
        return item;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException(); // source: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
        return li.removeLast();
    }

    public E peek() {
        return li.isEmpty() ?
                null
                : li.getLast();
    }

    public boolean isEmpty() {
        return li.isEmpty();
    }

    public int size() {
        return li.size();
    }
}
