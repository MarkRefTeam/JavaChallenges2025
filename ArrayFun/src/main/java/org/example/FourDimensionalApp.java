package org.example;

import java.util.ArrayList;
import java.util.List;

public class FourDimensionalApp {

    //Return the total count of strings that contain only lowercase letters.
    //Note: you can use Character.isLowerCase() to decide whether a character is lowercase or not.

    public static int countLowerCaseWords(String[][][][] words) {

        int count = 0;

        for (String[][][] block : words) {
            for (String[][] array : block) {
                for (String[] row : array) {
                    for (String word : row) {
                        boolean allLowerCase = true;
                        for (char c : word.toCharArray()) {
                            if (!Character.isLowerCase(c)) {
                                allLowerCase = false;
                                break;
                            }
                        }
                        if (allLowerCase) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static String[][][][] reverseAllStrings(String[][][][] words) {

        //Sorry, I don't know that! I'm learning just now!!

        int wLen = words.length;
        int xLen = words[0].length;
        int yLen = words[0][0].length;
        int zLen = words[0][0][0].length;

        String[][][][] reversed = new String[wLen][xLen][yLen][zLen];

        for (int w = 0; w < wLen; w++) {
            for (int x = 0; x < xLen; x++) {
                for (int y = 0; y < yLen; y++) {
                    for (int z = 0; z < zLen; z++) {
                        String original = words[w][x][y][z];
                        String reversedWord = new StringBuilder(original).reverse().toString();
                        reversed[w][x][y][z] = reversedWord;
                    }
                }
            }
        }
        return reversed;
    }

    //Return the average length of all strings, rounded down to the nearest integer.

    public static int averageStringLength(String[][][][] words) {

        int totalLength = 0;
        int wordCount = 0;

        for (String[][][] block : words) {
            for (String[][] array : block) {
                for (String[] row : array) {
                    for (String word : row) {
                        totalLength += word.length();
                        wordCount++;
                    }
                }
            }
        }
        return totalLength / wordCount;
    }

    //Return a list of all strings that contain more than two vowels.
    //(you don’t have to consider non-English vowels, only a, e, i, o and u).

    public static List<String> findVowelRichWords(String[][][][] words) {

        List<String> result = new ArrayList<>();

        for (String[][][] block : words) {
            for (String[][] array : block) {
                for (String[] row : array) {
                    for (String word : row) {
                        int vowelCount = 0;
                        for (char c : word.toCharArray()) {
                            if ("aeiou".indexOf(c) != -1) {
                                vowelCount++;
                            }
                        }
                        if (vowelCount > 2) {
                            result.add(word);
                        }
                    }
                }
            }
        }
        return result;
    }

    //Return the shortest string across all dimensions.

    public static String findShortestWord(String[][][][] words) {

        String shortest = null;

        for (String[][][] block : words) {
            for (String[][] array : block) {
                for (String[] row : array) {
                    for (String word : row) {
                        if (shortest == null || word.length() < shortest.length()) {
                            shortest = word;
                        }
                    }
                }
            }
        }
        return shortest;
    }
}
