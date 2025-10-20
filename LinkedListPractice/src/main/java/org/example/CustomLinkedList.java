package org.example;

import java.util.Iterator;

public class CustomLinkedList<T> {

    private Node<T> first;

    public int size() {
        if (first == null) {
            return 0;
        }

        int counter = 0;
        Node<T> temp = first;
        while (temp != null) {
            temp =
        }
    }

    public T getIndex(int index) {
        Node<T> temp = first;
        for (int i = 0; i < index; i++) {
            if (temp.getNext() == null) {
                throw new IndexOutOfBoundsException();
            } else {
                temp = temp.getNext();
            }
            return temp;
        }
    }

    private Iterator<T> customLinkdListIterator = new Iterator<T>() {

        @Override
        public boolean hasNext() {
            return first != null && first.getNext() != null;
        }

        @Override
        public Node<T> next() {
            return current.getNext();
        }
    }
}
