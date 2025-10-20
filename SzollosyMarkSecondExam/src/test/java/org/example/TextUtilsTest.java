package org.example;

import org.example.common.TextUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TextUtilsTest {

    @Test
    void testReplaceAll_general() {
        assertEquals("H_llo World", TextUtils.replaceAll("Hello World", "e", "_"));
    }

    @Test
    void testReplaceVowels() {
        assertEquals("H*ll* W*rld", TextUtils.replaceVowels("Hello World"));
    }

    @Test
    void testReplaceAll_null() {
        assertNull(TextUtils.replaceAll(null, "a", "*"));
    }
}
