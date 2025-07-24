package org.example;

import org.example.Security.AntiHackSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AntiHackSystemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testLockoutAfterFailedAttempts() {
        AntiHackSystem antiHack = new AntiHackSystem();
        String user = "testUser";

        for (int i = 0; i < 5; i++) {
            antiHack.recordFailedAttempt(user);
        }

        assertTrue(antiHack.isLocked(user));

        String output = outContent.toString();
        assertTrue(output.contains("locked out"));
    }
}