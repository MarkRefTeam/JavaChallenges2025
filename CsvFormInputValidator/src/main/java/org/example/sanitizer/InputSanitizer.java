package org.example.sanitizer;

import static java.util.Collections.replaceAll;

public class InputSanitizer {
    public static String sanitize(String input) {
        return input
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;");
    }
}
