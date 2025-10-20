package com.markref.security.simulate;

import com.markref.security.security.SecurityController;
import org.junit.jupiter.api.Test;

public class SecurityControllerTest {

    @Test
    void testMonitor() {
        SecurityController controller = new SecurityController();

        controller.monitor("infected system");
        controller.monitor("clean system");
    }
}