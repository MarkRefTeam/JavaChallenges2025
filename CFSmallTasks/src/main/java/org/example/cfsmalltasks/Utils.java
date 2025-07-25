package org.example.cfsmalltasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    //Okey , Lets go!

    public List<String> getIntersection(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1); //list1 elements in a Set!
        List<String> intersection = new ArrayList<>();

        for (String item : list2) {
            if (set1.contains(item)) {
                intersection.add(item);
                set1.remove(item);
            }
        }
        return intersection;
    }

    public List<String> reverseWords(List<String> words) {
        List<String> reverseWords = new ArrayList<>();

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            reverseWords.add(reversed);
        }
        return reverseWords;
    }

    public List<String> findPalindromes(List<String> words) {
        List<String> palindromes = new ArrayList<>();

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public int countUniqueChars(String input) {
        Set<Character> uniques = new HashSet<>();

        for (char ch : input.toCharArray()) {
            uniques.add(ch);
        }
        return uniques.size();
    }

    public boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniques = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniques.add(number)) {
                return true;
            }
        }
        return false;
    }
}