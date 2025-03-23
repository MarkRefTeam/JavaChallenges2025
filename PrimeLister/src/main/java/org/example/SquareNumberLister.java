package org.example;

import java.util.ArrayList;
import java.util.List;

public class SquareNumberLister {

    /**
     * Generates all perfect square numbers from 1 to n.
     */

    public static List<Integer> generateSquares(int n) {

        // Create an empty list to store the square numbers.

        List<Integer> squares = new ArrayList<>();

        // Loop from 1 to n, square each number, and add to the list.

        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        // Return the list to the caller.

        return squares;
    }
}