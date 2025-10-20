package org.example;

import org.example.common.VowelReplacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VowelReplacerTest {
    @Test
    void testReplaceVowels_basic() {
        assertEquals("H*ll* W*rld", VowelReplacer.replaceVowels("Hello World"));
    }

    @Test
    void testReplaceVowels_empty() {
        assertEquals("", VowelReplacer.replaceVowels(""));
    }

    @Test
    void testReplaceVowels_null() {
        assertNull(VowelReplacer.replaceVowels(null));
    }
}
