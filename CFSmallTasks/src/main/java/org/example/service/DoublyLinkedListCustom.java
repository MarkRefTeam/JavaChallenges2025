package org.example.service;

public class DoublyLinkedListCustom {

    private static class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }


    public DoublyLinkedListCustom() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public String removeFirst() {
        if (head == null) {
            return null;
        }

        String data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public String removeLast() {
        if (tail == null) {
            return null;
        }

        String data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public String getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public String getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    public String add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return data;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + size);
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if(currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}