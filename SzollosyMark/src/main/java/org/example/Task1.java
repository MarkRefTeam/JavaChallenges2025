package org.example;


import java.util.Scanner;

public class App {

    //Ohhh the String homework :)

    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Give a text");
        String input = sc.nextLine();

        int count = 0;
        for(char c : input.toCharArray()) {
            if(c == 's') {
                count++;
            }
        }
        System.out.println("the 'S' number in the words is : " + count);





    }
}
