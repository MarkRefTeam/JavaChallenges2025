package org.example;


public class App {

    public static void main(String[] args) {

        System.out.println(countB("dBffBG"));
        System.out.println(countA("AlmALExATetRA"));
        System.out.println(returnHello("helloabcdhelloasvbhellogdvmhello"));

        //Just for reverse:

        String word = "ThereIsNoMoreLifeAtThisPastAndNoMoreLifeAgain";
        String search = "efiLeroMoN";

        int result = countReversedWord(word,search);
        System.out.println("Reversed '" + search + "' found: " + result + "times");

    }

    public static int countB(String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == 'B') {
                count++;
            }
        }
        return count;
    }

    public static int returnHello(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 5; i++) {
            String sub = str.substring(i, i + 5);
            if (sub.equals("hello")) {
                count++;
            }
        }
        return count;
    }

    //Just for practice:

    public static int countA(String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                count++;
            }
        }
        return count;
    }

    //Okey ,try it with reverse!

    public static int countReversedWord(String text, String wordToFind) {

        //Tactic:
        //1: we are searching this word "NoMoreLife" and reverse it! "efiLeroMoN"
        //2: we must search again for the reversed word but in the String word!
        //3: If it's equals, it must grow!
        //4: I think I must return...

        String reversedWord = new StringBuilder(wordToFind).reverse().toString();
        int count = 0;

        for (int i = 0; i <= text.length() - reversedWord.length(); i++) {
            String sub = text.substring(i, i + reversedWord.length());
            if (sub.equals(reversedWord)) {
                count++;
            }
        }
        return count;
    }
}
