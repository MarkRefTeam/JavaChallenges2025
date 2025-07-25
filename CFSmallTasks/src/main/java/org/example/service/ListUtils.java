package org.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtils<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public ListUtils() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int size() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        return list;
    }

    public List<T> getIntersection(ListUtils<T> other) {
        List<T> intersection = new ArrayList<>();

        if (this.head == null || other.head == null) {
            return intersection;
        }

        Set<T> otherSet = new HashSet<>();
        Node<T> currentOther = other.head;
        while (currentOther != null) {
            otherSet.add(currentOther.data);
            currentOther = currentOther.next;
        }

        Node<T> current = this.head;
        while (current != null) {
            if (otherSet.contains(current.data)) {
                intersection.add(current.data);
                otherSet.remove(current.data);
            }
            current = current.next;
        }
        return intersection;
    }

    public boolean hasDuplicates() {
        Set<T> seen = new HashSet<>();
        Node<T> current = head;

        while (current != null) {
            if (!seen.add(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public List<String> reverseWords() {
        List<String> reverseWords = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            String reversed = new StringBuilder((String) current.data).reverse().toString();
            reverseWords.add(reversed);
            current = current.next;
        }
        return reverseWords;
    }

    public List<String> findPalindromes() {
        List<String> palindromes = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            String word = (String) current.data;
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed)) {
                palindromes.add(word);
            }
            current = current.next;
        }
        return palindromes;
    }

    public void buildListFromList(List<T> input) {
        head = null;
        for (T item : input) {
            add(item);
        }
    }

    public void buildListFromString(String input) {
        head = null;
        for (char c : input.toCharArray()) {
            add((T) String.valueOf(c));
        }
    }

    public int countUniqueChars() {
        Set<String> uniques = new HashSet<>();
        Node<T> current = head;

        while (current != null) {
            uniques.add((String) current.data);
            current = current.next;
        }

        return uniques.size();
    }

    public void buildListFromIntegers(List<Integer> input) {
        head = null;
        for (Integer num : input) {
            add((T) num);
        }
    }
}