package org.example;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testMainOutput() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();

        assertTrue(output.contains("Vowels replaced: H*ll* W*rld, th*s *s my *x*m!"));
        assertTrue(output.contains("Custom replace: Hello World, this is my Test!"));
        assertTrue(output.contains("CSV file created: employees.csv"));


        System.setOut(System.out);
    }
}