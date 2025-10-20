package org.example.common;

import java.util.Objects;
import java.util.regex.Pattern;

public final class TextUtils {
    private static final Pattern VOWELS = Pattern.compile("(?i)[aeiou]");

    private TextUtils() {}

    public static String replaceAll(String input, String regex, String replacement) {
        if (input == null) return null;
        Objects.requireNonNull(regex, "regex must not be null");
        Objects.requireNonNull(replacement, "replacement must not be null");
        return input.replaceAll(regex, replacement);
    }

    public static String replaceVowels(String input) {
        if (input == null) return null;
        return VOWELS.matcher(input).replaceAll("*");
    }
}
