package org.example;



import org.junit.jupiter.api.Test;

import static org.example.App.hasXorInPseudo;

public class AppTest {

    @Test
    void testGetThirtyPercent() {

        System.out.println(App.getThirtyPercent(100));
    }

    @Test
    void testGetFortyDotEightPercent() {

        System.out.println(App.getFortyDotEightPercent(100));
    }

    @Test
    void testHasXorInPseudo() {

        //true ^ false ^ true = false;
        boolean[] testArray1 = {true,false,true};
        System.out.println("Test 1: " + hasXorInPseudo(testArray1));

        //true ^ true = false;
        boolean[] testArray2 = {true,true};
        System.out.println("Test 2: " + hasXorInPseudo(testArray2));

        //true ^ false = true;
        boolean[] testArray3 = {true,false};
        System.out.println("Test 3: " + hasXorInPseudo(testArray3));

        //false ^ false ^ false = false;
        boolean[] testArray4 = {false,false,false};
        System.out.println("Test 4: " + hasXorInPseudo(testArray4));

        //true ^ true ^ true = true;
        boolean[] testArray5 = {true,true,true};
        System.out.println("Test 5: " + hasXorInPseudo(testArray5));
    }
}
