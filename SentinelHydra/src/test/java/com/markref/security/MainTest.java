package com.markref.security;

import com.markref.security.logging.Logger;
import com.markref.security.util.ConsoleColors;
import com.markref.security.util.Print;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class MainTest {

    @Mock
    Logger consoleLogger;

    @Test
    void section_printsToStdout() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        try {
            System.setOut(new PrintStream(baos));
            Print.section("BOOT / WIRING", ConsoleColors.CYAN);
        } finally {
            System.setOut(oldOut);
        }
        String out = baos.toString();
        assertTrue(out.contains("BOOT / WIRING"));
        verifyNoInteractions(consoleLogger);
    }

    @Test
    void shutdownHook_logsMessage() {
        Thread hook = Main.installShutdownHook(consoleLogger);

        hook.run();

        verify(consoleLogger).log(ArgumentMatchers.contains("Hydra shutting down"));
    }
}
