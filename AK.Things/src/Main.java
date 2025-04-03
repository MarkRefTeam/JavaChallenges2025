import java.util.Scanner;

public class Main {

    //Field (static and low)

    static int value = 7;
    //Class-Level variable ! osztályszintű változó , a Main-hez tartozó érték!

    int value2 = 0;
    //instance-level variable ! példányszíntű változó , példányhoz tartozó érték!

    static boolean flag = true;

    static String MyFirstString = "You will succes";

    public static void main(String[] args) { //String[] args - paraméterváltozó
        Scanner scanner = new Scanner(System.in);

        int x = 3; //Local variable - lokális változó
        System.out.println(x);
        System.out.println(value);

        //System.out.println(value2); // fordítási hiba

        //Println - egymás alá rendezi a szöveget!

        System.out.println("Restart the school program");
        System.out.println("You can do it");
        System.out.println("Just trust yourself");

        //Print - egy sorban fogja csak a szöveget feltűntetni!

        System.out.print("Long or longer text in same line");

        //Ctrl+shift up/down

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);

        long a = 123; //2*64 számot tud tárolni!
        char ch = 'y';
        char ch2 = ' ';
        char ch3 = 'k';

        //char can be only one ward! Csak egy betű lehet!

        System.out.println(a);
        System.out.println(ch);
        System.out.println(ch2);
        System.out.println(ch3);

        //Primitive Types

        byte number1 = 123;
        short number2 = 10000;
        int number3 = 10000000;
        long number4 = 1000005667878879L;
        char myCharacter = 'a';
        float myFloat = 3.14F;
        double myDouble = 3.14;
        boolean myBoolean = false;

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);
        System.out.println(myCharacter);
        System.out.println(myFloat);
        System.out.println(myDouble);
        System.out.println(myBoolean);

        System.out.println(flag);
        System.out.println(MyFirstString);


        scanner.close();
    }
}





