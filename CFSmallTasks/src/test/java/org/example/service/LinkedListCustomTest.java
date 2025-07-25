package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListCustomTest {

    private LinkedListCustom linkedListCustom;

    @BeforeEach
    void setup() {
        linkedListCustom = new LinkedListCustom();
    }

    @Test
    void testAddAndGetSize() {
        linkedListCustom.add("first");
        linkedListCustom.add("second");
        assertEquals(2, linkedListCustom.size());
        assertEquals("first", linkedListCustom.get(0));
        assertEquals("second", linkedListCustom.get(1));
    }
}
