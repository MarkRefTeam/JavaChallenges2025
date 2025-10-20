package com.markref.security.simulate;

import com.markref.security.security.Isolator;
import org.junit.jupiter.api.Test;

public class IsolatorTest {

    @Test
    void testIsolator() {
        Isolator isolator = new Isolator();

        isolator.isolate("infected file");
    }
}