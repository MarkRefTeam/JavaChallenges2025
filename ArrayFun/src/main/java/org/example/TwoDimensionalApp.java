package org.example;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalApp {

    //Return the total number of vowels in a 2D array of strings.
    //(you don’t have to consider non-English vowels, only a, e, i, o and u).

    public static int countVowels2D(String[][] words) {
        int count = 0;

        for (String[] row : words) {
            for (String word : row) {
                for (char c : word.toLowerCase().toCharArray()) {
                    if ("aeiou".indexOf(c) != -1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Return the sum of the lengths of the longest string from each row (subarray).

    public static int sumOfLongestStrings(String[][] words) {
        int sum = 0;

        for (String[] row : words) {
            int maxLen = 0;
            for (String word : row) {
                if (word.length() > maxLen) {
                    maxLen = word.length();
                }
            }
            sum += maxLen;
        }
        return sum;
    }

    //Return a one-dimensional (in other words: flattened)
    //array of all strings in uppercase.

    public static String[] flattenToUpper(String[][] words) {

        List<String> result = new ArrayList<>();
        for (String[] row : words) {
            for (String word : row) {
                result.add(word.toUpperCase());
            }
        }
        return result.toArray(new String[0]);
    }

    //Return a new 2D array of booleans where each element is true
    //if the corresponding string contains a digit.

    public static boolean[][] containsDigit2D(String[][] words) {
        boolean[][] result = new boolean[words.length][];

        for (int i = 0; i < words.length; i++) {
            result[i] = new boolean[words[i].length];

            for (int j = 0; j < words[i].length; j++) {
                String word = words[i][j];
                result[i][j] = false;

                for (char c : word.toCharArray()) {
                    if (Character.isDigit(c)) {
                        result[i][j] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    //Return the average number of characters per string across all elements.

    public static double averageChartersPerString(String[][] words) {

        int totalChars = 0;
        int totalStrings = 0;

        for (String[] row : words) {
            for (String word : row) {
                totalChars += word.length();
                totalStrings++;
            }
        }
        return (double) totalChars / totalStrings;
    }
}
