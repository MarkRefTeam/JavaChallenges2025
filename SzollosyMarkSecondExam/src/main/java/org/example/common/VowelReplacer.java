package org.example.common;

public class VowelReplacer {

    public static String replaceVowels(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("(?i)[aeiou]", "*");
    }
}