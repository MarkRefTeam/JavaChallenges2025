package org.example;


import org.junit.jupiter.api.Test;

import static org.example.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

    @Test
    public void testFindClosestLowerOdd() {
        int[] itemsForBTier = {1, 3, 5, 7, 9, 11};
        int input = 10;

        int result = FindClosestLowerOdd(itemsForBTier,input);
        System.out.println("Closest lower odd is: " + result);
    }



    }



