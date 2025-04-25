package org.example;

public class ForWhileDO {

    public static void main(String[] args) {
        int sumFor = 0;
        for (int i = 1; i < 5; i++) {
            sumFor += i;
            System.out.println("sumFor = " + sumFor);

            int sumWhile = 0;
            int j = 1;
            while (j < 5) {
                sumWhile += j;
                j++;
            }
            System.out.println("sumWhile = " + sumWhile);
        }

        int sumDoWhile = 0;
        int k = 1;
        do {
            sumDoWhile += k;
            k++;
        } while (k < 5);
        System.out.println("sumDoWhile = " + sumDoWhile);
    }

    public static int sumWithForLoop(int i) {
        int sum = 0;
        int max = 10;
        for (int j = 0; j <= max; j++) {
            sum += i;
        }
        return sum;
    }

    public static int sumWithWhileLoop(int max) {
        int sum = 0;
        int j = 1;

        while (j <= max) {
            sum += j;
            j++;
        }
        return sum;
    }

    public static int sumWithDoWhileLoop(int i) {
        int sum = 0;
        int l = 1;
        int max = 5;

        do {
            sum += l;
            l++;
        } while (l <= max);
        return sum;
    }

    public static int sumEvenNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int youMustUnderstand(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int calculateSomething(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    public static int calculateSomething2(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    public static int sumDivisibleByThree(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sumSkipMultiplesOfSix() {
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 6 == 0) {
                continue;
            }
            sum += i;
        }
        return sum;
    }

    public static int sumSkippingSixMultiples(int limit) {
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 6 == 0) {
                continue;
            }
            sum += i;
        }
        return sum;
    }

    public static int sumOddNotDivisibleByFive(int Limit) {
        int sum = 0;
        for (int i = 1; i <= Limit; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                continue;
            }
            sum += i;
            System.out.println("i =" + i);
        }
        return sum;
    }

    public static int SumSpecialNumbers(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            if (i % 2 != 0 && i % 4 != 0 && !String.valueOf(i).contains("8")) {
                continue;
            }
            sum += i;
        }
        return sum;
    }

    public static int calculateCrazyCombo(int limit) {
        int sum = 0;

        for (int i = 1; i <= limit; i++) {
            int temp = i;
            boolean hasFive = false;

            while (temp > 0) {
                if (temp % 10 == 5) {
                    hasFive = true;
                    break;
                }
                temp /= 10;
            }

            if (i % 3 != 0 || hasFive) {
                continue;
            }

            boolean shouldAdd = i > 0;
            if (shouldAdd) {
                System.out.println("give " + i);
                sum += i;
            }

            if (i % 7 == 0 && i < limit / 2) {
                System.out.println("BREAK, i: " + i);
                break;
            }
        }
        return sum;
    }

    public static boolean hasEvenDivisibleByThree(int[] numbers) {
        boolean flag = false;

        for (int num : numbers) {
            if (num % 2 == 0 && num % 3 == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean hasNegativeDivisibleByFour(int[] numbers) {
        boolean flag = false;

        for (int num : numbers) {
            if (num < 0 && num % 4 == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean hasEvenDivisibleByTwo(int[] numbers) {
        boolean flag = false;

        for (int num : numbers) {
            if (num % 2 == 0) {
                flag = true;
                continue;
            }
            if (num % 4 != 0) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static boolean hasDivisibleByTwoOrThree(int[] numbers) {
        boolean flag = false;

        for (int num : numbers) {
            if (num % 2 == 0 || num % 3 == 0) {
                flag = true;
                continue;
            }
            if (num % 6 != 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int findFirstDivisibleByThree(int[] numbers) {
        int i = 0;

        while (i < numbers.length) {
            if (numbers[i] % 3 == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int findFirstEvenNotDivisibleByThree(int[] numbers) {
        int i = 0;

        while (i < numbers.length) {
            if (numbers[i] % 2 == 0) {
                return i;
            }
            if (numbers[i] % 3 != 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean hasFindFirstEvenNotDivisibleByThree2(int[] numbers) {
        boolean flag = false;

        for (int num : numbers) {
            if (num % 2 == 0 && num % 3 != 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean hasEvenGreaterThanTen(int[] numbers) {
        boolean flag = false;
        int i = 0;

        do {
            if (numbers[i] % 2 == 0 && numbers[i] > 10) {
                flag = true;
                System.out.println("Found a matching number: " + numbers[i]);
                break;
            }
            i++;
        } while (i < numbers.length);
        return flag;
    }

    public static int FindMaxOdd(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int i = 0;

        while (i < numbers.length) {
            if (numbers[i] % 2 != 0 && numbers[i] % 3 == 0 && numbers[i] > max) {
                max = numbers[i];
            }
            i++;
        }
        return max;
    }
}
