package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void testMainOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});


        System.setOut(originalOut);

        String output = outputStream.toString();


        assertTrue(output.contains("Emails in system:"));
        assertTrue(output.contains("mark@example.com"));
        assertTrue(output.contains("anna@example.com"));
        assertTrue(output.contains("Was duplicate added? false"));
        assertTrue(output.contains("Emails after updates:"));
    }
}
