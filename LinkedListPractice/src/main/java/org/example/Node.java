package org.example;

public class Node<T> {

    private T value;
    private Node<T> next;

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }
}