public class Task1 {

    public static int factorial(int n) {

        //Gets in an integer and returns its factorial
        //3! = 1*2*3
        //5! = 1*2*3*4*5
        //48!= 1*2....*48

        int integer = 1;
        for (int i = 1; i <= n; i++) {
            integer *= i;
        }
        return integer;
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }

    //Gets in an array of booleans and returns a boolean
    //with the value of a1 && a2 && … … && an

    public static boolean Blreturn(boolean[] array) {
        boolean result = true;

        for (boolean value : array) {
            result = result && value;
        }
        return result;
    }

    //TODO ---> Okey i understand!
    //FIXME: ahaaa
}