package labo05;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

// Les Stacks sont LIFO (Last In First Out - Dernier entré, premier sorti).
// Comme les assiettes au sommet d'une pile.    
public class MyStack<E> {
    private final List<E> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    public E push(E e) {
        list.add(e);
        return e;
    }

    public int size() {
        return list.size();
    }
}
