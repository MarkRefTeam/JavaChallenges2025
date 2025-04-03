package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static List<Integer> party = new ArrayList<>();

    public static void main(String[] args) {


        int[] list1 = {1, 4, 7, 10, 12};
        int[] availableItems = {2, 4, 6, 8, 10};
        int[] items = {3, 6, 10, 15, 22, 7};


        System.out.println("Please enter your number");
        System.out.println("Please choose a number from availableItems: ");


        int input = Integer.parseInt(sc.nextLine());

        boolean found = false;
        int index = -1;

        //Shop:


        for (int i = 0; i < items.length; i++) {
            if (items[i] % 2 == 0 && items[i] > input) {    //Even items + Str.
                index = i;
                found = true;
                break;
            }
        }

        for (int i = 0; i < availableItems.length; i++) {
            if (availableItems[i] == input) {
                found = true;
                index = i;
            }
        }


        for (int i = 0; i < list1.length; i++) {
            if (list1[i] == input) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            System.out.println("The" + input + "th number is " + index);
        } else {
            System.out.println("Dont found in a list");
        }
        sc.close();
    }

    public static int FindClosestLowerOdd(int[] list, int input) {
        int maxOdd = Integer.MIN_VALUE;

        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 != 0 && list[i] < input && list[i] > maxOdd) {
                maxOdd = list[i];
            }
        }
        return maxOdd;
    }

}