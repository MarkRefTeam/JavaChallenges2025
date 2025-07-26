package com.markref.security;

import com.markref.security.security.EngageDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngageDetectorTest {

    @Test
    void testDetectEngage() {
        EngageDetector detector = new EngageDetector();

        assertTrue(detector.detectEngage("System infected with malware"));
        assertFalse(detector.detectEngage("System running normally"));
        assertFalse(detector.detectEngage(null));
    }
}
