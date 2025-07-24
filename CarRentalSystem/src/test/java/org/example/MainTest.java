package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUPStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainOutputContainsExpectedTexts() {
        Main.main(new String[]{});

        String output = outContent.toString();

        assertTrue(output.contains("is locked due to too many failed attempts") || output.contains("has been locked out"),
                "User lockout message should appear");
        assertTrue(output.contains("Your IP is banned, access denied.") || output.contains("Is 192.168.0.2 banned? true"),
                "IP ban messages should appear");
        assertTrue(output.contains("Available cars:"),
                "Available cars header should be printed");
        assertTrue(output.contains("Renting a car:"),
                "Renting a car message should be printed");
        assertTrue(output.contains("Mercedes") || output.contains("Trabant") || output.contains("BMW"),
                "Car brands should be displayed");
    }
}