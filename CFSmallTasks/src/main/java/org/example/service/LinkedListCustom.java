package org.example.service;


import java.util.ArrayList;
import java.util.List;

public class LinkedListCustom {

    //Well , the Node is a new class deposit data for next reference! Let's check!

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListCustom() {
        this.head = null;
    }

    //Its give a new elements to the list of end!

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; //if the list is empty that will be the first!
        } else {
            Node current = head;
            //Continue the count for found the last one element!
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; //the "next" field in the last one element is show you the new Node!
        }
    }

    //And we can call back all elements in the list with getAll method!

    public List<String> getAll() {
        List<String> elements = new ArrayList<>();
        Node current = head;
        while (current != null) {
            elements.add(current.data);
            current = current.next;
        }
        return elements;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String get(int index) {
        if(index < 0) throw new IndexOutOfBoundsException("Index cannot be negative");
        Node current = head;
        int count = 0;
        while(current != null) {
            if(count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    /** Okay Guys! So what's happened here and how it's work!??
     *
     * Inner Node Class:
     * -We created a static inner class called Node.
     * -Each node stores data (String data) and a reference to the next node (Node next).
     * -This is the fundamental building block of a linked list, enabling dynamic chaining of elements.
     *
     * Head Reference:
     * -The LinkedListCustom class has a field called head which points to the first node.
     * -If the list is empty, head is null.
     * -This reference allows us to always know where the list starts.
     *
     * Add(String data) Method:
     * -Adds a new element at the end of the list.
     * -If the list is empty (head == null), the new node becomes the head.
     * -Otherwise, we traverse to the last node and link the new node there.
     * -This method allows us to grow the list dynamically without fixed size limits.
     *
     * getAll() Method:
     * -Returns a List<String> containing all elements in order.
     * -Useful because linked lists don’t support random access by index directly.
     * -Converting to a list makes iteration and usage simpler.
     *
     * size() Method:
     * -Counts and returns the number of nodes by traversing the list.
     * -Linked lists don’t keep track of size internally, so we count dynamically.
     *
     * get(int index) Method:
     * -Traverses the list up to the given index and returns the node’s data at that position.
     * -Enables indexed access, although linked lists have linear time complexity for this.
     *
     * Testing:
     * We wrote a test to add elements and verify:
     * -That size() returns the correct count.
     * -That get() returns the correct elements by index.
     * Tests ensure our code works correctly and help detect future regressions.
     *
     * Okay I'm doing some more for understanding!
     */
}