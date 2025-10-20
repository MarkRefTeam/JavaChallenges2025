package org.example;

import java.util.*;

public class OneBetweenTenTask {

    //Write a method that …

    //Removes duplicates from a word.
    //Example: Input: "banana" → Output: "ban"

    public static String removeDuplicates(String input) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            seen.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : seen) {
            result.append(c);
        }

        return result.toString();
    }

    //Checks if two strings are anagrams
    //Input: "listen" and "silent" → Output: true

    //1.

    public static boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> freq1 = buildFrequencyMap(word1);
        Map<Character, Integer> freq2 = buildFrequencyMap(word2);

        return freq1.equals(freq2);
    }

    private static Map<Character, Integer> buildFrequencyMap(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    //2.

    public static boolean areAnagramsSorted(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    //Gets in two lists and returns with a third one that contains the union of the two lists, but each element can occur only once.
    //Input: [1, 2, 2, 1, 1],[1, 3, 4]  → Output: [1,2,3,4] (the order does not matter)

    public static List<Integer> getUniqueUnion(List<Integer> list1, List<Integer> list2) {
        Set<Integer> unionSet = new HashSet<>();
        unionSet.addAll(list1);
        unionSet.addAll(list2);
        return new ArrayList<>(unionSet);
    }

    public static Map<Integer, Integer> frequencyCounter(List<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        //Arrays.asList(1, 2, 2, 3, 1)
        //List<Integer> numbers = new ArrayList<>();

        //numbers.add(1);
        //numbers.add(2);
        //numbers.add(2);
        //numbers.add(3);
        //numbers.add(1);

        for (int number : numbers) {
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        }
        return frequencyMap;
    }

    //Checks if a word contains only unique letters
    //Input: "lamp" → true, "ball" → false

    //Practice in all mode:

    public static boolean hasUniqueLetters(String word) {
        Set<Character> uniqueLetters = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (uniqueLetters.contains(c)) {
                return false;
            }
            uniqueLetters.add(c);
        }
        return true;
    }

    public static boolean hasUniqueLettersWithMap(String word) {
        Map<Character, Boolean> uniqueLetters2 = new HashMap();

        for (char c : word.toCharArray()) {
            if (uniqueLetters2.containsKey(c)) {
                return false;
            }
            uniqueLetters2.put(c, true);
        }
        return true;
    }

    public static boolean hasUniqueLettersWithInteger(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            if (letterCount.containsKey(c)) {
                return false;
            }
            letterCount.put(c, 1);
        }
        return true;
    }

    public static boolean hasUniqueLettersCounting(String word) {
        Map<Character, Integer> lettersCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            lettersCount.put(c, lettersCount.getOrDefault(c, 0) + 1);
        }

        for (int count : lettersCount.values()) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
