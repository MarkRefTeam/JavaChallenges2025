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

    //public static String[][][][] reverseAllStrings(String[][][][] words) {

        //Sorry, I don't know that! I'm learning just now!!

        //int wLen = words.length;
        //int xLen = words[0].length;
        //int yLen = words[0][0].length;
        //int zLen = words[0][0][0].length;

        //String[][][][] reversed = new String[wLen][xLen][yLen][zLen];

        //for (int w = 0; w < wLen; w++) {
            //for (int x = 0; x < xLen; x++) {
                //for (int y = 0; y < yLen; y++) {
                    //for (int z = 0; z < zLen; z++) {
                        //tring original = words[w][x][y][z];
                        //String reversedWord = new StringBuilder(original).reverse().toString();
                        //reversed[w][x][y][z] = reversedWord;
                   // }
               // }
           // }
        //}
       // return reversed;
    //}

    /** well, your comment was so interesting!
     * I'm sorry, but my current skill level hasn't reached this point yet.
     * Still, I really appreciate that you believe I'm capable of solving it!
     * This kind of solution might only be within my reach in a few months.
     * Please be patient with me – I promise I'll get there and learn it!
     */

    //So, here coming the alternative version :

    public static List<List<List<List<String>>>> reverseAllStrings(String[][][][] words) {

        //Explanation:
        //This line defines a public static method called reverseAllStrings.
        //It takes a 4D array of strings (String[][][][] words) as input,
        //and it will return a 4D List-based structure (List<List<List<List<String>>>>).
        //Why use List<List<...>> instead of arrays?
        //Because lists are dynamic – they don't need a fixed size and are more flexible when working with unknown.
        //or uneven structures (like subarrays of different lengths).

        List<List<List<List<String>>>> reversed = new ArrayList<>();

        //Explanation:
        //Here we're creating the outermost list for the reversed result.
        //This will hold all the nested lists inside, following the same 4D shape as the original array.
        //We’re starting with an empty list, and we’ll fill it later as we loop through the dimensions.
        //You can think of it like this:
        //I'm setting up a new empty 4D list, and I'm going to fill it with the reversed strings later.

        for (String[][][] level1 : words) {
            List<List<List<String>>> level1List = new ArrayList<>();
            //We iterate over the first dimension of the 4D array (words).
            //For each level1, we create a new list to hold 3D levels (List of List).
            for (String[][] level2 : level1) {
                List<List<String>> level2List = new ArrayList<>();
                //Now we're inside the second dimension.
                for (String[] level3 : level2) {
                    List<String> level3List = new ArrayList<>();
                    //In the third level, we're working with 1D arrays of strings.
                    for (String word : level3) {
                        String reversedWord = new StringBuilder(word).reverse().toString();
                        level3List.add(reversedWord);
                        //This is the final, innermost level – the actual strings.
                    }
                    level2List.add(level3List);
                }
                level1List.add(level2List);
            }
            reversed.add(level1List);
        }

        return reversed;
        //Same core logic with a new structural build! Okay Csongi, I can understand it!!
    }

    //Return the average length of all strings, rounded down to the nearest integer.

    public static int averageStringLength(String[][][][] words) {

        int totalLength = 0;
        int wordCount = 0;

        for (String[][][] block : words) {
            for (String[][] array : block) {
                for (String[] row : array) {
                    for (String word : row) {
                        if (word != null) {  //Defence against Zero!
                            totalLength += word.length();
                            wordCount++;
                        }
                    }
                }
            }
        }
        return wordCount == 0 ? 0 : totalLength / wordCount; //Defence against divisible by Zero!
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
                        for (char c : word.toLowerCase().toCharArray()) {
                            if ("aeiou".indexOf(c) != -1) {
                                vowelCount++;
                                // Thanks for the feedback! :)
                                // You're absolutely right — I totally forgot about capital vowels.
                                // I'll probably extract the vowel counting into a separate method later.
                                // Thanks again, I'll keep that in mind!
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
