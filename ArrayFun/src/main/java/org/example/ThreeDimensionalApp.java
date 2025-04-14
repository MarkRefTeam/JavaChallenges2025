package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThreeDimensionalApp {

    //Return the number of strings that are palindromes,
    //(same forward and backward - for example,
    //“race-car” is read the same way if you read it from forward and backward).

    /**
     * Ez a metódus megszámolja, hogy hány olyan szó van egy 3 dimenziós tömbben,
     * amely palindrom (előlről és hátulról olvasva is ugyanaz).
     *
     * A fő logikát szétválasztottuk egy külön metódusba (isPalindrome),
     * hogy olvashatóbb, modulárisabb és könnyebben tesztelhető legyen a kód.
     * Ez egy jó gyakorlat: a különálló felelősségeket külön metódusokba szervezzük,
     * így ha például a palindrom logikán változtatni kell, nem kell a fő ciklusban turkálni.
     *
     * @param words Egy 3 dimenziós String tömb, amelyben a szavakat keressük.
     * @return A palindrom szavak száma.
     */

    /**
     * This method counts how many strings in a 3-dimensional array are palindromes
     * (i.e., they read the same forward and backward).
     * <p>
     * We separated the core logic into a helper method (isPalindrome) to keep the
     * main loop clean, readable, and modular. This is a good practice known as
     * separation of concerns — each method handles a single responsibility.
     * It also makes the code easier to test and maintain.
     * If the palindrome-checking logic needs to change later, we don’t have to
     * touch the iteration logic.
     *
     * @param words A 3D String array containing the strings to check.
     * @return The number of palindrome strings.
     */

    public static int thePalindromicTask(String[][][] words) {

        int count = 0;

        for (String[][] array : words) {
            for (String[] row : array) {
                for (String word : row) {
                    if (isPalindrome(word)) {
                        //String reversed = new StringBuilder(word).reverse().toString();
                        //if(word.equals(reversed))
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String word) {

        return word.equals(new StringBuilder(word).reverse().toString());
    }

    //Return a 1D array of integers representing the
    //number of strings in each sub-subarray (3rd level).

    public static int[] countStringsInSubSubarrays(String[][][] words) {

        List<Integer> result = new ArrayList<>();

        for (String[][] array : words) {
            for (String[] row : array) {
                result.add(row.length);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //Return the concatenation of all strings,
    //but skip strings shorter than 2 characters.

    public static String concatenationWithString(String[][][] words) {

        StringBuilder result = new StringBuilder();

        for (String[][] array : words) {
            for (String[] row : array) {
                for (String word : row) {
                    if (word.length() >= 2) {
                        result.append(word);
                    }
                }
            }
        }
        return result.toString();
    }

    //Return the maximum length of a string in the entire 3D array.

    public static int getLongestWordLength(String[][][] words) {

        int maxLength = 0;

        for (String[][] array : words) {
            for (String[] row : array) {
                for (String word : row) {
                    if (word.length() > maxLength) {
                        maxLength = word.length();
                    }
                }
            }
        }
        return maxLength;
    }

    //Return true if every subarray (3rd level)
    //contains at least one string that ends with "s".

    public static boolean allSubarraysContainWordEndingWithS(String[][][] words) {

        for (String[][] array : words) {
            for (String[] row : array) {
                boolean found = false;
                for (String word : row) {
                    if (word.endsWith("s")) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
}