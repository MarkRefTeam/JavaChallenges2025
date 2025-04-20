package org.example;


public class FiveDimensionalApp {

    //Return the number of strings that do not contain the letters “e”, “E”, or “r”.

    public static boolean isClean(String word) {
        return !word.contains("e") && !word.contains("E") && !word.contains("r");

        //ohhhh, I understand! So I call a boolean method for logic and after just call in the "IF" statement!
        //SOC (Separation of Concerns)  !!! yeah!
    }

    public static int countFilteredWords(String[][][][][] words) {

        int count = 0;

        for (String[][][][] superBlock : words) {
            for (String[][][] block : superBlock) {
                for (String[][] array : block) {
                    for (String[] row : array) {
                        for (String word : row) {
                            if (isClean(word)) {
                                //So here! (it's very good practice, and it's absolutely practical! Thank you!)
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    //Return a new 5D array with all strings replaced by their lengths.

    public static int[][][][][] replaceStringsWithLengths(String[][][][][] words) {
        int[][][][][] lengths = new int[words.length][][][][];

        for (int i = 0; i < words.length; i++) {
            lengths[i] = new int[words[i].length][][][];
            for (int j = 0; j < words[i].length; j++) {
                lengths[i][j] = new int[words[i][j].length][][];
                for (int k = 0; k < words[i][j].length; k++) {
                    lengths[i][j][k] = new int[words[i][j][k].length][];
                    for (int l = 0; l < words[i][j][k].length; l++) {
                        lengths[i][j][k][l] = new int[words[i][j][k][l].length];
                        for (int m = 0; m < words[i][j][k][l].length; m++) {
                            lengths[i][j][k][l][m] = words[i][j][k][l][m].length();
                        }
                    }
                }
            }
        }

        return lengths;
    }

    //Return the total number of characters across all strings that start and end with the same letter.

    public static int countSameStartEndLength(String[][][][][] words) {

        int total = 0;

        for (String[][][][] superBlock : words) {
            for (String[][][] block : superBlock) {
                for (String[][] array : block) {
                    for (String[] row : array) {
                        for (String word : row) {
                            if (!word.isEmpty() && word.charAt(0) == word.charAt(word.length() - 1)) {
                                total += word.length();
                            }
                        }
                    }
                }
            }
        }
        return total;
    }

    //Return one big string, which is the concatenation of all strings.

    public static String concatenateAllWords(String[][][][][] words) {

        StringBuilder result = new StringBuilder();

        for (String[][][][] superBlock : words) {
            for (String[][][] block : superBlock) {
                for (String[][] array : block) {
                    for (String[] row : array) {
                        for (String word : row) {
                            result.append(word);
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}