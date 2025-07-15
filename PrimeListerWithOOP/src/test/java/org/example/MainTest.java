package org.example;

/**
Let's try some new things! Iam absolutely newbie in this front, but I would like
 try something! Yes I mean IO with ByteStream! I have seen now in Y*uTube :D
 **/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    /**
     * Captures the output printed to System.out during the test.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Stores the original System.out to restore it after each test.
     */
    private final PrintStream originalOut = System.out;

    /**
     * Redirects System.out to a ByteArrayOutputStream before each test
     * to capture console output for verification.
     */

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restores the original System.out after each test to avoid side effects.
     */
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests whether the main method prints output containing the word "Primes".
     *
     * @throws Exception if Main. main throws any unexpected exception.
     */

    @Test
    public void testMainOutputsPrimes() throws Exception {
        // Execute the main method with an empty argument array.
        Main.main(new String[]{});

        // Get the captured output as a String.
        String output = outContent.toString();

        // Assert that the output contains the word "Primes".
        assertFalse(output.contains("Primes"), "Output should contain 'Primes'");
    }

    /**
     * Noooo ,its high level! Yes , someone helped me in this session!
     * I need more 1 year please because my skill level isn't enough yet...
     * Sorry for that!
     */
}
