import java.util.Arrays;

public class DifficultMethods {
    public static void main(String[] args) {

        //That practice was so awesome , it was 3 days with Number_Check but i don't care!
        //I understood when i created the last one :D

        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] numbers2 = {
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 2, 3, 2},
                {2, 2, 2, 2}
        };

        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 2, 3, 2},
                {2, 2, 2, 2}
        };

        int[] result = sumEachRow(numbers2);

        System.out.println("Sum of 2D array : " + sumOf2DArray(numbers));
        System.out.println(Arrays.toString(result));
        System.out.println("Sum of main diagonal: " + sumMainDiagonal(matrix));
        System.out.println("Diagonal difference: " + diagonalDifference(matrix));

    }

    //Gets in a two-dimensional array and returns the sum of all of the numbers.
    //This method receives a two-dimensional array and returns the sum of all elements in it.
    //It uses a nested loop to iterate through all elements and accumulates the sum.

    public static int sumOf2DArray(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    //Gets in a two-dimensional array and returns a one-dimensional one with the sum of the subarrays.
    //This method processes a two-dimensional array and returns a one-dimensional array containing the sum of each row.
    //It iterates through the rows and calculates their sums separately.

    public static int[] sumEachRow(int[][] numbers) {
        int[] sumArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < numbers[i].length; j++) {
                sum += numbers[i][j];
            }
            sumArray[i] = sum;
        }
        return sumArray;
    }

    //Takes in a 2-d array and returns the sum of its main diagonal- you can be sure that it’s an n*n array:
    // This method calculates the sum of the main diagonal of an n × n matrix.
    //It iterates through the matrix, summing up the elements where the row index is equal to the column index.

    public static int sumMainDiagonal(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    //Takes in a 2-d array and returns its diagonal difference,
    //so in the case of the previous array, it should return (1+0+3+2)-(1+0+2+2).
    //This method calculates the absolute difference between the sum of
    //the main diagonal and the sum of the secondary diagonal in a square matrix.
    //It iterates through the matrix, summing up the elements for both diagonals separately,
    //and then returns the absolute difference.

    public static int diagonalDifference(int[][] matrix) {
        int primarySum = 0;
        int secondarySum = 0;

        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
            secondarySum += matrix[i][matrix.length - 1 - i];
        }
        return Math.abs(primarySum - secondarySum);
    }
}

