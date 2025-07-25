package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListCustomTest {

    private DoublyLinkedListCustom doublyLinkedListCustom;

    @BeforeEach
    void setup() {
        doublyLinkedListCustom = new DoublyLinkedListCustom();
    }

    @Test
    void testAddFirst() {
        doublyLinkedListCustom.addFirst("first");
        doublyLinkedListCustom.addFirst("second");
        assertEquals(2, doublyLinkedListCustom.size());
        assertEquals("second", doublyLinkedListCustom.getFirst());
    }

    @Test
    void testAddLast() {
        doublyLinkedListCustom.addLast("Last");
        assertEquals(1, doublyLinkedListCustom.size());
        assertEquals("Last", doublyLinkedListCustom.getLast());
    }

    @Test
    void testRemoveFirst() {
        doublyLinkedListCustom.addLast("first");
        doublyLinkedListCustom.addLast("second");

        String removed = doublyLinkedListCustom.removeFirst();
        assertEquals("first", removed);
        assertEquals(1, doublyLinkedListCustom.size());
        assertEquals("second", doublyLinkedListCustom.getFirst());
    }

    @Test
    void testRemoveLast() {
        doublyLinkedListCustom.addFirst("last");
        doublyLinkedListCustom.addFirst("second");

        String removed = doublyLinkedListCustom.removeLast();
        assertEquals("last", removed);
        assertEquals(1, doublyLinkedListCustom.size());
        assertEquals("second", doublyLinkedListCustom.getLast());
    }

    @Test
    void testGetFirst() {
        doublyLinkedListCustom.addFirst("first");
        doublyLinkedListCustom.addFirst("second");

        String firstElement = doublyLinkedListCustom.getFirst();
        assertEquals("second", firstElement, "The first element should be 'second'");
    }


    @Test
    void testGetLast() {
        doublyLinkedListCustom.addFirst("first");
        doublyLinkedListCustom.addLast("last");

        String lastElement = doublyLinkedListCustom.getLast();
        assertEquals("last", lastElement, " The last element should be a 'last'");
    }

    @Test
    void testSize() {
        doublyLinkedListCustom.add("first");
        doublyLinkedListCustom.add("second");

        assertEquals(2, doublyLinkedListCustom.size());
    }

    @Test
    void testGet() {
        doublyLinkedListCustom.add("first");
        doublyLinkedListCustom.add("second");

        assertEquals("first", doublyLinkedListCustom.get(0));
        assertEquals("second", doublyLinkedListCustom.get(1));
    }
}