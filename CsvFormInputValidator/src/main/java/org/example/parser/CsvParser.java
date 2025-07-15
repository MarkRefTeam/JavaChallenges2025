package org.example.parser;

import org.example.model.UserComment;
import org.example.sanitizer.InputSanitizer;
import org.example.validator.ValidatorService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<UserComment> parse(String pathToCsv) {
        List<UserComment> result = new ArrayList<>();

        try (InputStream is = CsvParser.class.getClassLoader().getResourceAsStream(pathToCsv);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            if (is == null) {
                System.err.println("Resource file not found: " + pathToCsv);
                return result;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length != 3) {
                    System.err.println("Wrong line (isn't 3 field): " + line);
                    continue;
                }

                String username = InputSanitizer.sanitize(parts[0].trim());
                String email = InputSanitizer.sanitize(parts[1].trim());
                String comment = InputSanitizer.sanitize(parts[2].trim());

                //Single Responsibility Principle!
                boolean valid = ValidatorService.isValid(username, email, comment);
                UserComment userComment = new UserComment(username, email, comment);
                //Csongi! That homework is super challenging...

                if (valid) {
                    System.out.println("OK: " + userComment);
                    result.add(userComment);
                } else {
                    System.err.println("Invalid fields: " + userComment);
                }
            }
        } catch (IOException e) {
            System.out.println("Error during file reading: " + e.getMessage());
        }
        return result;
    }
}
