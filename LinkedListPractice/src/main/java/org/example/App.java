package org.example;

import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();

        numbers.add(2);
        numbers.add(5);
        numbers.add(100);
        numbers.add(155);

        System.out.println(numbers);
    }
}
