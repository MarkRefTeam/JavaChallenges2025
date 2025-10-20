package org.example.Task2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueUserCounterTest {

    @Test
    void testUniqueUsers() {
        List<String> logs = new ArrayList<>(Arrays.asList("alice", "bob", "alice", "diana", "bob", "eli"));
        assertEquals(4, UniqueUserCounter.countUniqueUsers(logs));
    }

    @Test
    void testEmptyList() {
        assertEquals(0, UniqueUserCounter.countUniqueUsers(Arrays.asList()));
    }

    @Test
    void testNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> UniqueUserCounter.countUniqueUsers(null));
    }
}

